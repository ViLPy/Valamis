package com.arcusys.valamis.util.mustache

import scala.annotation.tailrec
import scala.collection.MapLike
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Awaitable}

trait ContextHandler {

   protected def defaultRender(
     otag: String, ctag: String): (Any, Map[String, Mustache], List[Any]) => (String) => String =
     (context: Any, partials: Map[String, Mustache], callstack: List[Any]) => (str: String) => {
       val t = new Mustache(str, otag, ctag)
       t.render(context, partials, callstack)
     }

   def valueOf(key: String, context: Any, partials: Map[String, Mustache], callstack: List[Any], childrenString: String, render: (Any, Map[String, Mustache], List[Any]) => (String) => String): Any =
     {
       val r = render(context, partials, callstack)

       val wrappedEval =
         callstack.filter(_.isInstanceOf[Mustache]).asInstanceOf[List[Mustache]].foldLeft(() => {
           eval(findInContext(context :: callstack, key), childrenString, r)
         })((f, e) => { () => { e.withContextAndRenderFn(context, r)(f()) } })
       wrappedEval() match {
         case None if key == "." => context
         case other              => other
       }
     }

   @tailrec
   private def eval(
     value: Any, childrenString: String, render: (String) => String): Any =
     value match {
       case Some(someValue) => eval(someValue, childrenString, render)

       case a: Awaitable[_] =>
         eval(Await.result(a, Duration.Inf), childrenString, render)

       case f: Function0[_] =>
         eval(f(), childrenString, render)

       case s: Seq[_]           => s

       case m: MapLike[_, _, _] => m

       case f: Function1[String, _] =>
         eval(f(childrenString), childrenString, render)

       case f: Function2[String, Function1[String, String], _] =>
         eval(f(childrenString, render), childrenString, render)

       case other => other
     }

   @tailrec
   private def findInContext(stack: List[Any], key: String): Any =
     stack.headOption match {
       case None => None
       case Some(head) =>
         (head match {
           case null => None
           case m: MapLike[String, _, _] =>
             m.get(key) match {
               case Some(v) => v
               case None    => None
             }
           case m: Mustache =>
             m.globals.get(key) match {
               case Some(v) => v
               case None    => None
             }
           case any => reflection(any, key)
         }) match {
           case None => findInContext(stack.tail, key)
           case x    => x
         }
     }

   private def reflection(x: Any, key: String): Any = {
     val w = wrapped(x)
     (methods(w).get(key), fields(w).get(key)) match {
       case (Some(m), _)    => m.invoke(w)
       case (None, Some(f)) => f.get(w)
       case _               => None
     }
   }

   private def fields(w: AnyRef) = Map(
     w.getClass().getFields.map(x => { x.getName -> x }): _*
   )

   private def methods(w: AnyRef) = Map(
     w.getClass().getMethods
       .filter(x => { x.getParameterTypes.length == 0 })
       .map(x => { x.getName -> x }): _*
   )

   private def wrapped(x: Any): AnyRef =
     x match {
       case x: Byte    => byte2Byte(x)
       case x: Short   => short2Short(x)
       case x: Char    => char2Character(x)
       case x: Int     => int2Integer(x)
       case x: Long    => long2Long(x)
       case x: Float   => float2Float(x)
       case x: Double  => double2Double(x)
       case x: Boolean => boolean2Boolean(x)
       case _          => x.asInstanceOf[AnyRef]
     }
 }

package com.arcusys.valamis.util.mustache

case class SectionToken(
     inverted: Boolean, key: String, children: List[Token], startOTag: String, startCTag: String, endOTag: String, endCTag: String) extends Token with ContextHandler with CompositeToken {

        private val childrenSource = children.map(_.templateSource).mkString

        private val source = startOTag + (if (inverted) "^" else "#") + key +
          startCTag + childrenSource + endOTag + "/" + key + endCTag

        private val childrenTemplate = {
          val root = if (children.size == 1) children(0)
          else RootToken(children)
          new Mustache(root)
        }

        def render(context: Any, partials: Map[String, Mustache], callstack: List[Any]): TokenProduct =
          valueOf(key, context, partials, callstack, childrenSource, renderContent
          ) match {
            case null =>
              if (inverted) composite(children, context, partials, context :: callstack)
              else EmptyProduct
            case None =>
              if (inverted) composite(children, context, partials, context :: callstack)
              else EmptyProduct
            case b: Boolean =>
              if (b ^ inverted) composite(children, context, partials, context :: callstack)
              else EmptyProduct
            case s: Seq[_] if (inverted) =>
              if (s.isEmpty) composite(children, context, partials, context :: callstack)
              else EmptyProduct
            case s: Seq[_] if (!inverted) => {
              val tasks = for (element <- s; token <- children) yield (token, element)
              composite(tasks, partials, context :: callstack)
            }
            case str: String =>
              if (!inverted) StringProduct(str)
              else EmptyProduct

            case other =>
              if (!inverted) composite(children, other, partials, context :: callstack)
              else EmptyProduct
          }

        private def renderContent(context: Any, partials: Map[String, Mustache], callstack: List[Any])(template: String): String =
          // it will be children nodes in most cases
          // TODO: some cache for dynamically generated templates?
          if (template == childrenSource)
            childrenTemplate.render(context, partials, context :: callstack)
          else {
            val t = new Mustache(template, startOTag, startCTag)
            t.render(context, partials, context :: callstack)
          }

        def templateSource: String = source
      }

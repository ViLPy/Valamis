package com.arcusys.scorm.lms

/**
 * Created with IntelliJ IDEA.
 * User: iliya.tryapitsin
 * Date: 10.01.14
 * Time: 17:12
 * To change this template use File | Settings | File Templates.
 */
trait ActivityRepositoryContract {
  def get(): scala.collection.mutable.Buffer[String]
}

package com.arcusys.learn

/**
 * Created by Iliya Tryapitsin on 28.04.2014.
 */
trait BaseSqlRepository[E] {
  def execute(sqlKey: String, parameters: (String, Any)*)

  def select(sqlKey: String, parameters: (String, Any)*): Seq[E]

  def find(sqlKey: String, parameters: (String, Any)*): Option[E]
}

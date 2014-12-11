package com.arcusys.learn.repositories

/**
 * Created by Iliya Tryapitsin on 14.05.2014.
 */
abstract trait SelectEntityRepository[E] {
  def select(keys: (String, Any)*): Seq[E]
}

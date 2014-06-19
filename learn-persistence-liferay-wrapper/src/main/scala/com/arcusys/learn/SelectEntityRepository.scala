package com.arcusys.learn

/**
 * Created by Iliya Tryapitsin on 14.05.2014.
 */
abstract trait SelectEntityRepository[E] {
  def select(keys: (String, Any)*): Seq[E]
}

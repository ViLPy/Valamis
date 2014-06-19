package com.arcusys.learn.facades

/**
 * Created by Iliya Tryapitsin on 16.04.2014.
 */
trait Paginator {
  def takeForPage[T](list: Seq[T],
    skip: Int,
    take: Int,
    sortAZ: Boolean): Seq[T] =
    (if (sortAZ) list else list.reverse)
      .drop(skip)
      .take(take)
}

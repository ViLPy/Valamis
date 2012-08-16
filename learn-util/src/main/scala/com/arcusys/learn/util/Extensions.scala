package com.arcusys.learn.util

object Extensions {
  implicit def oneOf[T](element: T) = new {
    def oneOf(collection: T*): Boolean = collection.contains(element)
    def noneOf(collection: T*) : Boolean = !collection.contains(element)
  }

  implicit def between(number: BigDecimal) = new {
    def between(lower: BigDecimal, upper: BigDecimal): Boolean = number >= lower && number <= upper
  }
}

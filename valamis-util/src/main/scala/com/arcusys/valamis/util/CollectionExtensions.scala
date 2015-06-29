package com.arcusys.valamis.util

object CollectionExtensions {
  implicit class OneOf[T](val element: T) extends AnyVal {
    def oneOf(collection: T*): Boolean = collection.contains(element)
    def noneOf(collection: T*): Boolean = !collection.contains(element)
  }

  implicit class Between(val number: BigDecimal) extends AnyVal {
    def between(lower: BigDecimal, upper: BigDecimal): Boolean = number >= lower && number <= upper
  }
}

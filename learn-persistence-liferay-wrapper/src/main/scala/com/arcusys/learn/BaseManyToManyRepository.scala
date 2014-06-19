package com.arcusys.learn

/**
 * Created by Iliya Tryapitsin on 13.05.2014.
 */
abstract trait BaseManyToManyRepository[LeftType, RightType] {
  def create(left: LeftType, right: RightType)
  def delete(left: LeftType, right: RightType)
  def getLeft(left: LeftType): Seq[RightType]
  def getRight(right: RightType): Seq[LeftType]
}

abstract trait BaseExtManyToManyRepository[LeftType, RightType] extends BaseManyToManyRepository[LeftType, RightType] {
  def change(left: LeftType, right: RightType)
}

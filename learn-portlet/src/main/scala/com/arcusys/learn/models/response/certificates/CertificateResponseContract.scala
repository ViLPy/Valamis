package com.arcusys.learn.models.response.certificates

/**
 * Created by Iliya Tryapitsin on 02.06.2014.
 */
trait CertificateResponseContract {
  val id: Int
  val title: String
  val shortDescription: String
  val description: String
  val logo: String
  val isPublished: Boolean
}

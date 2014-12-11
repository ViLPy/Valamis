package com.arcusys.learn.models.valamispackage

import com.arcusys.learn.scorm.manifest.model.PeriodType.PeriodType
import org.json4s.{ DefaultFormats, Extraction, CustomSerializer }
import org.json4s.JsonAST.JValue
import org.json4s.jackson.JsonMethods._

/**
 * Created by igorborisov on 07.10.14.
 */
case class PackageModel(id: Int, title: String, description: Option[String],
  version: Option[String], visibility: Boolean,
  isDefault: Boolean, packageType: String, logo: Option[String], suspendedID: Option[String],
  passingLimit: Int, rerunInterval: Int, rerunIntervalType: String, attemptCount: Int)

case class PackageUploadModel(id: Int, title: String, description: String, packageType: String, logo: String)

class PackageSerializer extends CustomSerializer[PackageUploadModel](implicit format => ({
  case jValue: JValue =>
    PackageUploadModel(
      jValue.\("id").extract[Int],
      jValue.\("title").extract[String],
      jValue.\("description").extract[String],
      jValue.\("packageType").extract[String],
      jValue.\("logo").extract[String]
    )
}, {
  case pack: PackageUploadModel => render(Extraction.decompose(pack)(DefaultFormats))

}))

object PackageSortBy extends Enumeration {
  type PackageSortBy = Value
  val Name, Date = Value
  def apply(v: String): PackageSortBy = v.toLowerCase() match {
    case "name" => Name
    case "date" => Date
    case _      => throw new IllegalArgumentException()
  }
}
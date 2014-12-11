package com.arcusys.learn.bl.services

import com.arcusys.learn.bl.ioc.DomainConfiguration
import com.arcusys.learn.liferay.services.UserLocalServiceHelper
import com.arcusys.learn.scorm.manifest.model.PackageType
import com.arcusys.learn.tincan.lrs.statement.{ StatementFilter, StatementLRS }
import com.arcusys.learn.tincan.model.{ Agent, TincanURIType, Statement }
import com.arcusys.learn.tincan.storage.StatementStorage
import com.escalatesoft.subcut.inject.{ Injectable, BindingModule }

/**
 * Created by igorborisov on 15.10.14.
 */
class GradeBookService(configuration: BindingModule) extends Injectable with GradeBookServiceContract {
  def this() = this(DomainConfiguration)
  implicit val bindingModule = configuration

  val packageService = inject[ValamisPackageServiceContract]
  val uriService = inject[URIServiceContract]

  def getStatementGrades(packageId: Int, valamisUserId: Int, sortAsc: Boolean = false): Seq[Statement] = {
    val statementLRS = new StatementLRS() {
      val statementStorage = inject[StatementStorage]
    }

    val email = "mailto:" + UserLocalServiceHelper()
      .getUser(valamisUserId)
      .getEmailAddress

    packageService.getPackageType(packageId) match {
      case PackageType.SCORM => {
        val packageUri = uriService.getURI(packageId.toString, TincanURIType.Package)
        val filter = StatementFilter(
          agent = Option(Agent(objectType = "Agent", name = None, mbox = Option(email), mbox_sha1sum = None, openid = None, account = None, storedId = None)),
          activity = if (packageUri.isDefined) Option(packageUri.get.uri) else Option(packageId.toString),
          relatedActivities = Option(true))

        if (!sortAsc)
          statementLRS
            .getStatements(filter)
            .statements.sortBy(st => st.timestamp).reverse
        else
          statementLRS
            .getStatements(filter)
            .statements.sortBy(st => st.timestamp)
      }

      case PackageType.TINCAN => {
        // TODO: Rewrite filter to work the same way with SCORM and TINCAN stataments
        val packageUri = uriService.getURI(packageId.toString, TincanURIType.Package)
        val filter = StatementFilter(
          agent = Option(Agent(objectType = "Agent", name = None, mbox = Option(email), mbox_sha1sum = None, openid = None, account = None, storedId = None)),
          activity = if (packageUri.isDefined) Option(packageUri.get.uri) else Option(packageId.toString),
          relatedActivities = Option(true))

        val statements1 = statementLRS
          .getStatements(filter)
          .statements
        val statements2 = packageService
          .getManifestActivities(packageId)
          .map(manifestActivity => {
            val filter = StatementFilter(
              agent = Option(Agent(objectType = "Agent", name = None, mbox = Option(email), mbox_sha1sum = None, openid = None, account = None, storedId = None)),
              activity = Option(manifestActivity.tincanId.toString),
              relatedActivities = Option(true))

            statementLRS
              .getStatements(filter)
              .statements
          })
          .flatMap(seq => seq)
        if (!sortAsc)
          (statements1 ++ statements2).sortBy(st => st.timestamp).reverse
        else
          (statements1 ++ statements2).sortBy(st => st.timestamp)
      }
    }
  }

}

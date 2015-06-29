package com.arcusys.learn.liferay.update.migration

import java.net.URLDecoder

import com.arcusys.valamis.certificate.model.{CertificateStatus, CertificateState, Certificate}
import com.arcusys.valamis.certificate.model.goal.{StatementGoal, PackageGoal, CourseGoal, ActivityGoal}
import com.arcusys.valamis.certificate.schema._
import com.arcusys.valamis.core.SlickProfile
import com.arcusys.valamis.model.PeriodTypes
import org.joda.time.DateTime
import scala.slick.driver.JdbcProfile
import scala.slick.jdbc.{StaticQuery, GetResult, JdbcBackend}

class CertificateStorageMigration2303(
    val db: JdbcBackend#DatabaseDef, val driver: JdbcProfile)
  extends CertificateTableComponent
  with ActivityGoalTableComponent
  with CourseGoalTableComponent
  with PackageGoalTableComponent
  with StatementGoalTableComponent
  with CertificateStateTableComponent
  with SlickProfile {
  import driver.simple._

  def migrate(): Unit = {
    db.withTransaction { implicit session =>
      implicit val getCertificate = GetResult { r => Certificate(
        id = r.nextInt(),                                      //        id_ bigint NOT NULL,
        title = r.nextString(),                                //        title character varying(3000),
        description = r.nextString(),                          //        description text,
        logo = r.nextString(),                                 //        logo character varying(512),
        isPermanent = r.nextBoolean(),                         //        ispermanent boolean,
        isPublishBadge = r.nextBoolean(),                      //        publishbadge boolean,
        shortDescription = r.nextString(),                     //        shortdescription character varying(512),
        companyId = r.nextInt(),                               //        companyid integer,
        validPeriodType = PeriodTypes.withName(r.nextString()), //        validperiodtype character varying(512),
        validPeriod = r.nextInt(),                             //        validperiod integer,
        createdAt = new DateTime(r.nextDate()),                //        createddate timestamp without time zone,
        isPublished = r.nextBoolean(),                         //        ispublished boolean,
        scope = r.nextLongOption()                             //        scope bigint,
      )
      }

      implicit val getActivityGoal = GetResult { r => ActivityGoal(
        certificateId = r.nextInt(),                      //        certificateid bigint NOT NULL,
        activityName = r.nextString(),                    //        activityname character varying(75) NOT NULL,
        count = r.nextInt(),                              //        datacount integer,
        periodType = PeriodTypes.withName(r.nextString()), //        periodtype character varying(512),
        periodValue = r.nextInt()                         //        period integer,
      )
      }

      implicit val getCourseGoal = GetResult { r => CourseGoal(
        certificateId = r.nextInt(),                      //        certificateid bigint NOT NULL,
        courseId = r.nextLong,                            //        courseid bigint NOT NULL,
        arrangementIndex = r.nextInt(),                   //        arrangementindex integer,
        periodType = PeriodTypes.withName(r.nextString()), //        periodtype character varying(512),
        periodValue = r.nextInt()                         //        period integer,
      )
      }

      implicit val getPackageGoal = GetResult { r => PackageGoal(
        certificateId = r.nextInt(),                      //      certificateid bigint NOT NULL,
        packageId = r.nextLong(),                         //      packageid bigint NOT NULL,
        periodType = PeriodTypes.withName(r.nextString()), //      periodtype character varying(75),
        periodValue = r.nextInt()                         //      period integer,
      )
      }

      implicit val getStatementGoal = GetResult { r => StatementGoal(
        certificateId = r.nextLong(),                     //      certificateid bigint NOT NULL,
        verb = r.nextString(),                            //      verb character varying(75) NOT NULL,
        obj = r.nextString(),                             //      object character varying(75) NOT NULL,
        periodType = PeriodTypes.withName(r.nextString()), //      periodtype character varying(75),
        periodValue = r.nextInt()                         //      period integer,
      )
      }

      implicit val getCertificateToUser = GetResult { r =>
        val certificateId = r.nextInt()
        val userId = r.nextInt()
        val userJoinedDate = new DateTime(r.nextDate())
        CertificateState(
          certificateId = certificateId,                  //      certificateid bigint NOT NULL,
          userId = userId,                                //      userid bigint NOT NULL,
          userJoinedDate = userJoinedDate,                //     attacheddate timestamp without time zone,
          statusAcquiredDate = userJoinedDate,
          status = CertificateStatus.InProgress
        )
      }

      val columns = "id_, title, description, logo, isPermanent, publishBadge, shortDescription, companyID, validPeriodType, validPeriod, createdDate, isPublished, scope"
      StaticQuery.queryNA[Certificate](s"SELECT $columns FROM Learn_LFCertificate")
        .list
        .map { certificate =>
        val newDescription = URLDecoder.decode(certificate.description, "UTF-8")
        val id = (certificates returning certificates.map(_.id)).insert(certificate.copy(description = newDescription))

        StaticQuery.queryNA[ActivityGoal]("SELECT certificateID, activityName, datacount, periodType, period FROM Learn_LFCertificateActivity")
          .list
          .map { aG => activityGoals.insert(aG.copy(certificateId = certificate.id)) }

        StaticQuery.queryNA[CourseGoal]("SELECT certificateID, courseID, arrangementIndex, periodType, period FROM Learn_LFCertificateCourse")
          .list
          .map { cG => courseGoals.insert(cG.copy(certificateId = certificate.id.toLong)) }

        StaticQuery.queryNA[PackageGoal]("SELECT certificateID, packageID, periodType, period FROM Learn_LFCertificatePackageGoal")
          .list
          .map { pG => packageGoals.insert(pG.copy(certificateId = certificate.id.toLong)) }

        StaticQuery.queryNA[StatementGoal]("SELECT certificateID, verb, object, periodType, period FROM Learn_LFCertTCStmnt")
          .list
          .map { sG => statementGoals.insert(sG.copy(certificateId = certificate.id.toLong)) }

        StaticQuery.queryNA[CertificateState]("SELECT certificateID, userID, attachedDate FROM Learn_LFCertificateUser")
          .list
          .map { cS => certificateStates.insert(cS.copy(certificateId = certificate.id)) }
      }
    }
  }
}

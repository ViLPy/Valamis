package com.arcusys.learn.ioc

import com.arcusys.learn.facades._
import com.arcusys.learn.facades.certificate.CertificateFacade
import com.arcusys.learn.facades.tincan.{ TincanTestFacade, TincanTestFacadeContract }
import com.arcusys.learn.liferay.services.UserLocalServiceHelper
import com.arcusys.learn.notifications.MessageTemplateLoader
import com.arcusys.learn.notifications.services.ResourceTemplateLoader
import com.arcusys.learn.scorm.tracking.model.sequencing._
import com.arcusys.learn.service.util.{ SessionHandler, SessionHandlerContract }
import com.arcusys.scorm.lms._
import com.escalatesoft.subcut.inject.NewBindingModule

/**
 * Created by igorborisov on 20.10.14.
 */
object WebConfiguration extends NewBindingModule({
  implicit module =>
    import module._

    // -------------FACADES----------------------------------
    bind[CertificateFacadeContract].toSingle(new CertificateFacade)
    bind[FileFacadeContract].toSingle(new FileFacade)
    bind[RoleFacadeContract].toSingle(new RoleFacade)
    bind[CategoryFacadeContract].toSingle(new CategoryFacade)
    bind[QuestionFacadeContract].toSingle(new QuestionFacade)
    bind[GradebookFacadeContract].toSingle(new GradebookFacade)
    //    bind[ScoreManagerContract].toSingle(new ScoreManager)
    bind[ReportFacadeContract].toSingle(new ReportFacade)
    bind[CourseFacadeContract].toSingle(new CourseFacade)
    bind[UserFacadeContract].toSingle(new UserFacade)
    bind[PackageFacadeContract].toSingle(new PackageFacade)
    bind[QuizFacadeContract].toSingle(new QuizFacade)
    bind[URIFacadeContract] toSingle new URIFacade
    bind[TranscriptPrintFacadeContract].toSingle(new TranscriptPrintFacade)

    //TODO ???
    bind[TincanTestFacadeContract] toSingle new TincanTestFacade

    // END----------FACADES----------------------------------

    // -------------SERVICES----------------------------------
    bind[NavigationRequestServiceContract] toSingle new NavigationRequestService
    bind[TerminationRequestServiceContract] toSingle new TerminationRequestService
    bind[SequencingRequestServiceContract] toSingle new SequencingRequestService
    bind[DeliveryRequestServiceContract] toSingle new DeliveryRequestService
    bind[RollupServiceContract] toSingle new RollupService
    bind[EndAttemptServiceContract] toSingle new EndAttemptService

    // END----------SERVICES----------------------------------

    // -------------OTHER----------------------------------
    bind[ClientApiStoreManagerContract] toSingle new ClientApiStoreManager
    bind[UserManagement].toSingle(new UserManagement)
    bind[UserLocalServiceHelper] toSingle UserLocalServiceHelper()
    bind[SessionHandlerContract] toSingle SessionHandler
    bind[PackageService].toSingle(new PackageService)
    bind[MessageTemplateLoader].toSingle(ResourceTemplateLoader)

  // END----------OTHER----------------------------------

})


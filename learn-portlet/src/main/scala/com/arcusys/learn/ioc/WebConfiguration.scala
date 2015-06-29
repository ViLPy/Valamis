package com.arcusys.learn.ioc

import com.arcusys.learn.PersistenceLFConfiguration
import com.arcusys.learn.controllers.api.social.{ActivityInterpreter, ActivityInterpreterImpl}
import com.arcusys.learn.facades._
import com.arcusys.learn.facades.certificate.CertificateFacade
import com.arcusys.learn.liferay.activity.{StatementActivityCreatorImpl, StatementActivityCreator}
import com.arcusys.learn.liferay.services.UserLocalServiceHelper
import com.arcusys.learn.notifications.MessageTemplateLoader
import com.arcusys.learn.notifications.services.ResourceTemplateLoader
import com.arcusys.learn.service.SlickDBInfoLiferayImpl
import com.arcusys.learn.utils.{PresentationProcessor, PresentationProcessorContract}
import com.arcusys.valamis.certificate.service._
import com.arcusys.valamis.lesson.service.ActivityService
import com.arcusys.valamis.social
import com.arcusys.valamis.file.service.{FileEntryService, FileEntryServiceImpl, FileService, FileServiceImpl}
import com.arcusys.valamis.gradebook.service.{CourseGradeService, CourseGradeServiceImpl, GradeBookService, GradeBookServiceImpl}
import com.arcusys.valamis.lesson.generator.tincan.file.{TinCanRevealJSPackageGenerator, TinCanRevealJSPackageGeneratorContract}
import com.arcusys.valamis.lesson.scorm.service.sequencing._
import com.arcusys.valamis.lesson.service.{PackageService, _}
import com.arcusys.valamis.lrs.service._
import com.arcusys.valamis.lrsEndpoint.service.{LrsEndpointService, LrsEndpointServiceImpl}
import com.arcusys.valamis.questionbank.service.{QuestionService, QuestionServiceImpl}
import com.arcusys.valamis.quiz.service.{QuizService, QuizServiceImpl}
import com.arcusys.valamis.settings.service._
import com.arcusys.valamis.slide.service._
import com.arcusys.valamis.slide.service.export._
import com.arcusys.valamis.uri.service.{URIService, URIServiceContract}
import com.arcusys.valamis.user.service.{UserService, UserServiceImpl}
import com.escalatesoft.subcut.inject.NewBindingModule


object WebConfiguration extends NewBindingModule(implicit module => {
    import module._

    module <~ new PersistenceSlickConfiguration(new SlickDBInfoLiferayImpl)
    module <~ new PersistenceLFConfiguration

    // -------------FACADES----------------------------------
    bind[CertificateFacadeContract].toSingle(new CertificateFacade)
    bind[FileFacadeContract].toSingle(new FileFacade)
    bind[CategoryFacadeContract].toSingle(new CategoryFacade)
    bind[QuestionFacadeContract].toSingle(new QuestionFacade)
    bind[GradebookFacadeContract].toSingle(new GradebookFacade)
    bind[ReportFacadeContract].toSingle(new ReportFacade)
    bind[CourseFacadeContract].toSingle(new CourseFacade)
    bind[UserFacadeContract].toSingle(new UserFacade)
    bind[PackageFacadeContract].toSingle(new PackageFacade)
    bind[QuizFacadeContract].toSingle(new QuizFacade)
    bind[TranscriptPrintFacadeContract].toSingle(new TranscriptPrintFacade)
    bind[TagFacadeContract].toSingle(new TagFacade)

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
    bind[UserLocalServiceHelper] toSingle UserLocalServiceHelper()
    bind[PackageService].toSingle(new PackageService)
    bind[MessageTemplateLoader].toSingle(ResourceTemplateLoader)

    // END----------OTHER----------------------------------

    // -------------BL-SERVICES----------------------------------

    bind[CertificateService] toSingle new CertificateServiceImpl
    bind[CourseGradeService] toSingle new CourseGradeServiceImpl
    bind[FileService] toSingle new FileServiceImpl
    bind[GradeBookService] toSingle new GradeBookServiceImpl
    bind[LRSToActivitySettingService] toSingle new LRSToActivitySettingServiceImpl
    bind[QuestionService].toSingle(new QuestionServiceImpl)
    bind[QuizService].toSingle(new QuizServiceImpl)
    bind[TagServiceContract].toSingle(new TagService)
    bind[URIServiceContract].toSingle(new URIService)
    bind[UserService].toSingle(new UserServiceImpl)
    bind[ValamisPackageService].toSingle(new ValamisPackageServiceImpl)
    bind[FileEntryService].toSingle(new FileEntryServiceImpl)
    bind[SlideSetServiceContract].toSingle(new SlideSetService)
    bind[SlideServiceContract].toSingle(new SlideService)
    bind[SlideElementServiceContract].toSingle(new SlideElementService)

    //tincan
    bind[LrsClientManager].toSingle(new LrsClientManagerImpl)
    bind[LrsOAuthService].toSingle(new LrsOAuthServiceImpl)

    //lesson
    bind[LrsEndpointService].toSingle(new LrsEndpointServiceImpl)
    bind[ActivityServiceContract].toSingle(new ActivityService)

    bind[SettingService] toSingle new SettingServiceImpl
    bind[SiteDependentSettingServiceImpl] toSingle new SiteDependentSettingServiceImpl

    bind[PresentationProcessorContract] toSingle PresentationProcessor

    // END----------BL-SERVICES----------------------------------

    // -------------OTHER----------------------------------

    bind[PackageUploadManager] toSingle new PackageUploadManager

    bind[CertificateStatusChecker] toSingle new CertificateStatusCheckerImpl
    bind[CertificateCompletionChecker].toSingle(new CertificateCompletionCheckerImpl)

    bind[LessonLimitChecker].toSingle(new LessonLimitChecker)
    bind[PlayerScopeRuleManager].toSingle(new PlayerScopeRuleManager)
    bind[TinCanRevealJSPackageGeneratorContract].toSingle(TinCanRevealJSPackageGenerator)

    bind[SlideSetExporterContract].toSingle(new SlideSetExporter)
    bind[SlideSetImporterContract].toSingle(new SlideSetImporter)
    bind[SlideSetPublisherContract].toSingle(new SlideSetPublisher)

    bind[StatementActivityCreator].toSingle(new StatementActivityCreatorImpl)
    bind[CertificateStateService].toSingle(new CertificateStateServiceImpl)

    bind[social.service.CommentService].toSingle(new social.service.CommentServiceImpl)
    bind[social.service.LikeService].toSingle(new social.service.LikeServiceImpl)
    bind[social.service.ActivityService].toSingle(new social.service.ActivityServiceImpl)
    bind[ActivityInterpreter].toSingle(new ActivityInterpreterImpl)
})



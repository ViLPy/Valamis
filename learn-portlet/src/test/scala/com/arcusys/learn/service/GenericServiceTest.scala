package com.arcusys.learn.service

import com.arcusys.learn.questionbank.service._
import com.arcusys.learn.quiz.service._
import com.arcusys.learn.scorm.manifest.service._
import com.arcusys.learn.scorm.rte.service._
import org.junit._
import com.arcusys.learn.controllers.api.{ GradebookApiController, CategoryApiController, FileApiController, AdminApiController }
import com.arcusys.learn.facades.GradebookFacade

class GenericServiceTest {
  @Test
  def allServicesHaveNoArgsConstructor() {
    new AdminApiController
    new FileApiController
    new GradebookApiController
    new CategoryApiController

    new QuestionService

    new GeneratedPackagesService
    new QuizCategoryService
    new QuizQuestionService
    new QuizService

    new ActivitiesService
    new OrganizationsService
    new PackagesService

    new RunTimeEnvironment
    new SequencingService

    new GradebookFacade
  }
}
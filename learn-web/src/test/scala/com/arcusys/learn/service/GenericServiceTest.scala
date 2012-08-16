package com.arcusys.learn.service

import com.arcusys.learn.admin.service._
import com.arcusys.learn.gradebook.service._
import com.arcusys.learn.questionbank.service._
import com.arcusys.learn.quiz.service._
import com.arcusys.learn.scorm.manifest.service._
import com.arcusys.learn.scorm.rte.service._
import org.junit._

class GenericServiceTest {
  @Test
  def allServicesHaveNoArgsConstructor() {
    new AdminService
    new UploadService
    
    new GradebookService
    
    new CategoryService
    new QuestionService
    
    new GeneratedPackagesService
    new QuizCategoryService
    new QuizQuestionService
    new QuizService
    
    new ActivitiesService
    new OrganizationsService
    new PackagesService
    new ResourcesService
    
    new RunTimeEnvironment
    new SequencingService
  }
}
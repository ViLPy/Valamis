package com.arcusys.learn.facades

import org.scalamock.proxy.ProxyMockFactory
import org.scalatest.{ Ignore, FlatSpec }
import org.scalamock.scalatest.MockFactory
import com.arcusys.learn.test.mocks.MockInjectableFactory
import org.junit.runner.RunWith
import com.arcusys.learn.mocks.Mocks
import com.arcusys.learn.scorm.course.CourseStorage

/**
 * Created by Iliya Tryapitsin on 24.04.14.
 */
@RunWith(classOf[org.scalatest.junit.JUnitRunner]) //@Ignore
class GradebookFacadeTest extends FlatSpec with MockFactory with ProxyMockFactory with MockInjectableFactory {
  var target: GradebookFacade = null
  val userFacade = Mocks.userFacade
  val roleFacade = Mocks.roleFacade
  val packageFacade = Mocks.packageFacade
  val courseStorage = Mocks.courseStorage

  bindingModule.modifyBindings(module => {
    module.bind[UserFacadeContract].toSingle(userFacade)
    module.bind[RoleFacadeContract].toSingle(roleFacade)
    module.bind[PackageFacadeContract].toSingle(packageFacade)
    module.bind[CourseStorage].toSingle(courseStorage)

    target = new GradebookFacade(module)
  })

  "Gradebook" should "return students" in {
    Mocks.UserFacade.allStub()

    //Mocks.UserFacade.allVerify()
    val response = target.getStudents(
      Mocks.UserFacade.courseId,
      Mocks.General.page,
      Mocks.General.count,
      Mocks.General.filter,
      "",
      Mocks.General.sortDirectionByAsc)

    assertResult(response.length)(1)
    assertResult(response.head.id)(1)
    assertResult(response.head.avatarUrl)("test portrait")
    assertResult(response.head.organizationNames.length)(1)
    assertResult(response.head.gradeTotal)(0.5)
  }
}

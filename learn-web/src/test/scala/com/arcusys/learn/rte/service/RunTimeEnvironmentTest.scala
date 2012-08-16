package com.arcusys.learn.scorm.rte.service

import com.arcusys.learn.scorm.tracking.model.Attempt
import com.arcusys.learn.scorm.tracking.model.User
import org.junit.runner.RunWith
import org.junit.runner.RunWith
import com.arcusys.learn.ioc.Configuration
import org.scalamock.ProxyMockFactory
import org.scalamock.scalatest.MockFactory
import com.arcusys.learn.questionbank.storage._
import com.arcusys.learn.scorm.tracking.storage._
import com.arcusys.learn.storage.StorageFactoryContract
import org.scalatra.test.scalatest.ScalatraFlatSpec
import com.arcusys.learn.scorm.manifest.storage.ActivitiesStorage
import com.arcusys.learn.scorm.tracking.states.storage.ActivityStateTreeStorage
import com.arcusys.scorm.lms.sequencing.{ActivityState, ActivityStateTree}

@RunWith(classOf[org.scalatest.junit.JUnitRunner])
class RunTimeEnvironmentTest extends ScalatraFlatSpec with MockFactory with ProxyMockFactory {
  
  private val dataModelStorage = mock[DataModelStorage]
  private val attemptStorage = mock[AttemptStorage]
  private val storageFactory = mock[StorageFactoryContract]
  private val activityStateTreeStorage = mock[ActivityStateTreeStorage]
  private val activityStorage = mock[ActivitiesStorage]

  Configuration.modifyBindings{testModule=>
    testModule.bind[StorageFactoryContract] toSingle storageFactory
    addServlet(new RunTimeEnvironment(testModule), "/*")
  }
 
  /*"RTE Service" can "initialize" in {
    val attempt = Attempt(0, User(1234,"username"), 1, "org1", isComplete = false)
    storageFactory stubs 'dataModelStorage returning dataModelStorage
    storageFactory stubs 'attemptStorage returning attemptStorage
    storageFactory stubs 'activityStateTreeStorage returning activityStateTreeStorage
    attemptStorage expects 'getActive returning Some(attempt) once()
    activityStateTreeStorage expects 'get returning Some(tree) once()

    post("/Initialize", Map("packageID"->"1", "organizationID"->"org1"), Map("scormUserID"->"1234")) {
      println(">>>>>>>>>>>>>>>>>>>\n" + body)
      status should equal (200)
      body should include ("\"status\":false")
    }
  }
  
  it can "work even with attempt autocreate" in {
    storageFactory stubs 'dataModelStorage returning dataModelStorage
    storageFactory stubs 'attemptStorage returning attemptStorage
    attemptStorage expects 'getActive returning None once()
    attemptStorage expects 'createAndGetID returning 0 once()
    
    post("/Initialize", Map("packageID"->"1", "organizationID"->"org1"), Map("scormUserID"->"1234")) {
      status should equal (200)
      body should include ("\"status\":true")
    }
  }
  
  it can "Can set datamodel variables" in {
    val attempt = Attempt(0, User(1234,"username"), 1, "org1", isComplete = false)
    storageFactory stubs 'dataModelStorage returning dataModelStorage
    storageFactory stubs 'attemptStorage returning attemptStorage
    attemptStorage expects 'getActive returning Some(attempt) once()
    storageFactory expects 'activityStorage returning activityStorage once()
    dataModelStorage expects 'setValue once()
    
    post("/SetValue", Map("key"->"cmi.location", "value"->"resume", "packageID"->"1", "organizationID"->"org1"), Map("scormUserID"->"1234")) {
      status should equal (200)
    }
  }
  
  it can "Can get datamodel variables" in {
    val attempt = Attempt(0, User(1234,"username"), 1, "org1", isComplete = false)
    storageFactory stubs 'dataModelStorage returning dataModelStorage
    storageFactory stubs 'attemptStorage returning attemptStorage
    attemptStorage expects 'getActive returning Some(attempt) once()
    storageFactory expects 'activityStorage returning activityStorage once()
    dataModelStorage expects 'getValue returning Some("resume") once()
    
    get("/GetValue/cmi.location", Map("packageID"->"1", "organizationID"->"org1"), Map("scormUserID"->"1234")) {
      status should equal (200)
      body should include ("resume")
    }
  }*/
}
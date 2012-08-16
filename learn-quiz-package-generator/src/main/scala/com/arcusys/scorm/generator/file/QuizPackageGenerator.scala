package com.arcusys.scorm.generator.file

import com.arcusys.scorm.generator.file.html.QuestionViewGenerator
import com.arcusys.scorm.generator.util.ResourceHelpers
import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.quiz.model.Quiz
import com.arcusys.scorm.util.FileSystemUtil
import com.arcusys.learn.storage.impl.orbroker._
import scala.collection.mutable
import com.arcusys.learn.scorm.manifest.serializer.ManifestGenerator
import com.arcusys.learn.util.TreeNode
import java.net.URLDecoder

class QuizPackageGenerator(quiz: Quiz) {
  if (!BrokerFactory.isInitialized) throw new RuntimeException("Broker factory is not initialized!")
  private val quizCategoryStorage = StorageFactory.quizQuestionCategoryStorage
  private val quizQuestionStorage = StorageFactory.quizQuestionStorage

  private val resourceBuffer = mutable.Buffer[Resource]()
  private val scoData = mutable.Map[String, String]()
  private val resourceFiles = mutable.HashSet[String]()
  private val scormDependencyID = "scormDependency"
  private val commonResourceURLs = Seq("common.js", "jquery-1.7.2.min.js", "jquery-ui-1.8.20.custom.min.js",
    "jquery-ui-1.8.20.custom.css", "player_content.css", "scorm_main.css")

  private def getResourceStream(name: String) = Thread.currentThread.getContextClassLoader.getResourceAsStream(name)

  private val organizationId = "orgId1"

  def generateZip = {
    val zipName = quiz.id + ".zip"
    val zip = new ZipFile(FileSystemUtil.getZipPackageDir + zipName)
    zip.addEntry("imsmanifest.xml", generateManifest.toString)
    scoData.foreach(file => zip.addEntry("data/" + file._1 + ".html", file._2))
    commonResourceURLs.foreach(filename => zip.addEntry("data/" + filename, scala.io.Source.fromInputStream(getResourceStream("common/" + filename)).mkString))
    resourceFiles.foreach(filename => {
      zip.addFile(FileSystemUtil.getRealPath("/" + filename), "data/" + filename)
    })
    zip.close

    zipName
  }

  private def generateManifest = {

    val rootActivitySequencing = new Sequencing(Some("SCORMRootQuizActivitySN-1"), None,
      new SequencingPermissions(choiceForChildren = true, choiceForNonDescendants = true, flowForChildren = true, forwardOnlyForChildren = false),
      false, false,
      None, None,
      new RollupContribution(satisfaction = None, completion = None, objectiveMeasureWeight = 1, measureSatisfactionIfActive = false),
      None, Nil, new ChildrenSelection(), Some(new SequencingTracking(completionSetByContent = true, objectiveSetByContent = true)),
      false, false, Nil, Nil, Nil, Nil)
    val organization = new Organization(organizationId, quiz.title)

    val welcomePage = if (quiz.welcomePageContent.nonEmpty) Seq(generateStaticPage("welcome", "Welcome page", quiz.welcomePageContent)) else Seq()
    val finalPage = if (quiz.finalPageContent.nonEmpty) Seq(generateStaticPage("final", "Final page", quiz.finalPageContent)) else Seq()
    val data = welcomePage ++ generateActivitiesByCategories() ++ finalPage

    // add common files to package and manifest
    resourceBuffer += new AssetResource(scormDependencyID, None, Some("base/"), commonResourceURLs.map(new ResourceFile(_)), Nil)
    //TODO: why 3rd edition???
    val doc = new ManifestDocument(
      new Manifest(quiz.id, Some("1.1"), Some("data/"), "2004 4th Edition", Some(organizationId), None, quiz.title),
      organizations = Seq(new TreeNode[Activity](organization, data)),
      resources = resourceBuffer.toSeq, sequencingCollection = Nil
    )
    ManifestGenerator.toXML(doc)
  }

  private def generateStaticPage(id: String, title: String, content: String) = {
    val imageResources = ResourceHelpers.fetchImageResources(decode(content))
    resourceBuffer += new AssetResource(id, Some(id + ".html"), Some("base/"), imageResources.map(new ResourceFile(_)), Seq(scormDependencyID))
    scoData(id) = QuestionViewGenerator.getHTMLForStaticPage(content)

    imageResources.foreach(res => {
      resourceFiles += res
    })
    val sequencing = new Sequencing(
        sharedId = None,
        sharedSequencingIdReference = None,
        permissions = SequencingPermissions.Default,
        onlyCurrentAttemptObjectiveProgressForChildren = true,
        onlyCurrentAttemptAttemptProgressForChildren = true,
        attemptLimit = None,
        durationLimitInMilliseconds = None,
        rollupContribution = RollupContribution.Default,
        primaryObjective = None,
        nonPrimaryObjectives = Nil,
        childrenSelection = new ChildrenSelection(),
        tracking = None,
        preventChildrenActivation = false,
        constrainChoice = false,
        preConditionRules = Nil, postConditionRules = Nil, exitConditionRules = Nil, rollupRules = Nil)
    val leaf = new LeafActivity("static" + id, title, organizationId, organizationId, id, sequencing = sequencing, hiddenNavigationControls = Set(NavigationControlType.Continue, NavigationControlType.Previous))
    new TreeNode[Activity](leaf, Nil)
  }

  private def decode(source: String) = URLDecoder.decode(source, "UTF-8")

  private def getLeafActivitiesByCategory(categoryID: Option[Int]) = {
    val questions = quizQuestionStorage.getByCategory(quiz.id, categoryID)
    questions.map(question => {
      val realQuestion = question.question
      val parentID = if (categoryID == None) None else Some(categoryID.get.toString)
      val resID = "resource" + question.id
      // TODO: add images from answer
      val imageResources = ResourceHelpers.fetchImageResources(decode(realQuestion.text))
      resourceBuffer += new AssetResource(resID, Some(resID + ".html"), Some("base/"), imageResources.map(new ResourceFile(_)), Seq(scormDependencyID))
      scoData(resID) = QuestionViewGenerator.getHTMLByQuestionId(realQuestion)

      imageResources.foreach(res => {
        resourceFiles += res
      })
      val leaf = new LeafActivity("question" + question.id, realQuestion.title, parentID.getOrElse(organizationId), organizationId, resID, hiddenNavigationControls = Set(NavigationControlType.Continue, NavigationControlType.Previous))
      new TreeNode[Activity](leaf, Nil)
    }
    )
  }

  private def generateActivitiesByCategories(parentID: Option[Int] = None): Seq[TreeNode[Activity]] = {
    val categories = quizCategoryStorage.getChildren(quiz.id, parentID)
    categories.map(category => {
      val container = new ContainerActivity(category.id.toString, category.title, parentID.map(_.toString).getOrElse(organizationId), organizationId)
      new TreeNode[Activity](container, generateActivitiesByCategories(Some(category.id)))
    }
    ) ++ getLeafActivitiesByCategory(parentID)
  }
}
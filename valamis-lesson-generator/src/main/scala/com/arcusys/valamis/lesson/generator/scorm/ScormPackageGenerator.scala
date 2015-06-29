package com.arcusys.valamis.lesson.generator.scorm

import java.io.FileInputStream
import com.arcusys.valamis.file.storage.FileStorage
import com.arcusys.valamis.lesson.generator.PackageGenerator
import com.arcusys.valamis.lesson.generator.scorm.file.html.QuestionViewGenerator
import com.arcusys.valamis.lesson.generator.util.ResourceHelpers
import com.arcusys.valamis.lesson.scorm.model.manifest._
import com.arcusys.valamis.lesson.scorm.service.serializer.ManifestGenerator
import com.arcusys.valamis.questionbank.model.{ DLVideo, PlainText }
import com.arcusys.valamis.questionbank.storage.QuestionStorage
import com.arcusys.valamis.quiz.model._
import com.arcusys.valamis.quiz.storage.{ QuizQuestionCategoryStorage, QuizQuestionStorage, QuizTreeStorage }
import com.arcusys.valamis.util.mustache.Mustache
import com.arcusys.valamis.util.{ FileSystemUtil, TreeNode, ZipBuilder }
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }
import org.apache.commons.lang.StringEscapeUtils

import scala.collection.mutable

class ScormPackageGenerator(quiz: Quiz)(implicit val bindingModule: BindingModule) extends Injectable with PackageGenerator {
  private val questionStorage: QuestionStorage = inject[QuestionStorage]
  private val quizCategoryStorage = inject[QuizQuestionCategoryStorage]
  private val quizQuestionStorage = inject[QuizQuestionStorage]
  private val quizTreeStorage = inject[QuizTreeStorage]
  private val fileStorage = inject[FileStorage]

  private val resourceBuffer = mutable.Buffer[Resource]()
  private val scoData = mutable.Map[String, String]()
  private val resourceFiles = mutable.HashSet[String]()
  private val scormDependencyID = "scormDependency"
  private val commonResourceURLs = Seq("common.js", "jquery-1.7.2.min.js", "jquery-ui-1.8.20.custom.min.js", "jquery.ui.touch-punch.min.js", "pptxScript.js",
    "jquery-ui-1.8.20.custom.css", "player_content.css", "scorm_main.css", "buttons.css")

  private val commonRevealResourceURLs = Seq("reveal.min.js", "head.min.js", "plugin/highlight/highlight.js", "css/zenburn.css", "css/reveal.min.css", "css/theme/beige.css",
    "css/theme/blood.css", "css/theme/default.css", "css/theme/moon.css",
    "css/theme/night.css", "css/theme/serif.css", "css/theme/simple.css", "css/theme/sky.css", "css/theme/solarized.css")
  private val questionViewGenerator = new QuestionViewGenerator(isPreview = false)

  private def getResourceInputStream(name: String) = Thread.currentThread.getContextClassLoader.getResourceAsStream(name)

  private val organizationId = "orgId1"

  private val commonResourcesWithName = {
    val maxDuration = quiz.maxDuration
    val viewModel = Map("maxDuration" -> maxDuration.map(_ * 60).getOrElse(0))

    val is = getResourceInputStream("common/timer.js")

    val mustachedTimer = new Mustache(scala.io.Source.fromInputStream(is).mkString).render(viewModel)

    val tempFile = FileSystemUtil.arrayToTempFile(mustachedTimer.toArray.map(_.toByte), "timer", "js")

    List((tempFile.getAbsolutePath, "timer.js"))
  }

  def generateZip(courseID: Option[Int]) = {

    val zipFile = FileSystemUtil.getTempFile("Quiz" + quiz.id, "zip")
    val zip = new ZipBuilder(zipFile)

    zip.addEntry("imsmanifest.xml", generateManifest(courseID).toString())
    zip.addFilesFromZip(getResourceInputStream("common/pdf.zip"))
    scoData.foreach(file => zip.addEntry("data/" + file._1 + ".html", file._2))
    (commonResourceURLs ++ commonRevealResourceURLs).foreach(filename => zip.addFile(getResourceInputStream("common/" + filename), "data/" + filename))
    commonResourcesWithName.foreach { case (realFileName, fileName) => zip.addFile(new FileInputStream(realFileName), "data/" + fileName) }
    resourceFiles.foreach(filename => {
      zip.addFile("data/" + filename,
        fileStorage.getFile(filename).getOrElse(throw new Exception("Can't find file '" + filename + "' in DB")).content.getOrElse(throw new Exception("File '" + filename + "' has no content")))
    })
    zip.close()

    zipFile
  }

  private def generateManifest(courseID: Option[Int]) = {
    val organization = new Organization(organizationId, quiz.title)

    val welcomePage = if (quiz.welcomePageContent.nonEmpty) Seq(generateStaticPage("welcome", "Welcome page", quiz.welcomePageContent)) else Seq()
    val finalPage = if (quiz.finalPageContent.nonEmpty) Seq(generateStaticPage("final", "Final page", quiz.finalPageContent)) else Seq()
    val data = welcomePage ++ generateActivitiesByCategories() ++ finalPage

    // add common files to package and manifest
    resourceBuffer += new AssetResource(scormDependencyID, None, Some("base/"), commonResourceURLs.map(new ResourceFile(_)), Nil)
    val doc = new ManifestDocument(
      new Manifest(quiz.id, Some("1.1"), Some("data/"), "2004 4th Edition", Some(organizationId), None, quiz.title, courseId = courseID, isDefault = false, beginDate = None, endDate = None),
      organizations = Seq(new TreeNode[Activity](organization, data)),
      resources = resourceBuffer.toSeq, sequencingCollection = Nil
    )
    ManifestGenerator.toXML(doc)
  }

  private def generateStaticPage(id: String, title: String, content: String) = {
    val imageResources = ResourceHelpers.fetchResources(content)
    resourceBuffer += new AssetResource(id, Some(id + ".html"), Some("base/"), imageResources.map(new ResourceFile(_)), Seq(scormDependencyID))
    scoData(id) = questionViewGenerator.getHTMLForStaticPage(content)

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

  private def processQuestion(question: QuizQuestion, parentID: Option[String]) = {
    val resID = "resource" + question.id
    question match {
      case questionBankQuestion: QuestionBankQuizQuestion => {
        val realQuestion = questionBankQuestion.question
        val imageResources = ResourceHelpers.fetchResources(realQuestion.text)
        resourceBuffer += new AssetResource(resID, Some(resID + ".html"), Some("base/"), imageResources.map(new ResourceFile(_)), Seq(scormDependencyID))
        scoData(resID) = questionViewGenerator.getHTMLByQuestionId(realQuestion, questionBankQuestion.autoShowAnswer)

        imageResources.foreach(res => {
          resourceFiles += res
        })
        val leaf = new LeafActivity("question" + questionBankQuestion.id, realQuestion.title, parentID.getOrElse(organizationId), organizationId, resID, hiddenNavigationControls = Set(NavigationControlType.Continue, NavigationControlType.Previous))
        new TreeNode[Activity](leaf, Nil)
      }
      case plain: PlainTextQuizQuestion => {
        val realQuestion = new PlainText(plain.id, plain.categoryID, plain.title.getOrElse(""), StringEscapeUtils.unescapeJavaScript(plain.text), None)
        val imageResources = ResourceHelpers.fetchResources(realQuestion.text)
        resourceBuffer += new AssetResource(resID, Some(resID + ".html"), Some("base/"), imageResources.map(new ResourceFile(_)), Seq(scormDependencyID))
        scoData(resID) = questionViewGenerator.getHTMLByQuestionId(realQuestion, false)

        imageResources.foreach(res => {
          resourceFiles += res
        })
        val leaf = new LeafActivity("question" + plain.id, realQuestion.title, parentID.getOrElse(organizationId), organizationId, resID, hiddenNavigationControls = Set(NavigationControlType.Continue, NavigationControlType.Previous))
        new TreeNode[Activity](leaf, Nil)
      }
      case external: ExternalQuizQuestion => {
        resourceBuffer += new AssetResource(resID, Some(external.url), None, Nil, Nil)
        val leaf = new LeafActivity("question" + question.id, question.title.getOrElse(""), parentID.getOrElse(organizationId), organizationId, resID, hiddenNavigationControls = Set(NavigationControlType.Previous))
        new TreeNode[Activity](leaf, Nil)
      }
      case pdf: PDFQuizQuestion => {
        val filename = "files/quizData" + pdf.quizID + "/" + pdf.filename
        resourceBuffer += new AssetResource(resID, Some("web/viewer.html?file=../" + filename), None, Nil, Nil)
        resourceFiles += filename
        val leaf = new LeafActivity("question" + question.id, question.title.getOrElse(""), parentID.getOrElse(organizationId), organizationId, resID, hiddenNavigationControls = Set(NavigationControlType.Previous))
        new TreeNode[Activity](leaf, Nil)
      }
      case pptx: PPTXQuizQuestion => {
        val filename = "files/quizData" + pptx.quizID + "/" + pptx.file
        resourceBuffer += new AssetResource(resID, Some(resID + ".html"), None, Nil, Nil)
        scoData(resID) = questionViewGenerator.getHTMLForPPTX(pptx.quizID, pptx.file)
        resourceFiles += filename
        val leaf = new LeafActivity("question" + question.id, question.title.getOrElse(""), parentID.getOrElse(organizationId), organizationId, resID, hiddenNavigationControls = Set(NavigationControlType.Previous))
        new TreeNode[Activity](leaf, Nil)
      }
      case reveal: RevealJSQuizQuestion => {
        val imageResources = ResourceHelpers.fetchResources(reveal.content)
        resourceBuffer += new AssetResource(resID, Some(resID + ".html"), Some("base/"), imageResources.map(new ResourceFile(_)), Seq(scormDependencyID))
        scoData(resID) = questionViewGenerator.getHTMLForRevealPage(reveal.content)
        imageResources.foreach(res => {
          resourceFiles += res
        })
        val leaf = new LeafActivity("question" + question.id, question.title.getOrElse(""), parentID.getOrElse(organizationId), organizationId, resID, hiddenNavigationControls = Set(NavigationControlType.Previous))
        new TreeNode[Activity](leaf, Nil)
      }
      case dlVideo: DLVideoQuizQuestion => {
        val realQuestion = new DLVideo(dlVideo.id, dlVideo.categoryID, dlVideo.title.getOrElse(""), "", None, dlVideo.uuid, dlVideo.groupId)
        val imageResources = ResourceHelpers.fetchResources(realQuestion.text)

        resourceBuffer += new AssetResource(resID, Some(resID + ".html"), Some("base/"), imageResources.map(new ResourceFile(_)), Seq(scormDependencyID))
        scoData(resID) = questionViewGenerator.getHTMLByQuestionId(realQuestion, false)

        imageResources.foreach(res => {
          resourceFiles += res
        })
        val leaf = new LeafActivity("question" + dlVideo.id, realQuestion.title, parentID.getOrElse(organizationId), organizationId, resID, hiddenNavigationControls = Set(NavigationControlType.Continue, NavigationControlType.Previous))
        new TreeNode[Activity](leaf, Nil)
      }
      case _ => throw new Exception("unsupported question type")
    }
  }

  private def generateActivitiesByCategories(parentID: Option[Int] = None): Seq[TreeNode[Activity]] = {
    val quizTreeElements = quizTreeStorage.getByQuizID(quiz.id)
    val categories = quizCategoryStorage.getChildren(quiz.id, parentID)
    val questions = quizQuestionStorage.getByCategory(quiz.id, parentID)

    val parentString = parentID.map(elem => "c_" + elem.toString)
    quizTreeElements.filter(_.parentID == parentString).sortBy(_.arrangementIndex).foldLeft(List[TreeNode[Activity]]()) { (acc, elem) =>
      val elem2Add = if (elem.isCategory) {
        val Some(category) = categories.find(_.id == quizTreeStorage.getRealElementID(elem))
        val container = new ContainerActivity(category.id.toString, category.title, parentID.map(_.toString).getOrElse(organizationId), organizationId)
        new TreeNode[Activity](container, generateActivitiesByCategories(Some(category.id)))
      } else {
        val Some(question) = questions.find(_.id == quizTreeStorage.getRealElementID(elem))
        processQuestion(question, parentString)
      }
      elem2Add :: acc
    }.reverse
  }
}
package com.arcusys.scorm.generator.file

import java.io.{ FileOutputStream, BufferedInputStream, FileInputStream, File }

import com.arcusys.learn.filestorage.storage.FileStorage
import com.arcusys.learn.questionbank.storage.QuestionStorage
import com.arcusys.learn.quiz.storage.{ QuizTreeStorage, QuizQuestionStorage, QuizQuestionCategoryStorage }
import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.scorm.manifest.serializer.ManifestGenerator
import com.arcusys.learn.quiz.model._
import com.arcusys.learn.questionbank.model.{ DLVideo, PlainText }
import com.arcusys.learn.util.TreeNode
import com.arcusys.learn.util.mustache.Mustache
import com.arcusys.scorm.generator.file.html.QuestionViewGenerator
import com.arcusys.scorm.generator.util.ResourceHelpers
import com.arcusys.scorm.util.{ FileProcessing, FileSystemUtil }

import com.escalatesoft.subcut.inject.{ Injectable, BindingModule }
import org.apache.commons.lang.StringEscapeUtils

import scala.collection.mutable
import java.net.URLDecoder
import com.arcusys.generator.PackageGenerator

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
  private val commonResourceURLs = Seq("common.js", "jquery-1.7.2.min.js", "jquery-ui-1.8.20.custom.min.js",
    "jquery-ui-1.8.20.custom.css", "player_content.css", "scorm_main.css", "buttons.css")

  private val commonRevealResourceURLs = Seq("reveal.min.js", "head.min.js", "plugin/highlight/highlight.js", "css/zenburn.css", "css/reveal.min.css", "css/theme/beige.css",
    "css/theme/blood.css", "css/theme/default.css", "css/theme/moon.css",
    "css/theme/night.css", "css/theme/serif.css", "css/theme/simple.css", "css/theme/sky.css", "css/theme/solarized.css")
  private val questionViewGenerator = new QuestionViewGenerator(isPreview = false)

  private def getResourceInputStream(name: String) = Thread.currentThread.getContextClassLoader.getResourceAsStream(name)

  private def decode(source: String) = URLDecoder.decode(source, "UTF-8")

  private val organizationId = "orgId1"

  private val commonResourcesWithName = {
    val maxDuration = quiz.maxDuration
    val viewModel = Map("maxDuration" -> maxDuration.map(_ * 60).getOrElse(0))

    val is = getResourceInputStream("common/timer.js")

    val mustachedTimer = new Mustache(scala.io.Source.fromInputStream(is).mkString).render(viewModel)

    val tempFile = File.createTempFile("timer", ".js")
    flushContent2File(mustachedTimer.toArray.map(_.toByte), tempFile)

    List((tempFile.getAbsolutePath, "timer.js"))
  }

  def flushContent2File(content: Array[Byte], file: File): File = { //move to Utils?
    val temp = new FileOutputStream(file)
    temp.write(content)
    temp.flush()
    temp.close()
    file
  }

  def generateZip(courseID: Option[Int], randomOrdering: Boolean, questionsPerUser: Option[Int]) = {

    //TODO: use randomOrdering and questionsPerUser

    val zipName = FileProcessing.getTempFileName("Quiz" + quiz.id.toString, ".zip")
    val zip = new ZipFile(FileSystemUtil.getRealTmpDir + zipName)
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

    zipName
  }

  private def generateManifest(courseID: Option[Int]) = {
    val organization = new Organization(organizationId, quiz.title)

    val welcomePage = if (quiz.welcomePageContent.nonEmpty) Seq(generateStaticPage("welcome", "Welcome page", quiz.welcomePageContent)) else Seq()
    val finalPage = if (quiz.finalPageContent.nonEmpty) Seq(generateStaticPage("final", "Final page", quiz.finalPageContent)) else Seq()
    val data = welcomePage ++ generateActivitiesByCategories() ++ finalPage

    // add common files to package and manifest
    resourceBuffer += new AssetResource(scormDependencyID, None, Some("base/"), commonResourceURLs.map(new ResourceFile(_)), Nil)
    val doc = new ManifestDocument(
      new Manifest(quiz.id, Some("1.1"), Some("data/"), "2004 4th Edition", Some(organizationId), None, quiz.title, courseID = courseID, isDefault = false),
      organizations = Seq(new TreeNode[Activity](organization, data)),
      resources = resourceBuffer.toSeq, sequencingCollection = Nil
    )
    ManifestGenerator.toXML(doc)
  }

  private def generateStaticPage(id: String, title: String, content: String) = {
    val imageResources = ResourceHelpers.fetchResources(decode(content))
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

  private def getLeafActivitiesByCategory(categoryID: Option[Int]) = {
    val questions = quizQuestionStorage.getByCategory(quiz.id, categoryID)

    // Get the right order from quizTreeStorage. Idea is taken from TinCanQuizPackageGenerator
    val rightSortedQuestions = {
      val quizTreeElements = quizTreeStorage.getByQuizID(quiz.id)
      questions.sortBy(question =>
        quizTreeElements.find(elem => quizTreeStorage.getRealElementID(elem) == question.id)
          .getOrElse(throw new IllegalStateException(s"quizTreeStorage doesn't have question ${question}")).arrangementIndex)
    }

    rightSortedQuestions.map(question => {
      val parentID = if (categoryID == None) None else Some(categoryID.get.toString)
      val resID = "resource" + question.id
      question match {
        case questionBankQuestion: QuestionBankQuizQuestion => {
          val realQuestion = questionBankQuestion.question
          val imageResources = ResourceHelpers.fetchResources(decode(realQuestion.text))
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
          val imageResources = ResourceHelpers.fetchResources(decode(realQuestion.text))
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
          val imageResources = ResourceHelpers.fetchResources(decode(reveal.content))
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
          val imageResources = ResourceHelpers.fetchResources(decode(realQuestion.text))

          resourceBuffer += new AssetResource(resID, Some(resID + ".html"), Some("base/"), imageResources.map(new ResourceFile(_)), Seq(scormDependencyID))
          scoData(resID) = questionViewGenerator.getHTMLByQuestionId(realQuestion, false)

          imageResources.foreach(res => {
            resourceFiles += res
          })
          val leaf = new LeafActivity("question" + dlVideo.id, realQuestion.title, parentID.getOrElse(organizationId), organizationId, resID, hiddenNavigationControls = Set(NavigationControlType.Continue, NavigationControlType.Previous))
          new TreeNode[Activity](leaf, Nil)
        }
      }
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
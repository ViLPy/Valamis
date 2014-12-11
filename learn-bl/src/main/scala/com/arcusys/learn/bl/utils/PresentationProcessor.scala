package com.arcusys.learn.bl.utils

import java.awt.Color
import java.awt.geom.{ AffineTransform, Rectangle2D }
import java.awt.image.BufferedImage
import java.io._
import com.arcusys.learn.util.mustache.Mustache
import com.arcusys.tincan.generator.file.TinCanRevealJSPackageGenerator
import org.apache.poi.xslf.usermodel.XMLSlideShow

trait PresentationProcessorContract {
  def convert(content: Array[Byte]): Seq[ByteArrayOutputStream]
  def processPresentation(requestFileName: String,
    requestFileContent: Array[Byte],
    packageTitle: String,
    packageDescription: String): String
}

object PresentationProcessor extends PresentationProcessorContract {
  override def convert(content: Array[Byte]) = {
    val is = new ByteArrayInputStream(content)
    val ppt = new XMLSlideShow(is)
    is.close()

    val zoom = 4 //Just a magic number to enlarge resolution number.
    val at = new AffineTransform()
    at.setToScale(zoom, zoom)

    val pgsize = ppt.getPageSize()

    ppt.getSlides.map { slide =>
      val img = new BufferedImage(Math.ceil(pgsize.width * zoom).toInt, Math.ceil(pgsize.height * zoom).toInt, BufferedImage.TYPE_INT_RGB)
      val graphics = img.createGraphics()
      graphics.setTransform(at)
      //clear the drawing area
      graphics.setPaint(Color.white)
      graphics.fill(new Rectangle2D.Float(0, 0, pgsize.width, pgsize.height))

      //render
      slide.draw(graphics)

      //save the output
      val out = new ByteArrayOutputStream
      javax.imageio.ImageIO.write(img, "png", out) //jpg takes more memory(space).
      out
    }
  }

  def getResourceInputStream(name: String) = Thread.currentThread.getContextClassLoader.getResourceAsStream(name)
  def getNameWitoutExtension(name: String) = name.reverse.dropWhile(_ != ".").drop(1).reverse

  val pptxForegroundTemplate = new Mustache(scala.io.Source.fromInputStream(getResourceInputStream("tincan/pptx-foreground-iframe.html")).mkString)
  val pptxTemplate = new Mustache(scala.io.Source.fromInputStream(getResourceInputStream("tincan/pptx.html")).mkString)
  val indexTemplate = new Mustache(scala.io.Source.fromInputStream(getResourceInputStream("tincan/revealjs.html")).mkString)

  override def processPresentation(requestFileName: String,
    requestFileContent: Array[Byte],
    packageTitle: String,
    packageDescription: String) = {

    val fileName = getNameWitoutExtension(requestFileName)

    val tinCanRevealJSPackageGenerator = new TinCanRevealJSPackageGenerator {
      val activityId = s"http://valamislearning.com/presentation/${fileName}" //Because packageTitle is always a "New title"
      override protected def generateManifest =
        <tincan xmlns="http://projecttincan.com/tincan.xsd">
          <activities>
            <activity id={ activityId } type="http://adlnet.gov/expapi/activities/course">
              <name>
                { fileName }
              </name>
              <description lang="en-US">
                { packageDescription }
              </description>
              <launch lang="en-us">data/index.html</launch>
            </activity>
          </activities>
        </tincan>
    }

    val indexedImages = convert(requestFileContent).zipWithIndex

    val imageSupplementaries = indexedImages.foldLeft(List[(String, InputStream)]()) {
      case (acc, (slide, i)) =>
        val slideName = s"slide-${i + 1}.png"
        val pptxForeground = pptxForegroundTemplate.render(Map("file" -> slideName))
        val pptxForegroundFileName = s"pptx-foreground-iframe-${i}.html"

        ("files/quizData/" + slideName -> new ByteArrayInputStream(slide.toByteArray)) ::
          (pptxForegroundFileName -> new ByteArrayInputStream(pptxForeground.getBytes)) ::
          acc
    }

    val imageSections = indexedImages.map {
      case (slide, i) =>
        pptxTemplate.render(Map("id" -> i, "title" -> s"slide-${i + 1}"))
    }.mkString("\n")

    val index = new ByteArrayInputStream(indexTemplate.render(Map("sections" -> imageSections, "title" -> fileName)).getBytes)

    tinCanRevealJSPackageGenerator.composePackage(("index.html" -> index) :: imageSupplementaries)
  }
}

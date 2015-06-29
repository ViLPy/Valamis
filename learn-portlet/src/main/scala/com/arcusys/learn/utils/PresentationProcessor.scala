package com.arcusys.learn.utils

import java.awt.Color
import java.awt.geom.{ AffineTransform, Rectangle2D }
import java.awt.image.BufferedImage
import java.io._

import com.arcusys.valamis.lesson.generator.tincan.file.TinCanRevealJSPackageGenerator
import com.arcusys.valamis.util.mustache.Mustache
import org.apache.poi.xslf.usermodel.XMLSlideShow

trait PresentationProcessorContract {
  def convert(stream: InputStream): Seq[ByteArrayOutputStream]
  def processPresentation(name: String, stream: InputStream, packageTitle: String, packageDescription: String): File
}

object PresentationProcessor extends PresentationProcessorContract {

  private lazy val pptxForegroundTemplate = new Mustache(scala.io.Source.fromInputStream(getResourceInputStream("tincan/pptx-foreground-iframe.html")).mkString)
  private lazy val pptxTemplate = new Mustache(scala.io.Source.fromInputStream(getResourceInputStream("tincan/pptx.html")).mkString)
  private lazy val indexTemplate = new Mustache(scala.io.Source.fromInputStream(getResourceInputStream("tincan/revealjs.html")).mkString)

  private def getResourceInputStream(name: String) = Thread.currentThread.getContextClassLoader.getResourceAsStream(name)

  override def convert(stream: InputStream) = {
    val ppt = new XMLSlideShow(stream)
    stream.close()

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

  override def processPresentation(name: String, stream: InputStream, packageTitle: String, packageDescription: String) = {

    val indexedImages = convert(stream).zipWithIndex

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

    val index = new ByteArrayInputStream(indexTemplate.render(Map("sections" -> imageSections, "title" -> name)).getBytes)

    TinCanRevealJSPackageGenerator.composePackage(("index.html" -> index) :: imageSupplementaries, s"http://valamislearning.com/presentation/${name}", name, packageDescription)
  }
}

package com.arcusys.util

import com.codecommit.antixml._
import java.io.{ StringWriter, StringReader, FileOutputStream, File }
import scala.collection.mutable
import java.util.Scanner
import javax.xml.transform.stream.{ StreamResult, StreamSource }
import javax.xml.transform.{ OutputKeys, TransformerFactory }

object SqlToHints extends App {
  println("1. Reading portlet-model-hints.xml ...")
  val hintsXml = readHintsFile

  println("2. Loading sql scripts ...")
  val pathToScripts = "/Users/igrebenik/Projects/arcusys/Learn/learn-persistence/src/main/resources/sql"
  val files = getSqlFiles(pathToScripts)
  val scripts: Seq[String] = files.map(readFile(_)).toSeq

  println("3. Extracting data from sql scripts ...")
  val models = scripts.map { script =>
    Model.construct(script.lines.toList)
  }

  println("4. Applying extracted data to portlet-model-hints.xml ...")
  val updatedXml = XmlHelper.updateXmlHints(hintsXml, models)
  writeHintsFile(updatedXml.toString())
  println("5. Done!")

  def readHintsFile: Elem = {
    val loader: ClassLoader = this.getClass.getClassLoader
    val is = loader.getResourceAsStream("META-INF/portlet-model-hints.xml")
    XML.fromInputStream(is)
  }

  def writeHintsFile(data: String) {
    val loader: ClassLoader = this.getClass.getClassLoader
    val uri = loader.getResource("META-INF/portlet-model-hints.xml")
    val file = new File(uri.toURI)
    val os = new FileOutputStream(file)

    try {
      val contentsInBytes = prettyFormat(data).getBytes
      os.write(contentsInBytes)
      os.flush()
    } catch {
      case e: Exception => println("Cannot write hints\n" + e.getMessage)
    } finally {
      if (os != null) os.close()
    }
  }

  def prettyFormat(input: String): String = try {
    val xmlInput = new StreamSource(new StringReader(input))
    val stringWriter = new StringWriter
    val xmlOutput = new StreamResult(stringWriter)
    val transformerFactory = TransformerFactory.newInstance()

    transformerFactory.setAttribute("indent-number", 4)
    val transformer = transformerFactory.newTransformer()
    transformer.setOutputProperty(OutputKeys.INDENT, "yes")
    transformer.transform(xmlInput, xmlOutput)
    xmlOutput.getWriter.toString
  }

  def getSqlFiles(path: String) = {

    def recursiveLookup(dir: File): Array[String] = {
      val data: mutable.Buffer[String] = mutable.Buffer.empty
      val dirFiles = dir.list.map(f => new File(dir.getPath + "/" + f))
      val filteredDirs = dirFiles.filter(_.isDirectory).map(recursiveLookup(_).map(dir.getName + "/" + _))
      filteredDirs.foreach(_.foreach(data += _))
      dir.list.filter(p => p.endsWith(".sql")).map(p => dir.getName + "/" + p) ++ data
    }

    val directory = try {
      Some(new File(path))
    } catch {
      case _: Exception => None
    }

    if (directory.isDefined && directory.get.exists()) {
      recursiveLookup(directory.get).filter(_.contains("_renew")).map(f => f.replace("sql/", (path + "/"))).toList
    } else {
      Nil
    }

  }

  def readFile(pathname: String): String = {
    val file = new File(pathname)
    val fileContents = new mutable.StringBuilder(file.length().toInt)
    val scanner = new Scanner(file)
    val lineSeparator = System.getProperty("line.separator")

    try {
      while (scanner.hasNextLine) {
        fileContents.append(scanner.nextLine() + lineSeparator)
      }
      fileContents.toString()
    } finally scanner.close()
  }
}

case class ModelVariable(name: String, value: Option[String], vType: String)
case class Model(name: String, variables: Seq[ModelVariable])

object Model {
  def construct(sql: List[String]): Model = {
    val name = sql.filter(_.contains("CREATE TABLE"))(0).split(" ")(2)
    val conditional = filterConditions(sql)
    val nonConditional = filterNonConditions(sql)
    Model(name, conditional ++ nonConditional)
  }

  private def filterNonConditions(lines: List[String]): Seq[ModelVariable] = {
    val vs = getModelVariables(lines)
    vs
  }

  private def filterConditions(lines: List[String]): Seq[ModelVariable] = {
    var isFiltered = false
    val filtered = new scala.collection.mutable.ListBuffer[String]

    def filter(lines: List[String]) {
      lines match {
        case Nil =>
        case (head :: tail) =>
          if (head.contains("<#else>") || head.contains("<#elseif dbType==\"h2\">")) isFiltered = true
          else if ((!head.contains("</#if>")) && (isFiltered == true)) filtered.append(head)
          else isFiltered = false
          filter(tail)
      }
    }

    filter(lines)
    val vs = getModelVariables(filtered.toList)
    vs
  }

  private def getModelVariables(lines: Seq[String]): Seq[ModelVariable] = {
    val regexp = """(?<=.*\()([0-9]+)(?=\).*)""".r
    val regexp2 = """(?<=.*\()([0-9]+,[0-9]+)(?=\).*)""".r

    lines.filter(line => line.contains("VARCHAR") ||
      line.contains("text") ||
      line.contains("decimal") ||
      line.contains("numeric")).
      map { line =>
        val parts = line.trim.split(' ')
        if (line.contains("VARCHAR"))
          ModelVariable(parts(0), regexp.findAllIn(parts(1)).toArray.headOption, "VARCHAR")
        else if (line.contains("text"))
          ModelVariable(parts(0), regexp2.findAllIn(parts(1)).toArray.headOption, "Text")
        else
          ModelVariable(parts(0), regexp2.findAllIn(parts(1)).toArray.headOption, "BigDecimal")
      }.toSeq
  }
}

object XmlHelper {

  def updateXmlHints(xmlHints: Elem, models: Seq[Model]) = {
    val xmlModels: Zipper[Elem] = xmlHints \ "model"
    val xmlHintCollections: Zipper[Elem] = xmlHints \ "hint-collection"

    println(xmlHintCollections)

    val updatedModels = xmlModels.map { elem =>
      val name = elem.attrs(QName(None, "name"))
      val model = getModelByName(name, models)

      if (model.isDefined) {
        val fields = getUpdatedFields(elem, model.get)
        elem.toZipper.updated(0, elem.copy(children = Group(fields: _*)))
      } else {
        elem
      }
    }

    val modelNodes = updatedModels.map {
      case zipper: Zipper[Elem] => zipper.toGroup.head.asInstanceOf[Node]
      case elem: Elem           => elem.asInstanceOf[Node]
    }.toList

    val hintCollectionNodes = xmlHintCollections.map {
      case zipper: Zipper[Elem] => zipper.toGroup.head.asInstanceOf[Node]
      case elem: Elem           => elem.asInstanceOf[Node]
    }.toList

    xmlHints.toZipper.updated(0, xmlHints.copy(children = Group(hintCollectionNodes ++ modelNodes: _*)))
  }

  def getXmlHint(variable: ModelVariable, vType: String): Elem =
    if (vType == "VARCHAR")
      <field name={ variable.name } type="String">
        <hint name="max-length">{ variable.value.get }</hint>
      </field>.convert
    else if (vType == "Text")
      <field name={ variable.name } type="String">
        <hint name="max-length">2000000</hint>
      </field>.convert
    else
      <field name={ variable.name } type="BigDecimal">
        <hint name="precision-scale">{ "(" + variable.value.get + ")" }</hint>
      </field>.convert

  def getModelByName(attrName: String, models: Seq[Model]): Option[Model] = {
    val trimmedName = attrName.split('.').last.replace("LF", "")
    models.find(m => trimmedName.contains(m.name) && (trimmedName.size < (m.name.size + 4)))
  }

  def getUpdatedFields(elem: Elem, model: Model): List[Elem] = {
    val replaces = new scala.collection.mutable.ListBuffer[Elem]
    val xmlFields: Group[Elem] = elem \\ "field"

    xmlFields.map { field =>
      val name = field.attrs(QName(None, "name"))
      val fieldType = field.attrs(QName(None, "type")).toLowerCase
      val variable = model.variables.find(_.name.toLowerCase == name.toLowerCase)

      if (variable.isDefined &&
        isHintable(fieldType, variable.get.vType))
        replaces += getXmlHint(variable.get, variable.get.vType)
      else
        replaces += field
    }
    replaces.toList
  }

  private def isHintable(fieldType: String, varType: String) = {
    if (fieldType == "string" && varType == "VARCHAR") true
    else if (fieldType == "string" && varType == "Text") true
    else if (fieldType == "bigdecimal" && varType == "BigDecimal") true
    else false
  }
}

package com.arcusys.learn.storage.impl.orbroker

import org.postgresql.ds.PGPoolingDataSource
import java.io.File
import java.io.IOException
import java.net.URISyntaxException
import java.util.Properties
import java.util.jar.JarFile
import org.orbroker._
import org.orbroker.config.dynamic._
import org.orbroker.config._
import collection.JavaConversions._
import scala.collection.mutable

object BrokerFactory {
  var ds: Option[PGPoolingDataSource] = None

  private def getBroker(properties: Properties) = {
    Class.forName("org.postgresql.Driver")
    if (ds != None) ds.get.close()
    ds = Some(new PGPoolingDataSource)
    ds.get.setDataSourceName("Data Source")
    ds.get.setServerName(properties.getProperty("server", ""))
    ds.get.setDatabaseName(properties.getProperty("database", ""))
    ds.get.setUser(properties.getProperty("login", ""))
    ds.get.setPassword(properties.getProperty("password", ""))
    ds.get.setMaxConnections(100000)
    val builder = new BrokerConfig(ds.get) with FreeMarkerSupport

    val resPath = "sql"

    val resources = Map(getAllResources(resPath).map(res => (Symbol(getFileName(res)), res)): _*)
    ClasspathRegistrant(resources).register(builder)
    //FileSystemRegistrant(new java.io.File(getClass.getResource("/sql").getPath)).register(builder)
    Broker(builder)
  }

  private var _broker: Option[Broker] = None

  def init(properties: Properties) {
    _broker = Some(getBroker(properties))
  }

  def isInitialized = {
    _broker != None
  }

  def broker = {
    _broker.getOrElse(throw new Exception("Broker doesn't initialized!"))
  }

  private def getFileName(name: String) = {
    val file = new File(name)
    val re = """(?i)(.[^/]+?)(?=\.)""".r
    re.findFirstIn(file.getName).getOrElse(name)
  }

  // because of java resource loader (-_-)
  private def getAllResources(relPath: String): Seq[String] = {
    def recursiveLookup(directory: File): Array[String] = {
      val data: mutable.Buffer[String] = mutable.Buffer.empty

      val dirFiles = directory.list.map(p => new File(directory.getPath + "/" + p))
      val filteredDirs = dirFiles.filter(_.isDirectory).map(recursiveLookup(_).map(directory.getName + "/" + _))
      filteredDirs.foreach(_.foreach(data += _))

      directory.list.filter(p => p.endsWith(".sql")).map(p => directory.getName + "/" + p) ++ data
    }

    val resource = Thread.currentThread.getContextClassLoader.getResource(relPath)
    if (resource == null) throw new Exception("Can't find directory '" + relPath + "'")
    val path = resource.getFile
    val directory = try {
      new File(resource.toURI)
    } catch {
      case uri: URISyntaxException => throw new RuntimeException("sql (" + resource + ") does not appear to be a valid URL / URI.  Strange, since we got it from the system...", uri)
      case arg: IllegalArgumentException => null
    }

    if (directory != null && directory.exists()) {
      // Get the list of the files contained in the package
      recursiveLookup(directory).map(e => "/" + e).toSeq
    } else {
      // lookup as dependency jar
      try {
        val jarPath = path.replaceFirst("[.]jar[!].*", ".jar").replaceFirst("file:", "")
        val jarFile = new JarFile(jarPath)
        val entries = jarFile.entries.filter(p => (p.getName.startsWith(relPath) && (p.getName.length > (relPath.length + "/".length))))

        entries.map(e => "/" + e.getName).toSeq
      } catch {
        case e: IOException => throw new RuntimeException("sql (" + directory + ") does not appear to be a valid package", e)
      }
    }
  }

}
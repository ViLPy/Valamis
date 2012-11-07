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
import org.h2.jdbcx.JdbcDataSource
import javax.sql.DataSource
import com.arcusys.scorm.util.FileSystemUtil

object BrokerFactory {
  var dsPostgres: Option[PGPoolingDataSource] = None
  var dsH2: Option[JdbcDataSource] = None

  private def getBroker(properties: Properties) = {
    if (dsPostgres.isDefined) {
      dsPostgres.get.close()
      dsPostgres = None
    }

    val ds: DataSource = properties.getProperty("dbManagementSystem") match {
      case "postgres" => {
        Class.forName("org.postgresql.Driver")
        dsPostgres = Some(new PGPoolingDataSource)
        dsPostgres.get.setDataSourceName("Data Source")
        dsPostgres.get.setServerName(properties.getProperty("server", ""))
        dsPostgres.get.setDatabaseName(properties.getProperty("database", ""))
        dsPostgres.get.setUser(properties.getProperty("login", ""))
        dsPostgres.get.setPassword(properties.getProperty("password", ""))
        dsPostgres.get.setMaxConnections(100000)
        dsPostgres.get
      }
      case _ => {
        Class.forName("org.h2.Driver")
        dsH2 = Some(new JdbcDataSource)
        dsH2.get.setDescription("Data Source")
        if (!properties.getProperty("testPackage","false").toBoolean){
          val filename = FileSystemUtil.getRealPath("/SCORMData/" + properties.getProperty("database", ""))
          dsH2.get.setURL("jdbc:h2:file:" + filename + ";IFEXISTS=TRUE;AUTOCOMMIT=ON;IGNORECASE=TRUE;PAGE_SIZE=2048;CACHE_SIZE=128000;DB_CLOSE_DELAY=100")
        } else {
          dsH2.get.setURL("jdbc:h2:mem:scorm;IGNORECASE=TRUE;AUTOCOMMIT=ON;DB_CLOSE_DELAY=-1")
        }
        dsH2.get.setUser(properties.getProperty("login", ""))
        dsH2.get.setPassword(properties.getProperty("password", ""))
        dsH2.get
      }
    }
    val builder = new BrokerConfig(ds) with FreeMarkerSupport

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
    // create path to JAR
    val path = resource.getFile.substring(0,resource.getFile.lastIndexOf("/" + relPath))
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
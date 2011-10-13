package com.arcusys.scorm.storage.impl.orbroker
import org.postgresql.ds.PGPoolingDataSource
import org.orbroker._
import org.orbroker.config.dynamic._
import org.orbroker.config._

import com.arcusys.scorm.util.PropertyUtil

object BrokerFactory
{
  var ds: Option[PGPoolingDataSource] = None
  private def getBroker = {
    Class.forName("org.postgresql.Driver")
    val properties = PropertyUtil.load("db")
    if (ds!=None) ds.get.close
    ds = Some(new PGPoolingDataSource)
    ds.get.setDataSourceName("Data Source")
    ds.get.setServerName(properties.getProperty("server", ""))
    ds.get.setDatabaseName(properties.getProperty("database", ""))
    ds.get.setUser(properties.getProperty("login", ""))
    ds.get.setPassword(properties.getProperty("password", ""))
    ds.get.setMaxConnections(10)
    val builder = new BrokerBuilder(ds.get) with FreeMarkerSupport
    FileSystemRegistrant(new java.io.File(getClass.getResource("/sql").getPath)).register(builder)
    builder.build
  }
  private var _broker = getBroker
  def broker = _broker
  def refresh = {_broker = getBroker}
}
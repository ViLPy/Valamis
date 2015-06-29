package com.arcusys.learn.service

import javax.sql.DataSource

import com.arcusys.valamis.core.SlickDBInfo
import com.liferay.portal.kernel.dao.jdbc.DataAccess
import com.liferay.portal.kernel.util.InfrastructureUtil

import scala.slick.driver.{JdbcDriver, JdbcProfile}

class SlickDBInfoLiferayImpl extends SlickDBInfo {

  lazy val dataSource = InfrastructureUtil.getDataSource
  lazy val slickDriver = getSlickDriver(dataSource)
  lazy val slickProfile: JdbcProfile = slickDriver
  lazy val databaseDef = slickDriver.profile.backend.Database.forDataSource(dataSource)

  private def getSlickDriver(dataSource: DataSource): JdbcDriver = {
    val connection = dataSource.getConnection
    try {
      val databaseMetaData = connection.getMetaData
      val dbName = databaseMetaData.getDatabaseProductName
      val dbMajorVersion = databaseMetaData.getDatabaseMajorVersion

      if (dbName.startsWith("HSQL")) {
        scala.slick.driver.HsqldbDriver
      } //      if (dbName.equals("ASE") && (dbMajorVersion == 15)) {
      //        dialect = new SybaseASE157Dialect()
      //      }
      // "Microsoft SQL Server" "Microsoft SQL Server Database"
      else if (dbName.startsWith("Microsoft") && (dbMajorVersion >= 9)) {
        com.arcusys.slick.drivers.SQLServerDriver
      } else if (dbName.startsWith("Oracle") && (dbMajorVersion >= 10)) {
        com.arcusys.slick.drivers.OracleDriver
      } else if (dbName.equals("H2")) {
        scala.slick.driver.H2Driver
      } else if (dbName.equals("MySQL")) {
        scala.slick.driver.MySQLDriver
      } else if (dbName.equals("PostgreSQL")) {
        scala.slick.driver.PostgresDriver
      } else if (dbName.equals("Apache Derby")) {
        scala.slick.driver.DerbyDriver
      } else if (dbName.contains("Access")) {
        scala.slick.driver.AccessDriver
      } //      else if (dbName.equals("Ingres") || dbName.equals("ingres") || dbName.equals("INGRES")) {
      //        scala.slick.driver.
      //      }
      //      else if (dbName.equals("Sybase SQL Server")) {
      //        scala.slick.driver.
      //      }
      //      else if (dbName.equals("Adaptive Server Enterprise")) {
      //        scala.slick.driver.
      //      }
      //      else if (dbName.equals("Informix Dynamic Server")) {
      //        scala.slick.driver.
      //      }
      // databases - "DB2/NT" "DB2/LINUX"  "DB2/6000" "DB2/HPUX" "DB2/SUN" "DB2/LINUX390" "DB2/AIX64"
      else if (dbName.startsWith("DB2") && (dbMajorVersion >= 9)) {
        com.arcusys.slick.drivers.DB2Driver
      } //      }"DB2/AIX64", new VersionInsensitiveMapper( "org.hibernate.dialect.DB2Dialect" ) );
      else {
        throw new RuntimeException("Unsupport database: " + dbName + " " + dbMajorVersion)
      }
    } finally {
      DataAccess.cleanUp(connection)
    }
  }
}

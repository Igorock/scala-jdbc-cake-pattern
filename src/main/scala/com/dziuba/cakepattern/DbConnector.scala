package com.dziuba.cakepattern

import java.sql.{Connection, DriverManager}

class DbConnector {
  def getConnection: Connection = DbConnector.getConnection
}

object DbConnector {

  val driver = "com.mysql.jdbc.Driver"
  val url = "jdbc:mysql://localhost/DZ"
  val username = "root"
  val password = ""

  Class.forName(driver)

  def getConnection:Connection = DriverManager.getConnection(url, username, password)
}

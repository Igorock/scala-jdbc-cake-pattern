package com.dziuba.cakepattern.dao

import java.sql.ResultSet

import com.dziuba.cakepattern.DbConnector

trait CommonDAO {

  implicit val dbConnector: DbConnector

  def findOne[T](query: String, get: ResultSet => T): Option[T] =
    findAll(query, get).headOption

  def findAll[T](query: String, get: ResultSet => T): List[T] = {
    val conn = dbConnector.getConnection
    autoClose(conn, conn.createStatement()) { statement =>
      val rs = statement.executeQuery(query)

      Iterator.continually(rs.next())
        .takeWhile(identity)
        .map(_ => get(rs))
        .toList
    }
  }

  def autoClose[C <: AutoCloseable,A <: AutoCloseable,B](closeable1: C, closeable: A)(fun: (A) ⇒ B): B =
    try {
      fun(closeable)
    } finally {
      close(closeable)
      close(closeable1)
    }

  def close[A <: AutoCloseable](c: A): Unit = if (c != null) c.close()

}

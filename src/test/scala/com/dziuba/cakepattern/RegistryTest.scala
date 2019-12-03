package com.dziuba.cakepattern

import java.sql.{Connection, ResultSet, Statement}

import org.mockito.Mockito.when
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{BeforeAndAfter, FlatSpec}

class RegistryTest extends FlatSpec with MockitoSugar with BeforeAndAfter {

  it should "register services with cake pattern" in {
    val dbConnector = mock[DbConnector]
    val connection = mock[Connection]
    val stmt1 = mock[Statement]
    val stmt2 = mock[Statement]
    val stmt3 = mock[Statement]
    val rs1 = mock[ResultSet]
    val rs2 = mock[ResultSet]
    val rs3 = mock[ResultSet]

    when(dbConnector.getConnection).thenReturn(connection)
    when(connection.createStatement()).thenReturn(stmt1, stmt2, stmt3)

    when(stmt1.executeQuery("SELECT * FROM user where id = 2")).thenReturn(rs1)
    when(rs1.next()).thenReturn(true, false)
    when(rs1.getString("firstname")).thenReturn("Ivan")
    when(rs1.getString("middlename")).thenReturn("Volodymyr")
    when(rs1.getString("lastname")).thenReturn("Sirenko")

    when(stmt2.executeQuery("SELECT * FROM level where user_id = 2")).thenReturn(rs2)
    when(rs2.next()).thenReturn(true, false)
    when(rs2.getInt("id")).thenReturn(4)
    when(rs2.getString("name")).thenReturn("new")

    when(stmt3.executeQuery("SELECT * FROM user")).thenReturn(rs3)
    when(rs3.next()).thenReturn(true, false)
    when(rs3.getString("firstname")).thenReturn("Ivan")
    when(rs3.getString("middlename")).thenReturn("Volodymyr")
    when(rs3.getString("lastname")).thenReturn("Sirenko")

    val registry = new Registry(dbConnector)
    assertResult("Hello, Ivan! Level: new")(registry.welcomeService.welcome(2))

    val users = registry.welcomeService.getAllUsers
    assertResult(1)(users.size)
    assertResult("Ivan")(users.head.firstName)
    assertResult("Volodymyr")(users.head.middleName)
    assertResult("Sirenko")(users.head.lastName)
  }

}

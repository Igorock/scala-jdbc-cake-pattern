package com.dziuba.cakepattern.component

import com.dziuba.cakepattern.DbConnector
import com.dziuba.cakepattern.dao.{LevelDAO, UserDAO}

trait WelcomeComponent {

  implicit def dbConnector: DbConnector

  val stepDAO = new LevelDAO()
  val userDAO = new UserDAO()

}

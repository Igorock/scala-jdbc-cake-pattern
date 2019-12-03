package com.dziuba.cakepattern.service

import com.dziuba.cakepattern.component.WelcomeComponent
import com.dziuba.cakepattern.entity.{Level, User}

class WelcomeService() {
  this: WelcomeComponent =>

  def welcome(userId: Int): String = {
    val user = userDAO.find(userId).getOrElse(User(0, "Anonim"))
    val level = stepDAO.findByUserId(userId).getOrElse(Level(0, "Not found", 0))

    s"Hello, ${user.firstName}! Level: ${level.name}"
  }

  def getAllUsers: List[User] = userDAO.findAll()
}

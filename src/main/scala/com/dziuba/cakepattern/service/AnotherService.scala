package com.dziuba.cakepattern.service

import com.dziuba.cakepattern.component.WelcomeComponent

class AnotherService {
  this: WelcomeComponent =>

  def goodbye(id: Int): String = "Good bye, " + userDAO.find(id).get.firstName + "!"

}

package com.dziuba.cakepattern

import com.dziuba.cakepattern.component.WelcomeComponent
import com.dziuba.cakepattern.service.{AnotherService, WelcomeService}

class Registry(val connector: DbConnector) {
  val welcomeService = new WelcomeService() with WelcomeComponent {
    def dbConnector: DbConnector = connector
  }

  val anotherService = new AnotherService() with WelcomeComponent {
    def dbConnector: DbConnector = connector
  }
}


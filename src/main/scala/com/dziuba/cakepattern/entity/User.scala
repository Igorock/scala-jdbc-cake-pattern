package com.dziuba.cakepattern.entity

case class User(id: Int, firstName: String, middleName: String = "", lastName: String = "") extends Entity

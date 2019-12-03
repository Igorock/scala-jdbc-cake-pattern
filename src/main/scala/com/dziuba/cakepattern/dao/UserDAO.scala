package com.dziuba.cakepattern.dao

import com.dziuba.cakepattern.DbConnector
import com.dziuba.cakepattern.dao.UserDAO._
import com.dziuba.cakepattern.entity.User

class UserDAO(implicit val dbConnector: DbConnector) extends CommonDAO {
  def find(id: Int): Option[User] = findOne(FindQuery + id, rs =>
    User(rs.getInt("id"), rs.getString("firstname"), rs.getString("middlename"), rs.getString("lastname")))

  def findAll(): List[User] = findAll(FindAllQuery, rs =>
    User(rs.getInt("id"), rs.getString("firstname"), rs.getString("middlename"), rs.getString("lastname")))
}

object UserDAO {
  val FindQuery = "SELECT * FROM user where id = "
  val FindAllQuery = "SELECT * FROM user"
}

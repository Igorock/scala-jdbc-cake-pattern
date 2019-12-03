package com.dziuba.cakepattern.dao

import com.dziuba.cakepattern.DbConnector
import com.dziuba.cakepattern.dao.LevelDAO.FindByUserIdQuery
import com.dziuba.cakepattern.entity.Level

class LevelDAO(implicit val dbConnector: DbConnector) extends CommonDAO {
  def findByUserId(userId: Int): Option[Level] = findOne(FindByUserIdQuery + userId, rs => Level(rs.getInt("id"), rs.getString("name"), userId))
}

object LevelDAO {
  val FindByUserIdQuery = "SELECT * FROM level where user_id = "
}

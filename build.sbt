name := "scala-jdbc-cake-pattern"

version := "1.0"

scalaVersion := "2.11.8"


libraryDependencies ++= Seq(
  "org.slf4j" % "slf4j-log4j12" % "1.7.25",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.8.0",
  "mysql" % "mysql-connector-java" % "5.1.16",

  "org.scalatest" %% "scalatest" % "3.0.5" % Test,
  "org.mockito" % "mockito-all" % "1.10.19" % Test,
  "com.googlecode.json-simple" % "json-simple" % "1.1.1" % Test
)



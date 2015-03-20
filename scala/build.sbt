name := "email-validator"

organization := "com.franklinchen"

version := "1.0.1"

scalaVersion := "2.11.6"

scalacOptions ++= Seq(
  "-deprecation"
)

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.3",
  "org.scalacheck" %% "scalacheck" % "1.12.2" % "test",
  "org.specs2" %% "specs2-core" % "3.1" % "test",
  "org.specs2" %% "specs2-matcher-extra" % "3.1" % "test"
)

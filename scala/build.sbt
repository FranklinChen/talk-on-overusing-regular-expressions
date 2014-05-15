name := "email-validator"

organization := "com.franklinchen"

version := "1.0.1"

scalaVersion := "2.11.0"

scalacOptions += Seq(
  "-deprecation"
)

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.1",
  "org.scalacheck" %% "scalacheck" % "1.11.4" % "test",
  "org.specs2" %% "specs2" % "2.3.12" % "test"
)

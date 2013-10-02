name := "email-validator"

organization := "com.franklinchen"

version := "1.0.1"

scalaVersion := "2.10.3"

libraryDependencies ++= Seq(
  "org.scalacheck" %% "scalacheck" % "1.10.1" % "test",
  "org.specs2" %% "specs2" % "2.2.2" % "test"
)

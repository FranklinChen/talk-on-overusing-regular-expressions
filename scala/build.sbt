name := "email-validator"

organization := "com.franklinchen"

version := "1.0.0"

scalaVersion := "2.10.2-RC2"

libraryDependencies ++= Seq(
  "org.scalacheck" %% "scalacheck" % "1.10.1" % "test",
  //1.14
  "org.specs2" %% "specs2" % "2.0-RC1" % "test"
)

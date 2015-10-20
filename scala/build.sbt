name := "email-validator"

organization := "com.franklinchen"

version := "1.0.1"

scalaVersion := "2.11.7"

scalacOptions ++= Seq(
  "-deprecation"
)

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.4",
  "org.scalacheck" %% "scalacheck" % "1.12.5" % Test,
  "org.specs2" %% "specs2-core" % "3.6.5" % Test,
  "org.specs2" %% "specs2-matcher-extra" % "3.6.5" % Test
)

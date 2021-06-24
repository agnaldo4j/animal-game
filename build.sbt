val scalatestVersion = "3.2.9"

ThisBuild / organization := "br.com.jefoland"
ThisBuild / scalaVersion := "3.0.0"
ThisBuild / version      := "0.1.0-SNAPSHOT"
ThisBuild / name         := "animal-game"
ThisBuild / javacOptions ++= Seq("-source", "1.11", "-target", "1.11")

lazy val scalaTestDependency = Seq(
  "org.scalactic" %% "scalactic" % scalatestVersion,
  "org.scalatest" %% "scalatest" % scalatestVersion % "test",
  "org.scalatest" %% "scalatest-freespec" % scalatestVersion % "test"
)

lazy val root = project
  .in(file("."))
  .settings(
    libraryDependencies ++= scalaTestDependency
  )
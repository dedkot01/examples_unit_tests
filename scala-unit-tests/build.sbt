val scala3Version = "3.5.2"

lazy val root = project
  .in(file("."))
  .settings(
    name := "unit_tests_fvt",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies ++= Seq(
      "com.softwaremill.sttp.client4" %% "core" % "4.0.0-M6",
      "org.scalamock" %% "scalamock" % "6.0.0" % Test,
      "org.scalatest" %% "scalatest" % "3.2.19" % Test
    )
  )

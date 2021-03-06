import com.typesafe.sbt.SbtGit.GitKeys._

name := "zucchini"
version := "0.1-SNAPSHOT"

scalacOptions in Test ++= Seq("-Yrangepos", "-language:higherKinds")

libraryDependencies ++= {
  if (scalaVersion.value.startsWith("2.10."))
    Seq(compilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full))
  else Seq()
}

libraryDependencies ++= {
  val Scalacheck = "1.14.3"

  Seq(
    "org.scalacheck" %% "scalacheck" % Scalacheck,
    "org.scalactic" %% "scalactic" % "3.0.8",
    "org.scalatest" %% "scalatest" % "3.0.8" % "test"
  )
}

lazy val standardSettings = Seq(
  name := "zucchini",
  scalaVersion := "2.13.0",
  crossScalaVersions := Seq("2.13.0", "2.12.6"),
  organization := "com.danielasfregola",
  licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0.html")),
  homepage := Some(url("https://github.com/DanielaSfregola/zucchini")),
  scmInfo := Some(
    ScmInfo(url("https://github.com/DanielaSfregola/zucchini"),
      "scm:git:git@github.com:DanielaSfregola/zucchini.git")),
  apiURL := None, // TBD scaladoc needed?
  pomExtra := (
    <developers>
      <developer>
        <id>DanielaSfregola</id>
        <name>Daniela Sfregola</name>
        <url>http://danielasfregola.com/</url>
      </developer>
    </developers>
    ),
  publishMavenStyle := true,
  publishTo := {
    if (version.value.trim.endsWith("SNAPSHOT")) Some(Opts.resolver.sonatypeSnapshots)
    else Some(Opts.resolver.sonatypeStaging)
  },
  gitRemoteRepo := "git@github.com:DanielaSfregola/zucchini.git",
  scalacOptions ++= Seq("-encoding",
    "UTF-8",
    "-deprecation",
    "-Xfatal-warnings",
    "-feature",
    "-unchecked",
    "-language:postfixOps",
    "-language:experimental.macros"),
  scalacOptions in(Compile, doc) ++= Seq("-sourcepath", baseDirectory.value.getAbsolutePath),
  autoAPIMappings := true,
  apiURL := None,
  scalacOptions in(Compile, doc) ++= {
    val branch = if (version.value.trim.endsWith("SNAPSHOT")) "master" else version.value
    Seq(
      "-doc-source-url",
      "https://github.com/DanielaSfregola/zucchini/tree/" + branch + "€{FILE_PATH}.scala"
    )
  }
)

lazy val root = (project in file(".")).settings(standardSettings)

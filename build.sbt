
scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "Typesafe Snapshots" at "http://repo.typesafe.com/typesafe/snapshots/"

lazy val commonSettings = Seq(
  organization := "com.whiteprompt",
  version := "0.1.0",
  scalaVersion := "2.12.6"
)

lazy val root = (project in file("."))
  .settings(commonSettings: _*)
  .settings(
    name := "Akka HTTP vs Play Framework"
  )
  .aggregate(core, apiAkkaHttp, apiPlay, loadTest)

lazy val core = Project(
  "core",
  file("core"))
  .settings(commonSettings: _*)
  .settings(
    name := "Core",
    libraryDependencies ++= Dependencies.commonDependencies ++ Dependencies.akkaDependencies
  )

lazy val apiAkkaHttp = Project(
  "api-akka-http",
  file("api-akka-http"))
  .settings(commonSettings: _*)
  .settings(
    name := "API Akka-Http",
    libraryDependencies ++= Dependencies.commonDependencies ++ Dependencies.akkaDependencies ++
      Dependencies.akkaHttpDependencies
  )
  .dependsOn(core % "compile -> compile; test -> test")


lazy val apiPlay = Project(
  "api-play",
  file("api-play"))
  .enablePlugins(PlayScala)
  .settings(commonSettings: _*)
  .settings(
    name := "API Play",
    routesGenerator := InjectedRoutesGenerator,
    libraryDependencies ++= Dependencies.commonDependencies ++ Dependencies.playDependencies ++
      Dependencies.akkaDependencies ++ Seq(guice)
  )
  .dependsOn(core % "compile -> compile; test -> test")

lazy val loadTest = Project(
  "load-test",
  file("load-test"))
  .enablePlugins(GatlingPlugin)
  .settings(commonSettings: _*)
  .settings(
    name := "Load tests",
    libraryDependencies ++= Dependencies.commonDependencies ++ Dependencies.gatlingDependencies
  )
  .dependsOn(core)
  .dependsOn(apiAkkaHttp)

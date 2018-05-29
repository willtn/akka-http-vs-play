import sbt._

object Dependencies {

  val commonDependencies = {
    val scalaTestVersion = "3.0.5"
    Seq(
      "org.scalatest" %% "scalatest" % scalaTestVersion % "test"
    )
  }

  val akkaDependencies = {
    val akkaVersion = "2.5.12"
    Seq(
      "com.typesafe.akka" %% "akka-actor"   % akkaVersion,
      "com.typesafe.akka" %% "akka-slf4j"   % akkaVersion,
      "com.typesafe.akka" %% "akka-testkit" % akkaVersion % "test"
    )
  }

  val akkaHttpDependencies = {
    val akkaHttpVersion = "10.1.1"
    val json4sVersion = "3.5.4"
    Seq(
      "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion % "test",

      "org.json4s" %% "json4s-jackson" % json4sVersion,
      "org.json4s" %% "json4s-ext" % json4sVersion,
      "de.heikoseeberger" %% "akka-http-json4s" % "1.21.0"
    )
  }

  val playDependencies = Seq(
    "org.scalatestplus" %% "play" % "3.1.0" % "test"
  )

  val gatlingDependencies = Seq(
    "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.3.0" % "test",
    "io.gatling"            % "gatling-test-framework"    % "2.3.0" % "test"
  )
}


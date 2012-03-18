name := "Lift Push Knock Out"

version := "0.5"

organization := "com.withoutincident"

scalaVersion := "2.9.1"

{
  val liftVersion = "2.4"
  libraryDependencies ++= Seq(
    "net.liftweb" %% "lift-webkit" % liftVersion,
    "net.liftweb" %% "lift-mongodb" % liftVersion
  )
}

libraryDependencies ++= Seq(
  "org.mortbay.jetty" % "jetty" % "6.1.22" % "container",
  "ch.qos.logback" % "logback-classic" % "0.9.18"
)

scalacOptions ++= Seq("-encoding", "UTF-8", "-deprecation", "-unchecked")

javacOptions  ++= Seq("-Xlint:unchecked", "-Xlint:deprecation")

seq(webSettings :_*)

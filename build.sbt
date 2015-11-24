name := "com.inkenkun.x1.scala.benchmark"

version := "1.0"

scalaVersion := "2.11.7"

scalacOptions ++= Seq( "-deprecation", "-encoding", "UTF-8", "-target:jvm-1.8" )

testOptions += Tests.Argument( "console", "junitxml" )

resolvers += "Spy" at "http://files.couchbase.com/maven2/"

libraryDependencies ++= Seq(
  "com.bionicspirit" %% "shade"          % "1.6.0",
  "net.debasishg"    %% "redisclient"    % "3.0",
  "org.scalatest"     % "scalatest_2.11" % "2.2.4" % "test"
)

enablePlugins( JmhPlugin )
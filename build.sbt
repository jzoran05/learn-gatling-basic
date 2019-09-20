name := "basicsimulation"

version := "0.1"

enablePlugins(GatlingPlugin)

scalaVersion := "2.12.9"

libraryDependencies += "io.gatling.highcharts" % "gatling-charts-highcharts" % "3.2.1" % "test"
libraryDependencies += "io.gatling"            % "gatling-test-framework"    % "3.2.1" % "test"

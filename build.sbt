name := "basicsimulation"

version := "0.1"

enablePlugins(GatlingPlugin)

scalaVersion := "2.12.9"

libraryDependencies += "io.gatling.highcharts" % "gatling-charts-highcharts" % "3.2.1" % "test"
libraryDependencies += "io.gatling"            % "gatling-test-framework"    % "3.2.1" % "test"
libraryDependencies += "com.azure"             % "azure-storage-blob"        % "12.0.0-preview.3" % "test"
libraryDependencies += "com.azure"             % ":azure-core-http-netty"    % "1.0.0-preview.4"  % "test"

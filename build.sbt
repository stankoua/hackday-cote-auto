name := """new-project"""

version := "0.0.1-SNAPSHOT"

val commonSettings = Seq(
  scalaVersion := "2.11.8"
) ++ Scalariform.settings

lazy val root = (project in file("."))
  .enablePlugins(PlayScala, BuildInfoPlugin)
  .settings(commonSettings: _*)
  .settings(
    buildInfoKeys := Seq[BuildInfoKey](
      name,
      version,
      scalaVersion
    ),
    buildInfoPackage := "sbt",
    buildInfoOptions += BuildInfoOption.BuildTime
  )

libraryDependencies ++= Seq(
  ws,
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test
)

scalacOptions := Seq(
  "-encoding", "UTF-8",
  "-target:jvm-1.8",
  "-Ywarn-infer-any",
  "-Ywarn-dead-code",
  "-Ywarn-unused",
  "-Ywarn-unused-import",
  "-Ywarn-value-discard",
  "-unchecked",
  "-deprecation",
  "-feature",
  "-g:vars",
  "-Xlint:_",
  "-Yconst-opt",
  "-Yclosure-elim",
  "-Ydead-code",
  "-Yopt:_"
)

// dont include local.conf in dist
mappings in Universal := {
  val origMappings = (mappings in Universal).value
  origMappings.filterNot { case (_, file) => file.endsWith("local.conf") }
}

// name dist with timestamp
val timestamp = new java.text.SimpleDateFormat("yyyyMMdd-HHmm").format(new java.util.Date)
packageName in Universal := s"${name.value}-${version.value}-$timestamp"

// skip scaladoc when running dist
publishArtifact in (Compile, packageDoc) := false
publishArtifact in packageDoc := false
sources in (Compile,doc) := Seq.empty

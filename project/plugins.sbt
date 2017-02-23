// The Typesafe repository
resolvers += "Typesafe repository" at "https://repo.typesafe.com/typesafe/maven-releases/"

// Use the Play sbt plugin for Play projects
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.5.9")

// Scalariform to keep an homogeneous code style
addSbtPlugin("org.scalariform" % "sbt-scalariform" % "1.5.0")

// Add build infos into code
addSbtPlugin("com.eed3si9n" % "sbt-buildinfo" % "0.6.1")

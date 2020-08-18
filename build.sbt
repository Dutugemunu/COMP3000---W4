scalaVersion := "2.12.8"

resolvers += Resolver.bintrayRepo("underscoreio", "training")

initialCommands in console := """
      |import doodle.core._
      |import doodle.image._
      |import doodle.image.syntax._
      |import doodle.image.syntax.core._
      |import doodle.java2d._
    """.trim.stripMargin

cleanupCommands in console := """
      |doodle.jvm.quit()
    """.trim.stripMargin

libraryDependencies ++= Seq(
  "underscoreio" %% "doodle" % "0.8.3",
  "org.typelevel" %% "cats-core" % "1.1.0"
)

libraryDependencies ++=
    Seq (
        "junit" % "junit" % "4.12" % "test",
        "org.scalatest" %% "scalatest" % "3.0.3" % "test",
        "org.creativescala" %% "doodle" % "0.9.6",
        "org.creativescala" %% "doodle-reactor" % "0.9.6"
    )
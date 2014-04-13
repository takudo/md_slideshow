name := "md_slideshow"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  "com.tristanhunt" %% "knockoff" % "0.8.2"
)     

play.Project.playScalaSettings

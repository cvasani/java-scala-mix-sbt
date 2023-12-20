val scala3Version = "3.3.0"
// val scala3Version = "2.13.8"
// sbt new scala/scala3.g8
val junitDep = "junit" % "junit" % "4.13.2"
val junitInterfaceDep = "com.github.sbt" % "junit-interface" % "0.13.3" % Test
val scalacheckDep = "org.scalacheck" %% "scalacheck" % "1.15.4" % Test
val jolDep = "org.openjdk.jol" % "jol-core" % "0.16"
val testInterfaceDep = "org.scala-sbt" % "test-interface" % "1.0"
val diffUtilsDep = "io.github.java-diff-utils" % "java-diff-utils" % "4.12"
compileOrder := CompileOrder.JavaThenScala

lazy val root = project
  .in(file("."))
  .settings(
    name := "Scala3",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,
    // semanticdbEnabled := true,
    libraryDependencies += "org.scalameta" %% "munit" % "0.7.29" % Test,
    libraryDependencies += "com.lihaoyi" %% "ujson" % "3.1.2",
    // // https://mvnrepository.com/artifact/com.oracle.database.jdbc/ojdbc10
    libraryDependencies += "com.oracle.database.jdbc" % "ojdbc10" % "19.12.0.0",
    // scalacOptions ++= Seq(
    //       "-deprecation",
    //       "-explain",
    //       "-explain-types",
    //       "-new-syntax",
    //       "-unchecked",
    //       "-Xfatal-warnings",
    //       "-Xmigration"
    //     ),
    libraryDependencies ++= List("org.projectlombok" % "lombok" % "1.18.22" ),
    libraryDependencies ++= List( "io.projectreactor"          % "reactor-core"    % "3.5.10","io.reactivex.rxjava2"       % "rxjava"          % "2.2.21"),

    // https://mvnrepository.com/artifact/io.projectreactor/reactor-core

    javacOptions ++=
      List[String](
        s"-Arandomtimestamp=${System.nanoTime()}",
        List(
          s"-Xplugin:semanticdb",
          s"-build-tool:sbt",
          s"-text:on",
          s"-verbose",
          s"-sourceroot:${(ThisBuild / baseDirectory).value}",
          s"-targetroot:${(Compile / semanticdbTargetRoot).value}"
        ).mkString(" ")
      )
  )

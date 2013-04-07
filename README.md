OAuth-mapperLift Module
========================

Mapper-based extension to the Lift OAuth module.

To include this module in your Lift project, update your `libraryDependencies` in `build.sbt` to include:

*Lift 2.5.x* for Scala 2.9 and 2.10:

    "net.liftmodules" %% "oauth-mapper_2.5" % "1.2"

*Lift 3.0.x* for Scala 2.10:

    "net.liftmodules" %% "oauth-mapper_3.0" % "1.2-SNAPSHOT"

**Note:** The module package changed from `net.liftweb.oauth.mapper` to `net.liftmodules.oauth.mapper` in May 2012.  Please consider this when referencing documentation written before that date.

Notes for module developers
===========================

* The [Jenkins build](https://liftmodules.ci.cloudbees.com/job/oauth-mapper/) is triggered on a push to master.




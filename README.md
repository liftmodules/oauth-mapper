OAuth-mapperLift Module
========================

Mapper-based extension to the Lift OAuth module.

To include this module in your Lift project, update your `libraryDependencies` in `build.sbt` to include:

*Lift 2.6.x* for Scala 2.11 and 2.10:

    "net.liftmodules" %% "oauth-mapper_2.6" % "1.2-SNAPSHOT"


*Lift 2.5.x* for Scala 2.9 and 2.10:

    "net.liftmodules" %% "oauth-mapper_2.5" % "1.2"

*Lift 3.0.x* for Scala 2.10:

    "net.liftmodules" %% "oauth-mapper_3.0" % "1.2-SNAPSHOT"

**Note:** The module package changed from `net.liftweb.oauth.mapper` to `net.liftmodules.oauth.mapper` in May 2012.  Please consider this when referencing documentation written before that date.

Example Code
============

```scala
class MyUser extends ProtoUser[MyUser] with OAuthUser {
  def getSingleton = MyUser
}

object MyUser extends MyUser with KeyedMetaMapper[Long, MyUser]

class TestMOAuthConsumer extends MOAuthConsumer[TestMOAuthConsumer] {
  def getSingleton = TestMOAuthConsumer
  type UserType = MyUser
  def getUserMeta = MyUser
  type MOAuthTokenType = TestMOAuthToken
  def getMOAuthTokenMeta = TestMOAuthToken
}

object TestMOAuthConsumer extends TestMOAuthConsumer with MOAuthConsumerMeta[TestMOAuthConsumer]

class TestMOAuthToken extends MOAuthToken[TestMOAuthToken] {
  def getSingleton = TestMOAuthToken
  type UserType = MyUser
  def getUserMeta = MyUser
  type MOAuthConsumerType = TestMOAuthConsumer
  def getMOAuthConsumerMeta = TestMOAuthConsumer
}

object TestMOAuthToken extends TestMOAuthToken with MOAuthTokenMeta[TestMOAuthToken]
```


Notes for module developers
===========================

* The [Jenkins build](https://liftmodules.ci.cloudbees.com/job/oauth-mapper/) is triggered on a push to master.




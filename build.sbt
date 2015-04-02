name := "oauth-mapper"

organization := "net.liftmodules"

version := "1.2-SNAPSHOT"

liftVersion <<= liftVersion ?? "2.6.2"

liftEdition <<= liftVersion apply { _.substring(0,3) }

moduleName <<= (name, liftEdition) { (n, e) => n + "_" + e }

scalaVersion := "2.11.6"

scalacOptions ++= Seq("-unchecked", "-deprecation")

crossScalaVersions := Seq("2.11.6", "2.10.0")

resolvers += "Sonatype OSS Release" at "http://oss.sonatype.org/content/repositories/releases"

resolvers += "Sonatype OSS Snapshot" at "http://oss.sonatype.org/content/repositories/snapshots"

resolvers += "CB Central Mirror" at "http://repo.cloudbees.com/content/groups/public"

resolvers += "Java.net Maven2 Repository" at "http://download.java.net/maven/2/"

libraryDependencies <++= liftVersion { v =>
  "net.liftweb" %% "lift-webkit" % v % "provided" ::
  "net.liftweb" %% "lift-mapper" % v % "provided" ::
  Nil
}

libraryDependencies <++= (version,liftEdition) { (v,e) =>
  "net.liftmodules" %% ("oauth_"+e) % v % "compile" ::
  Nil
}

libraryDependencies += "org.specs2" %% "specs2-core" % "2.4.17" % "test"

publishTo <<= version { _.endsWith("SNAPSHOT") match {
 	case true  => Some("snapshots" at "https://oss.sonatype.org/content/repositories/snapshots")
 	case false => Some("releases" at "https://oss.sonatype.org/service/local/staging/deploy/maven2")
  }
 }


// For local deployment:

credentials += Credentials( file("sonatype.credentials") )

// For the build server:

credentials += Credentials( file("/private/liftmodules/sonatype.credentials") )

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { _ => false }


pomExtra := (
	<url>https://github.com/liftmodules/oauth-mapper</url>
	<licenses>
		<license>
	      <name>Apache 2.0 License</name>
	      <url>http://www.apache.org/licenses/LICENSE-2.0.html</url>
	      <distribution>repo</distribution>
	    </license>
	 </licenses>
	 <scm>
	    <url>git@github.com:liftmodules/oauth-mapper.git</url>
	    <connection>scm:git:git@github.com:liftmodules/oauth-mapper.git</connection>
	 </scm>
	 <developers>
	    <developer>
	      <id>liftmodules</id>
	      <name>Lift Team</name>
	      <url>http://www.liftmodules.net</url>
	 	</developer>
	 </developers>
 )


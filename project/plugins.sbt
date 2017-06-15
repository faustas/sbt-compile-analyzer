addSbtPlugin("org.wartremover"   % "sbt-wartremover" % "2.0.2")
addSbtPlugin("com.typesafe.sbt"  % "sbt-git"         % "0.9.3")
addSbtPlugin("com.lucidchart"    % "sbt-scalafmt"    % "1.1")
addSbtPlugin("de.heikoseeberger" % "sbt-header"      % "2.0.0")

libraryDependencies += "org.slf4j" % "slf4j-nop" % "1.7.25" // Needed by sbt-git

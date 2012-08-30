import sbt._
import Keys._

import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "coles shopping list"
    val appVersion      = "1.0"

    val main = PlayProject(appName, appVersion, mainLang = JAVA)

}
            

/*
 * Copyright 2023 Tomshley LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * @author Thomas Schena @sgoggles <https://github.com/sgoggles> | <https://gitlab.com/sgoggles>
 */

package com.tomshley.brands.global.tech.tware.products.hexagonal.plugins
package projectsettings

import sbt.Keys.*
import sbt.{Def, *}

/*
 * WARNING - TODO - Under Construction!
 */

object ProjectSettingsPlugin extends AutoPlugin {

  override val trigger: PluginTrigger = noTrigger

  override val requires: Plugins = plugins.JvmPlugin

  object autoImport extends ProjectSettingsKeys
  private lazy val baseSettings3: sbt.Def.SettingsDefinition = Seq(
    licenses := {
      val tagOrBranch =
        if (version.value.endsWith("SNAPSHOT")) "main"
        else "v" + version.value
      Seq(
        ("APACHE-2.0",
         url("https://raw.githubusercontent.com/tomshley/hexagonal-plugins-sbt/" + tagOrBranch + "/LICENSE"))
      )
    },
    scalacOptions += "-Wconf:cat=deprecation&msg=.*JavaConverters.*:s",
    scalaVersion := ProjectSettingsDefs.Scala3,
  )

  override def projectSettings: Seq[Def.Setting[?]] = super.projectSettings ++ baseSettings3

  //  private lazy val hexagonalPartTaskValue = settingKey[HexagonalPart]("the hexagonal architecture part")

//  private def hexagonalPartTask: Def.Initialize[HexagonalPart] = Def.setting {
//    println("FOOOOO 2" + hexagonalPart.value.toString)
//    println("FOOOOO 21" + Edge.toString)
//    hexagonalPart.value
//  }
//      hexagonalPart.value match {
//      case _: Edge.type => {
//        println("EdgeEdge")
//        Seq()
//      }
//      case _: ValueAdd.type => {
//        println("ValueAddValueAdd")
//        Seq()
//      }
//      case _: Core.type => {
//        println("CoreCore")
//        Seq()
//      }
//      case _: Lib.type => {
//        println("LibLib")
//        Seq()
//      }
//      case _ => {
//        println("nothing")
//        Seq()
//      }
//    }

  //    type hexagonalPar[X] = X match
//      case Edge => {
//        baseSettings3 ++
//        javaProject ++
//        jsonProject ++
//        akkaProject ++
//        libProject ++
//        scala3CrossVersions
//      }
//      case ValueAdd => {
//
//      }
//    }
}

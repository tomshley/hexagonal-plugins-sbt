/*
 * copyright 2023 tomshley llc
 *
 * licensed under the apache license, version 2.0 (the "license");
 * you may not use this file except in compliance with the license.
 * you may obtain a copy of the license at
 *
 * http://www.apache.org/licenses/license-2.0
 *
 * unless required by applicable law or agreed to in writing, software
 * distributed under the license is distributed on an "as is" basis,
 * without warranties or conditions of any kind, either express or implied.
 * see the license for the specific language governing permissions and
 * limitations under the license.
 *
 * @author thomas schena @sgoggles <https://github.com/sgoggles> | <https://gitlab.com/sgoggles>
 *
 */

package com.tomshley.brands.global.tech.tware.products.hexagonal.plugins
package projectsettings
import com.tomshley.brands.global.tech.tware.products.hexagonal.plugins.common.model.HexagonalPart
import com.tomshley.brands.global.tech.tware.products.hexagonal.plugins.common.sbt.BasicSbtSettings
import sbt.*

protected[projectsettings] trait ProjectSettingsKeys extends BasicSbtSettings {

  case class HexagonalProjectSettings[+T <: HexagonalPart](projectName: String, projectBaseOption: Option[File] = None) {
    def project: Project = {
      Project(
        id = projectName,
        base = projectBaseOption.fold(ifEmpty = file(projectName))(file => projectBaseOption.get)
      ).settings(
          ProjectSettingsDefs.javaProject,
          ProjectSettingsDefs.jsonProject,
          ProjectSettingsDefs.akkaProject,
          ProjectSettingsDefs.libProject,
          ProjectSettingsDefs.scala3CrossVersions
        )

    }
  }
}

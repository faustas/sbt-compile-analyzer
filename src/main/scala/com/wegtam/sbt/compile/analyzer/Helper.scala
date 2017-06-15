/*
 * Copyright (C) 2017  André Schütz
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.wegtam.sbt.compile.analyzer

import adt.ScalacPhase
import adt.ScalacPhaseName.Loader
import adt.ScalacPhaseValue.ScalacPhaseValueLoader

/**
  * A few helper methods for the project.
  */
object Helper {

  /**
    * An ugly simple fast possibility to visualize the information of the
    * extracted phases from the data file.
    *
    * @param r Sequence of phase information
    */
  def print(r: Seq[ScalacPhase]): Unit = {
    // Loader
    val loaderPhase = r.find(_.name == Loader)
    loaderPhase.fold(println(s"No data for ${Loader.toString}")) { loader =>
      println("============================================================")
      println(s"${Loader.toString} (ID: ${loader.id}) took ${loader.took}ms")
      println("============================================================")
      println("\nSlowest loading times:")
      loader.values
        .sortBy {
          case ScalacPhaseValueLoader(desc1, desc2, value, took) => took
          case _                                                 => -1
        }(Ordering[Long].reverse)
        .takeWhile {
          case ScalacPhaseValueLoader(desc1, desc2, value, took) => took > 10
          case _                                                 => true
        }
        .foreach {
          case ScalacPhaseValueLoader(desc1, desc2, value, took) =>
            println(s"$desc1, $desc2, $value, ${took}ms")
          case _ => ""
        }
    }

    println("\n\n============================================================")
    println("Overview of the single phases")
    println("============================================================")
    r.sortBy(_.id).drop(1).foreach { phase =>
      println(s"${phase.id} ${phase.name} took ${phase.took}ms")
    }

    println("\n\n============================================================")
    println("Overview of the single phases (ordered by time)")
    println("============================================================")
    r.sortBy(_.id).drop(1).sortBy(_.took)(Ordering[Long].reverse).foreach { phase =>
      println(s"${phase.id} ${phase.name} took ${phase.took}ms")
    }

  }

}

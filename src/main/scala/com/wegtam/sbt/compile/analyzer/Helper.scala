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

import adt.{ ScalacPhase, ScalacPhaseName }
import adt.ScalacPhaseName.{ Loader, Total }
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
  @SuppressWarnings(Array("org.wartremover.warts.Any"))
  def print(r: Seq[ScalacPhase]): Unit = {
    val phaseHeader = "ID\tTook (in ms)\tPhase"

    println("\n\n============================================================")
    println("Overview of the single phases")
    println("============================================================")
    println(phaseHeader)
    r.sortBy(_.id).drop(1).foreach { phase =>
      println(s"${phase.id}\t${phase.took}ms\t${phase.name}")
    }

    println("\n\n============================================================")
    println("Overview of the single phases (ordered by used time)")
    println("============================================================")
    println(s"$phaseHeader\tpercentage (%)")
    val sortedByTime = r.sortBy(_.id).drop(1).sortBy(_.took)(Ordering[Long].reverse)
    val totalTime: Long =
      sortedByTime.find(_.id == ScalacPhaseName.phaseId(Total).getOrElse(-1)).fold(0L)(t => t.took)
    r.sortBy(_.id).drop(1).sortBy(_.took)(Ordering[Long].reverse).foreach { phase =>
      val tookPercentage: BigDecimal =
        if (phase.took > 0)
          BigDecimal(phase.took.toDouble / totalTime.toDouble * 100)
            .setScale(2, BigDecimal.RoundingMode.HALF_UP)
        else 0
      println(s"${phase.id}\t${phase.took}ms\t${phase.name}\t$tookPercentage%")
    }

  }

  /**
    * Helper function to print the information from the loader.
    * Currently unused.
    *
    * @param r Sequence of phase information
    */
  private def printLoaderData(r: Seq[ScalacPhase]): Unit = {
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
  }

}

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

package com.wegtam.sbt.compile.analyzer.adt

/**
  * Sealed trait to collect the different values that can be connected
  * to a phase and extracted from the data.
  */
sealed trait ScalacPhaseValue

object ScalacPhaseValue {

  /**
    * General case where just a String value is available.
    *
    * @param value  Value for the phase.
    */
  case class ScalacPhaseValueGeneral(value: String) extends ScalacPhaseValue

  /**
    * Values of the loader phase.
    *
    * @param desc1  Describes the `value`.
    * @param desc2  Describes the `value`.
    * @param value  Value for the phase.
    * @param took   How long this value took in Milliseconds.
    */
  case class ScalacPhaseValueLoader(desc1: String, desc2: String, value: String, took: Long)
      extends ScalacPhaseValue

}

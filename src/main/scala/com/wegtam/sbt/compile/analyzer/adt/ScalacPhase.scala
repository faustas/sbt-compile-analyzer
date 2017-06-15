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
  * A phase contains all information that are available regarding the
  * Scalac compilation of this phase.
  *
  * @param id     The ID of the phase. Normally the order at which the phase occurs.
  * @param name   The name of the phase.
  * @param took   How long the phase took in Milliseconds.
  * @param values Additional information regarding this phase.
  */
case class ScalacPhase(
    id: Int,
    name: ScalacPhaseName,
    took: Long,
    values: Seq[ScalacPhaseValue]
)

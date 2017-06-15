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

import java.util.Locale

/**
  * Sealed trait to collect the names of the Scala compiling phases.
  */
sealed trait ScalacPhaseName

object ScalacPhaseName {
  // The phases of the Scala compiling process
  case object Loader              extends ScalacPhaseName // not official
  case object ParserPhase         extends ScalacPhaseName
  case object NamerPhase          extends ScalacPhaseName
  case object PackageObjectsPhase extends ScalacPhaseName
  case object TyperPhase          extends ScalacPhaseName
  case object PatmatPhase         extends ScalacPhaseName
  case object SuperAccessorsPhase extends ScalacPhaseName
  case object ExtMethodsPhase     extends ScalacPhaseName
  case object PicklerPhase        extends ScalacPhaseName
  case object RefChecksPhase      extends ScalacPhaseName
  case object UncurryPhase        extends ScalacPhaseName
  case object TailCallsPhase      extends ScalacPhaseName
  case object SpecializePhase     extends ScalacPhaseName
  case object ExplicitOuterPhase  extends ScalacPhaseName
  case object ErasurePhase        extends ScalacPhaseName
  case object PostErasurePhase    extends ScalacPhaseName
  case object LazyValsPhase       extends ScalacPhaseName
  case object LambdaLiftPhase     extends ScalacPhaseName
  case object ConstructorsPhase   extends ScalacPhaseName
  case object FlattenPhase        extends ScalacPhaseName
  case object MixinPhase          extends ScalacPhaseName
  case object CleanupPhase        extends ScalacPhaseName
  case object DelambdafyPhase     extends ScalacPhaseName
  case object IcodePhase          extends ScalacPhaseName
  case object JvmPhase            extends ScalacPhaseName
  case object TerminalPhase       extends ScalacPhaseName
  case object Total               extends ScalacPhaseName // not official

  /**
    * Convert the string representation of the compiler phase to the equal
    * internal object.
    *
    * @param p  String representation of the Scala compiler phase.
    * @return An option of the internal object representation.
    */
  def valueOf(p: String): Option[ScalacPhaseName] = p.toLowerCase(Locale.ROOT).trim match {
    case "loader"         => Option(Loader)
    case "parser"         => Option(ParserPhase)
    case "namer"          => Option(NamerPhase)
    case "packageobjects" => Option(PackageObjectsPhase)
    case "typer"          => Option(TyperPhase)
    case "patmat"         => Option(PatmatPhase)
    case "superaccessors" => Option(SuperAccessorsPhase)
    case "extmethods"     => Option(ExtMethodsPhase)
    case "pickler"        => Option(PicklerPhase)
    case "refchecks"      => Option(RefChecksPhase)
    case "uncurry"        => Option(UncurryPhase)
    case "tailcalls"      => Option(TailCallsPhase)
    case "specialize"     => Option(SpecializePhase)
    case "explicitouter"  => Option(ExplicitOuterPhase)
    case "erasure"        => Option(ErasurePhase)
    case "posterasure"    => Option(PostErasurePhase)
    case "lazyvals"       => Option(LazyValsPhase)
    case "lambdalift"     => Option(LambdaLiftPhase)
    case "constructors"   => Option(ConstructorsPhase)
    case "flatten"        => Option(FlattenPhase)
    case "mixin"          => Option(MixinPhase)
    case "cleanup"        => Option(CleanupPhase)
    case "delambdafy"     => Option(DelambdafyPhase)
    case "icode"          => Option(IcodePhase)
    case "jvm"            => Option(JvmPhase)
    case "terminal"       => Option(TerminalPhase)
    case "total"          => Option(Total)
    case _                => None
  }

  /**
    * Return the ID of the Scala compiler phase.
    *
    * @param p  The object representation of the Scala compiler phase.
    * @return An option to the ID (Int).
    */
  def phaseId(p: ScalacPhaseName): Option[Int] = p match {
    case Loader              => Option(0)
    case ParserPhase         => Option(1)
    case NamerPhase          => Option(2)
    case PackageObjectsPhase => Option(3)
    case TyperPhase          => Option(4)
    case PatmatPhase         => Option(5)
    case SuperAccessorsPhase => Option(6)
    case ExtMethodsPhase     => Option(7)
    case PicklerPhase        => Option(8)
    case RefChecksPhase      => Option(9)
    case UncurryPhase        => Option(10)
    case TailCallsPhase      => Option(11)
    case SpecializePhase     => Option(12)
    case ExplicitOuterPhase  => Option(13)
    case ErasurePhase        => Option(14)
    case PostErasurePhase    => Option(15)
    case LazyValsPhase       => Option(16)
    case LambdaLiftPhase     => Option(17)
    case ConstructorsPhase   => Option(18)
    case FlattenPhase        => Option(19)
    case MixinPhase          => Option(20)
    case CleanupPhase        => Option(21)
    case DelambdafyPhase     => Option(22)
    case IcodePhase          => Option(23)
    case JvmPhase            => Option(24)
    case TerminalPhase       => Option(25)
    case Total               => Option(26)
    case _                   => None
  }

}

# sbt-compile-analyzer #

Welcome to sbt-compile-analyzer!

This program allows the extraction of compiler information for the single phases of the `scalac` compilation process. Therefore, the program needs the information that is generated by the `scalac` compiler during its compilation of a software program.

The content of the data file consists of the `scalac` compiler information that can be generated in the following manner. 

Add the following `scalac` compiler option to the build.sbt of the software program that should be analyzed:
  
`scalacOptions ++= Seq("-verbose")`

Run the compilation of the project and generate the data file:
`sbt clean compile > data-file.txt`

Switch to this project and execute one of the following commands:

`
sbt
run absolute/path/to/data-file.txt
`

or

`sbt "runMain com.wegtam.sbt.compile.analyzer.Analyzer absolute/path/to/data-file.txt"`

## Example output

The following two tables represent the result of this program to itself.

<pre><code>

===========================================
Overview of the single phases
===========================================
| ID  | Phase                | Took (ms)  |
| 1   | ParserPhase          | 97         |
| 2   | NamerPhase           | 106        |
| 3   | PackageObjectsPhase  | 0          |
| 4   | TyperPhase           | 1794       |
| 5   | PatmatPhase          | 714        |
| 6   | SuperAccessorsPhase  | 58         |
| 7   | ExtMethodsPhase      | 11         |
| 8   | PicklerPhase         | 52         |
| 9   | RefChecksPhase       | 195        |
| 10  | UncurryPhase         | 137        |
| 11  | TailCallsPhase       | 43         |
| 12  | SpecializePhase      | 365        |
| 13  | ExplicitOuterPhase   | 116        |
| 14  | ErasurePhase         | 364        |
| 15  | PostErasurePhase     | 20         |
| 17  | LambdaLiftPhase      | 54         |
| 18  | ConstructorsPhase    | 43         |
| 19  | FlattenPhase         | 26         |
| 20  | MixinPhase           | 46         |
| 21  | CleanupPhase         | 17         |
| 22  | DelambdafyPhase      | 46         |
| 26  | Total                | 6024       |

====================================================
Overview of the single phases (ordered by used time)
====================================================
| ID  | Phase                | Took (ms)  | %      |
| 26  | Total                | 6024       | 100    |
| 4   | TyperPhase           | 1794       | 29,78  |
| 5   | PatmatPhase          | 714        | 11,85  |
| 12  | SpecializePhase      | 365        | 6,06   |
| 14  | ErasurePhase         | 364        | 6,04   |
| 9   | RefChecksPhase       | 195        | 3,24   |
| 10  | UncurryPhase         | 137        | 2,27   |
| 13  | ExplicitOuterPhase   | 116        | 1,93   |
| 2   | NamerPhase           | 106        | 1,76   |
| 1   | ParserPhase          | 97         | 1,61   |
| 6   | SuperAccessorsPhase  | 58         | 0,96   |
| 17  | LambdaLiftPhase      | 54         | 0,9    |
| 8   | PicklerPhase         | 52         | 0,86   |
| 20  | MixinPhase           | 46         | 0,76   |
| 22  | DelambdafyPhase      | 46         | 0,76   |
| 11  | TailCallsPhase       | 43         | 0,71   |
| 18  | ConstructorsPhase    | 43         | 0,71   |
| 19  | FlattenPhase         | 26         | 0,43   |
| 15  | PostErasurePhase     | 20         | 0,33   |
| 21  | CleanupPhase         | 17         | 0,28   |
| 7   | ExtMethodsPhase      | 11         | 0,18   |
| 3   | PackageObjectsPhase  | 0          | 0      |

</code></pre>

## Contribution policy ##

Contributions via GitHub pull requests are gladly accepted from their original author. Along with
any pull requests, please state that the contribution is your original work and that you license
the work to the project under the project's open source license. Whether or not you state this
explicitly, by submitting any copyrighted material via pull request, email, or other means you
agree to license the material under the project's open source license and warrant that you have the
legal authority to do so.

## License ##

This code is open source software licensed under the
[AGPL-3.0](https://www.gnu.org/licenses/agpl.html) license.

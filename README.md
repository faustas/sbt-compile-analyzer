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

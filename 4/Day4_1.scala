import scala.io._
import java.io.FileInputStream
import java.io.File

object Day4_1 {
    def splitPassport(passport: String) : Int = {
        val fields = Set("byr", "iyr", "eyr", "hgt",
             "hcl", "ecl", "pid")
        val allFieldsPresent = fields.forall(passport.contains(_))
        if (allFieldsPresent) return 1 else return 0
    }

    def lineParser(x: String) = {
        val passports = x.split("\n\n")
        var numValid = 0
        passports.foreach(
            passport => numValid += splitPassport(passport)
        )
        println(numValid)
    }

    def main(args: Array[String]) {
        val filename = "input"
        val readFile = Source.fromFile(filename)
            .getLines()
            .mkString("\n")
        lineParser(readFile)
    }
}

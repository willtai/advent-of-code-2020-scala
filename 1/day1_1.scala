import scala.io._

object Day1 {
    // def multiplyEntries(report: Array[Int]) : Int = {
    //     var leftovers = report.map(x => 2020 - x)
    //     var intersection = List(report, leftovers).reduce((a, b) => a intersect b)
    //     println(intersection)
    // }

    def main(args: Array[String]) {
        var target: Int = 2020
        var finalNumber: Int = 1
        val filename = "input"
        val numbers = Source.fromFile(filename).
            getLines.
            toArray
        val numbersInt = numbers.map(_.toInt)
        val targets = numbersInt.map(target - _)
        val numbers_required = List(numbersInt, targets).
            reduce((a, b) => a intersect b)
        numbers_required.foreach(finalNumber *= _)

        println(finalNumber)
    }
}

import scala.io._

object Day1_1 {
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

import scala.io._

object Day1_2 {
    def main(args: Array[String]) {
        var target: Int = 2020
        val filename = "input"
        val numbers = Source.fromFile(filename).
            getLines.
            toArray
        val numbersInt = numbers.map(_.toInt)
        
        for {
            i <- numbersInt
            j <- numbersInt
            k <- numbersInt
        } {
            if (i + j + k == target) {
                println(i * j * k)
            }
        }
    }
}

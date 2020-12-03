import scala.io._
import java.io.FileInputStream
import java.io.File

object Day2_2 {
    def lineParser(x: String) : Int = {
        val firstNumber = x.split("-")(0)
        val restOfLine1 = x.drop(firstNumber.length + 1)
        val secondNumber = restOfLine1.split(" ")(0)
        val restOfLine2 = x.drop(firstNumber.length
            + secondNumber.length
            + 2)
        val letter = restOfLine2.split(":")(0)
        val sequence = restOfLine2.split(":")(1).drop(1)
        val count = sequence.count(_.toString == letter)
        
        if(count >= firstNumber.toInt && count <= secondNumber.toInt) {
            return 1
        }
        else {
            return 0
        }
    }

    def main(args: Array[String]) {
        val filename = "input_sample"
        var numberCorrect = 0
        val infile = new File(filename)
        val reader = new BufferedSource(new FileInputStream(infile))
            reader
            .getLines
            .foreach(numberCorrect += lineParser(_))

        println(numberCorrect.toString)
        }
}

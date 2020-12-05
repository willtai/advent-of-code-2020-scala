import scala.io._
import java.io.FileInputStream
import java.io.File

object Day3_1 {
    def lineParser(x: Seq[String]) : String = {
        var hor = 0
        var ver = 0
        var treeCount = 0

        while(ver < x.length) {
            val tree = x(ver)(hor)
            if(tree == '.') {
                treeCount += 0
            }
            else if(tree == '#'){
                treeCount += 1
            }
            hor = (hor + 3) % x(ver).length
            ver += 1
        }
        return treeCount.toString
    }

    def readFile(filename: String): Seq[String] = {
        val bufferedSource = Source.fromFile(filename)
        val lines = (for (line <- bufferedSource.getLines()) yield line).toList
        bufferedSource.close
        lines
    }

    def main(args: Array[String]) {
        val filename = "input"
        var numberCorrect = 0
        val infile = new File(filename)
        val rows = readFile(filename)
        println(lineParser(rows))
        }
}

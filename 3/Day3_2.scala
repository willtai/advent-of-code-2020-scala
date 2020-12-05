import scala.io._
import java.io.FileInputStream
import java.io.File

object Day3_2 {
    def lineParser(x: Seq[String], rules: Tuple2[Int, Int]) : Long = {
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
            hor = (hor + rules._1) % x(ver).length
            ver += rules._2
        }
        return treeCount
    }

    def readFile(filename: String): Seq[String] = {
        val bufferedSource = Source.fromFile(filename)
        val lines = (for (line <- bufferedSource.getLines()) yield line).toList
        bufferedSource.close
        lines
    }

    def main(args: Array[String]) {
        val filename = "input"
        var trees_mult = 1L
        val infile = new File(filename)
        val rows = readFile(filename)
        val rules = List((1, 1), (3, 1), (5, 1), (7, 1), (1, 2))
        rules.foreach(rule => trees_mult = trees_mult * lineParser(rows, rule))
        println(trees_mult)
    }
}

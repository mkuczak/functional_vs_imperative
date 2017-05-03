package cs372.p1
import scala.io.Source

trait BackEnd {
  def produceLine(number: Int, count: Int, stats: List[(Option[Int], Option[Double], Option[Int])]): Unit
}

trait GenerateStats {
  def toQueue(numbers: Iterator[Int], wins: Array[Int]): Unit
}

trait Main extends GenerateStats {

  //The args are the window sizes given via terminal command.  We have to convert them to a usable form (integers)
  def main(args: Array[String]): Unit = {
    val wins = args.map(_.toInt)
    //Here are the user-inputted numbers.  We have to turn them into integers as well so that we can do math with them.
    val incoming = Source.stdin.getLines
    val words = incoming.flatMap(_.split("\\W+"))
    val numbers = words.map(_.toInt)
    //toQueue takes the numbers and windows and creates a list that contains the information that we want
    toQueue(numbers, wins)
  }

  //produceLine takes the stats, converts them into a printable form, and prints them.
  def produceLine(number: Int, count: Int, stats: List[(Option[Int], Option[Double], Option[Int])]): Unit = {
    var line: String = ""
    line = number.toString + " " + count.toString
    for (i <- 0 to stats.length - 1) {
      if(stats(i)._1==None) {
        line = line + " ? ? ?"
      } else {
        line = line + " " + stats(i)._1.toString.replaceAll("[^0-9.]", "") +
          " " + stats(i)._2.toString.replaceAll("[^0-9.]", "") +
          " " + stats(i)._3.toString.replaceAll("[^0-9.]", "")
      }
    }
    println(line)
  }
}
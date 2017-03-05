package cs372.p1

//import cs372.p1.Imperative ?????
import scala.io.Source

/**
  * Created by Matthew on 2/10/17.
  */

trait BackEnd {
  def produceLine(number: Int, count: Int, stats: List[Any]): Unit
}

trait GenerateStats {
  def toQueue(numbers: Iterator[Int], wins: Array[Int]): Unit
}

// TODO define suitable tuple type or case class for stats
//case class Stats(item: Int, count: Int ...)
case class Stats(item: Int, count: Int, min: Option[Int], mean: Option[Double], max: Option[Int])
//I'M NOT TOO SURE HOW TO IMPLEMENT THIS

// TODO testing version of produceLine
// DONE DONE DONE DONE DONE DONE DONE DONE


trait Main extends GenerateStats {

  def main(args: Array[String]): Unit = {
    val wins = args.map(_.toInt)
    //val maxWin: Int = wins.reduceLeft(_ max _)
    //var numWin: Int = wins.length
    //Gathers information about the arguments passed in and puts them into a usable form called "wins"

    val incoming = Source.stdin.getLines
    val words = incoming.flatMap(_.split("\\W+"))
    val numbers = words.map(_.toInt)
    //Converts the standard input into a usable form called "numbers"

    toQueue(numbers, wins)
  }

  //  val fun = new Functional()
  //  fun.toQueue(numbers, wins)

  // Press CTRL+D to leave this for loop and continue...

  def produceLine(number: Int, count: Int, stats: List[Any]): Unit = {
    var line: String = ""
    line = number.toString + " " + count.toString
    for (i <- 0 to stats.length - 1) {
      line = line + " " + stats(i).toString
    }
    println(line)
  }
}
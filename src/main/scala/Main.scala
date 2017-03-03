package cs372.p1

//import cs372.p1.Imperative ?????
import scala.io.Source

/**
  * Created by Matthew on 2/10/17.
  */

object main extends App {


  val wins = args.map(_.toInt)
  //val maxWin: Int = wins.reduceLeft(_ max _)
  //var numWin: Int = wins.length
  //Gathers information about the arguments passed in and puts them into a usable form called "wins"

  val incoming = Source.stdin.getLines
  val words = incoming.flatMap(_.split("\\W+"))
  val numbers = words.map(_.toInt)
  //Converts the standard input into a usable form called "numbers"

  val imp = new Imperative()
  imp.toQueue(numbers, wins)

//  val fun = new Functional()
//  fun.toQueue(numbers, wins)


  // Press CTRL+D to leave this for loop and continue...
}
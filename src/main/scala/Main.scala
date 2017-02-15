package cs372.p1

//import cs372.p1.Imperative ?????
import scala.io.Source

/**
  * Created by Matthew on 2/10/17.
  */

object main extends App {
  val imp = new Imperative()
  var arg_amount: Int = 0
  args.foreach(arg => println(arg))
   for (line <- Source.stdin.getLines) {
     imp.toQueue(line, args)
     for (arg <- args) {
       imp.getStats(arg.toInt, arg_amount)
       arg_amount = arg_amount + 1
       imp.produceLine() //Naw.  This shouldn't be in a loop.  Instead, I should pass in the array of args.
     }
   }
  // Press CTRL+D to leave this for loop and continue...
}
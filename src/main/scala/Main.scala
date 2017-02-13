package cs372.p1

import cs372.p1.Imperative
import scala.io.Source

/**
  * Created by Matthew on 2/10/17.
  */
object main extends App {
  val imp = new Imperative()
  var arg_amount: Int = 0
  if (Source.stdin.length > 0) {
    for (line <- Source.stdin.getLines) {
      imp.toQueue(line, args)
      for (arg <- args) {
        imp.getStats(arg, arg_amount)
        arg_amount = arg_amount + 1
        imp.produceLine()
      }
    }
  } else {
    Console.err.println("Please enter filename")
  }
  print(args)
}
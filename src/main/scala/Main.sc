package cs372.p1

import cs372.p1.Imperative
import scala.io.Source

/**
  * Created by Matthew on 2/10/17.
  */
class Main extends App {
  val imp = new Imperative()
  if (Source.stdin.length > 0) {
    for (line <- Source.stdin.getLines) {
      imp.toQueue(line, args)
    }
  } else {
    Console.err.println("Please enter filename")
  }
  print(args)
}
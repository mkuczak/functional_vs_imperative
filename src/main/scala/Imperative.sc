package cs372.p1
/**
  * Created by Matthew on 2/7/17.
  */
import scala.collection._

class Imperative {
  var largest_window: Int = 0
  var num: Int = 0
  var count: Int = 0
  var stats: Array[String]

  var queue = new mutable.Queue[Int]()
  //Option Int: Can be set to Some(n), or None.
  //I don't think that I need that type anymore

  def toQueue(line: String, args: Array[String]): Unit = {
    //I am assuming that args is a list of strings.  I need to verify that this is the case
    if (queue.length == args.max) {
      queue.dequeue
    }
    line.toInt+=:queue

    count = count + 1
    num = line.toInt
    //print(queue)
  }

  def getStats (winSize: Int) : Unit = {
    //I'll need a for loop in main that runs this function multiple times with all window sizes
    //POSSIBLE PROBLEM: IF the user inputs 0, this probable doesn't work.  Can I assume intelligent user?
    var total: Int = 0
    var min: Int = queue(0)
    var max: Int = queue(0)
    var mean: Int = 0
    val stats = new Array[String](winSize)

    /*Checks to see whether the queue hasn't reached the window size.
    If it hasn't, the stats just become "?" */
    if (queue.size >= winSize) {
      for (i <- 0 to winSize - 1) {
        total = total + queue(i)
        if (queue(i) > max) {
          max = queue(i)
        } else if (queue(i) < min) {
          min = queue(i)
        }
      }
      mean = total/winSize
      stats(0) = min.toString
      stats(1) = mean.toString()
      stats(2) = max.toString()
    } else {
      stats(0) = "?"
      stats(1) = "?"
      stats(2) = "?"
    }
  }

  def produceLine (): Unit = {
    print(num.toString + " " + count.toString + " " + stats(0) + " " + stats(1) + " " + stats(2))
  }

}
package cs372.p1
/**
  * Created by Matthew on 2/7/17.
  */
import scala.collection._

class Imperative {
  var largest_window: Int = 0
  var num: Int = 0
  var count: Int = 0
  var stats: List[String] = List()

  var queue = new mutable.Queue[Int]()
  //Option Int: Can be set to Some(n), or None.
  //I don't think that I need that type anymore

  def toQueue(line: String, args: Array[String]): Unit = {
    var args_int = new Array[Int](args.length)
    for (i <- 0 to args.length-1) {
      args_int(i) = args(i).toInt
    }
    if (queue.length == args_int.max) {
      queue.dequeue
    }
    line.toInt+=:queue

    count = count + 1
    num = line.toInt
    //print(queue)
  }

  def getStats (winSize: Int, len_stat: Int) : Unit = {
    //I'll need a for loop in main that runs this function multiple times with all window sizes
    //POSSIBLE PROBLEM: IF the user inputs 0, this probable doesn't work.  Can I assume intelligent user?
    var total: Int = 0
    var min: Int = queue(0)
    var max: Int = queue(0)
    var mean: Double = 0
    //val stats = new Array[String](winSize)

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
      mean = (total.toDouble)/(winSize.toDouble)
      stats = stats:+(min.toString())
      stats = stats:+(mean.toString())
      stats = stats:+(max.toString())
    } else {
      stats = stats:+"?"
      stats = stats:+"?"
      stats = stats:+"?"
    }
  }

  def produceLine (): Unit = {
    print(num.toString + " " + count.toString)
    for (stat <- stats) {
      print(" " + stat)
    }
    println("")
    stats = List()
  }
//This prints the number and count twice. Oops.  Fix please.
}
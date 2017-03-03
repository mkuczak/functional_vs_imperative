//package cs372.p1
///**
//  * Created by Matthew on 2/7/17.
//  */
//import scala.collection._
//
//class Functional {
//
//  def toQueue(numbers: Iterator[Int], wins: Array[Int]): Unit = {
//    val (results, count) = numbers.foldLeft {
//      (List.empty[Int], 1)
//    } { case ((window, count), next) =>
//      val window1 = next +: window.take(wins.max - 1)
//      print(produceLine(next, count, getStats(window1,wins)))
//      (window1, count + 1)
//    }
//  }
//
//  def getStats(window: List[Int], wins: Array[Int]): List[Any] = {
//    val stats = wins.foldleft {
//      (List.empty[Any])
//    } { (prep, next) =>
//      if(wins.max > window.length){
//        val prep1 = prep :+ "?"
//        val prep2 = prep1 :+ "?"
//        val prep3 = prep2 :+ "?"
//        (prep3)
//      } else {
//        val prep1 = prep :+ (window.take(next)).min
//        val prep2 = prep1 :+ ((window.take(next).sum)) / (next)
//        val prep3 = prep2 :+ (window.take(next)).max
//        (prep3)
//      }
//    }
//    stats
//  }
//
//  def produceLine(number: Int, count: Int, stats: List[Any]): String = {
//    var line: String = ""
//    line = number.toString + " " + count.toString
//    for (i <- 0 to stats.length - 1) {
//      line = line + " " + stats(i).toString
//    }
//    line
//  }
//}
package cs372.p1
import scala.collection._

object FunctionalMain extends Main with Functional

trait Functional extends GenerateStats with BackEnd {

  override def toQueue(numbers: Iterator[Int], wins: Array[Int]): Unit = {
    val (results, count) = numbers.foldLeft {
      (List.empty[Int], 1)
    } { case ((window, count), next) =>
      val window1 = next +: window.take(wins.max - 1)
      produceLine(next, count, getStats(window1,wins))
      (window1, count + 1)
    }
  }

  def getStats(window: List[Int], wins: Array[Int]): List[(Option[Int], Option[Double], Option[Int])] = {
    val stats = wins.foldLeft {
      (List.empty[(Option[Int], Option[Double], Option[Int])])
    } { (prep, next) =>
      if(wins.max > window.length){
        val prep1 = prep :+ (None, None, None)
        (prep1)
      } else {
        val prep1 = prep :+ (Some((window.take(next)).min),
          Some(((window.take(next).sum.toDouble)) / (next.toDouble)),
          Some((window.take(next)).max))
        (prep1)
      }
    }
    stats
  }
}
package cs372.p1
import scala.collection._

object ImperativeMain extends Main with Imperative

trait Imperative extends GenerateStats with BackEnd {

  //Maintains the numbers that fit within the largest window size and throws them to the getStats and produceLine functions
  override def toQueue(numbers: Iterator[Int], wins: Array[Int]): Unit = {
    //window contains the values that exist within the largest window
    var window: List[Int] = List()
    var maxWin = wins.max
    var count: Int = 0
    for(num<-numbers) {
      count = count + 1
      window = num +: window.take(maxWin - 1)
      produceLine(num, count, getStats(window,wins))
    }
  }

  //getStats returns a list of min, mean, max tuples.
  def getStats (window: List[Int], wins: Array[Int]): List[(Option[Int], Option[Double], Option[Int])] = {
    var stats: List[(Option[Int], Option[Double], Option[Int])] = List()
    for(win<-wins){
      if(win<=window.size) {
        stats = stats :+ (Some((window.take(win)).min),
          Some((((window.take(win)).sum).toDouble)/((win).toDouble)),
          Some((window.take(win)).max))
      } else {
        stats = stats:+(None, None, None)
      }
    }
    stats
  }
}
package cs372.p1
/**
  * Created by Matthew on 2/7/17.
  */
import scala.collection._

object ImperativeMain extends Main with Imperative

trait Imperative extends GenerateStats with BackEnd {

  var largest_window: Int = 0
  var num: Int = 0
  var count: Int = 0
  var stats: List[String] = List()

  var queue = new mutable.Queue[Int]()
  //Option Int: Can be set to Some(n), or None.
  //I don't think that I need that type anymore

  override def toQueue(numbers: Iterator[Int], wins: Array[Int]): Unit = {
    var window: List[Int] = List()
    var maxWin = wins.max

    var count: Int = 0

    for(num<-numbers) {
      count = count + 1
      window = num +: window.take(maxWin - 1)
      produceLine(num, count, getStats(window,wins))
    }
  }

  def getStats (window: List[Int], wins: Array[Int]): List[Any] = {
    var stats: List[Any] = List()
    for(win<-wins){
      if(win<=window.size) {
        stats = stats :+ (window.take(win)).min
        stats = stats :+ (((window.take(win)).sum).toDouble)/((win).toDouble)
        stats = stats :+ (window.take(win)).max
      } else {
        stats = stats:+"?"
        stats = stats:+"?"
        stats = stats:+"?"
      }
    }
    stats
  }
}
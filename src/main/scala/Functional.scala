package cs372.p1
/**
  * Created by Matthew on 2/7/17.
  */
import scala.collection._

class Functional {

  val win: Int = 10 //Replace this with a real way to check the maximum sized window


  def toQueue(numbers: Iterator[Int], wins: Array[String]): List[Int] = {
    val (results, count) = numbers.foldLeft {
      (List.empty[Int], 0)
    } { case ((window, count), next) =>
      val window1 = next +: window.take(win - 1)
      getStats()
      produceLine()
//      if (win < window.length) {
//        print(next + " " + (count + 1).toString + " ? ? ?")
//      } else {
//        println(next + " " + (count + 1).toString + " " + window1.min + " " + (window1.sum) / (window1.length) + " " + window1.max)
//      }
      (window1, count + 1)
    }

  }

  def getStats(wins: List[Int]): List[Any] = {
    
  }
}
//produceLine
//getStats
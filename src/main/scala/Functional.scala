package cs372.p1
/**
  * Created by Matthew on 2/7/17.
  */
import scala.collection._

class Functional {

  val win: Int = 10 //Replace this with a real way to check the maximum sized window


  def toQueue(numbers: Iterator[Int], wins: Array[Int]): Unit/*List[Int]*/ = {
    val (results, count) = numbers.foldLeft {
      (List.empty[Int], 0)
    } { case ((window, count), next) =>
      val window1 = next +: window.take(win - 1)
      //produceLine(getStats())

      if (win < window.length) {
        print(next + " " + (count + 1).toString + " ? ? ?")
      } else {
        println(next + " " + (count + 1).toString + " " + window1.min + " " + (window1.sum) / (window1.length) + " " + window1.max)
      }
      (window1, count + 1)
    }

  }

  def getStats(window: List[Int], wins: Array[Int]): List[Int] = {
    val printThis = wins.foldleft {
      (List.empty[Any])
    } { (prepThis, next) =>
      val prepThis1 = (window.take(next)).min :+ prepThis
      val prepThis2 = ((window.take(next).sum)) / (next) :+ prepThis1
      val prepThis3 = (window.take(next)).max :+ prepThis2
        (prepThis3)
    }
    printThis
  }

  def produceLine(printThis: List[Any]): Unit = {

  }
}
//produceLine
//getStats
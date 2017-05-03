package cs372.p1
package common
import org.scalatest.WordSpec

abstract class ProduceLineSpec extends WordSpec with GenerateStats {

  var myList: List[Any] = new List()
  val simpleInput = Iterator(1, 1, 1, 1)
  val simpleWindowSize = Array(1)
  val largeWindowSize = Array(10)

  "The program" when {
    "given a simple integer input and window size" should {
      "return a numerical list" in {
        myList.clear()
        toQueue(simpleInput, simpleWindowSizes)
        (1, 1, 1, 1.0, 1,
          1, 2, 1, 1.0, 1,
          1, 3, 1, 1.0, 1,
          1, 4, 1, 1.0, 1)
      }
    }
    "given less input integers than the window size" should {
      "return a list with ? instead of stats" in {
        myList.clear()
        toQueue(simpleInput, largeWindowSize)
        (1, 1, "?", "?", "?",
          1, 2, "?", "?", "?",
          1, 3, "?", "?", "?",
          1, 4, "?", "?", "?")
      }
    }
  }

  //Not going for elegance here since it just a testing function.
  def produceLine(number: Int, count: Int, stats: List[(Option[Int], Option[Double], Option[Int])]): List[Any] = {
    myList = myList :+ number.toString
    myList = myList :+ count.toString

    for (i <- 0 to stats.length - 1) {
      if (stats(i)._1 == None) {
        myList = myList :+ "?"
        myList = myList :+ "?"
        myList = myList :+ "?"
      } else {
        myList = myList :+ stats(i)._1.toString.replaceAll("[^0-9.]", "")
        myList = myList :+ stats(i)._2.toString.replaceAll("[^0-9.]", "")
        myList = myList :+ stats(i)._3.toString.replaceAll("[^0-9.]", "")
      }
      myList
    }
  }
}
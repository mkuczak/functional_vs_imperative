package cs372.p1
package common

import org.scalatest.WordSpec

// TODO class FunctionalSpec extends ProduceLineSpec ...


/* Tests for the `produceLine` method. */
abstract class ProduceLineSpec extends WordSpec with GenerateStats {

  // TODO define mutable list for testing version of produceLine
  var myList: List = new List()

  // TODO define fixtures e.g. Iterator(1, 1, 1, 1, 1)
  val simpleInput = Iterator(1, 1, 1, 1, 1)
  val simpleWindowSizes = Array(1)
  val largeWindowSize = Array(10)

  // my ideas: Multiple window sizes that all fill out
  // multiple that don't
  // some do and some don't


  "The program" when {
    "given a simple integer input and window size" should {
      "return a numerical list" in {
        myList.clear()
        toQueue(simpleInput, simpleWindowSizes)
        (1, 1, 1, 1.0, 1,
          1, 2, 1, 1.0, 1,
          1, 3, 1, 1.0, 1,
          1, 4, 1, 1.0, 1,
          1, 5, 1, 1.0, 1)
      }
    }
    "given less input integers than the window size" should {
      "return a list with ? instead of stats" in {
        myList.clear()
        toQueue(simpleInput, largeWindowSize)
        (1, 1, "?", "?", "?",
          1, 2, "?", "?", "?",
          1, 3, "?", "?", "?",
          1, 4, "?", "?", "?",
          1, 5, "?", "?", "?")
      }
    }
  }

  def produceLine(number: Int, count: Int, stats: List[Any]): List[Any] = {
    // TODO append stats to the mutable list
    myList = myList :+ number
    myList = myList :+ count
    for (stat <- stats) {
      myList = myList :+ stat
    }
    myList
  }
}
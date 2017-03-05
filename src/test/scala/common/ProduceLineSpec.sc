package cs372.p1
package common

import org.scalatest.WordSpec

// TODO class FunctionalSpec extends ProduceLineSpec ...

/** Tests for the `produceLine` method. */
abstract class ProduceLineSpec extends WordSpec with GenerateStats {

  // TODO define mutable list for testing version of produceLine

  // TODO define fixtures e.g. Iterator(1, 1, 1, 1, 1)

  val simpleInput = Iterator(1, 1, 1, 1, 1)

  val simpleWindowSizes = Array(1)

  "produceLine" when {
    "given a number, count, and a numerical stats list" should {
      "return a string" in {
        myList.clear()
        toQueue(simpleInput, simpleWindowSizes)
        assert(myList == (1, 2, List(1, 2, 3)))
      }
    }
    "given a number, count, and a ? stats list" should {
      "return a string" in {
        assert(produceLine("4 5 ? ? ?") == (4, 5, List("?", "?", "?")))
      }
    }
  }

  def produceLine(number: Int, count: Int, stats: List[Any]): List[String] = {
    // TODO append stats to the mutable list
    var line: List = new List()
    for (stat <- stats) {
      line = line :+ stat.toString
    }
    line
  }
}
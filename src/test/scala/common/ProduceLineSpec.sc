package cs372.p1
package common

import org.scalatest.WordSpec

/** Tests for the `produceLine` method. */
class ProduceLineSpec extends WordSpec with IO {

  "produceLine" when {
    "given a number, count, and a numerical stats list" should {
      "return a string" in {
         assert(produceLine("1 2 1 2 3") == (1, 2, List(1, 2, 3)))
      }
    }
    "given a number, count, and a ? stats list" should {
      "return a string" in {
        assert(produceLine("4 5 ? ? ?") == (4, 5, List("?", "?", "?")))
      }
    }
  }
}
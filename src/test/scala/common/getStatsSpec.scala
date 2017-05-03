package cs372.p1
package common
import org.scalatest.WordSpec

class GetStatsSpec extends WordSpec with IO {

  "getStats" when {
    "given a window of ints with a length no larger than the values in a given array of window sizes" should {
      "return a list of numbers" in {
        assert(getStats(List(1, 2, 3, 4), Array(1, 4)) == List(1, 1.0, 1, 1, 2.5, 4))
      }
    }
    "given window of ints with a length less than every value in a given array of window sizes" should {
      "return a list '?' characters" in {
        assert(getStats(List(5, 6), Array(3, 10)) == List("?", "?", "?", "?", "?", "?", "?", "?"))
      }
    }
    "given window of ints with a length less than some values in a given array of window sizes" should {
      "return a list of numbers and '?' characters" in {
        assert(getStats(List(10, 20, 30, 40, 50), Array(1, 4, 10)) == List(10, 10.0, 10, 10, 25.0, 40, "?", "?", "?"))
      }
    }
  }
}
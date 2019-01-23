import java.awt.datatransfer.{DataFlavor, SystemFlavorMap}
import java.util.TimeZone

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.util.{Random, Sorting}

object Chap3Exo_corr {

  /**
   * Task 1:
   *   Write a code snippet that sets a to an array of n random integers
   *   between 0 (inclusive) and n (exclusive)
   */
  def randomIntArray(n: Int): Array[Int] = {
    val a = new Array[Int](n)
    for (i <- a.indices) {
      a(i) = Random.nextInt(n)
    }

    a
  }

  /**
   * Task 2:
   *   Write a loop that swaps adjacent elements of an array of integers.
   *   For example, Array(1, 2, 3, 4, 5) becomes Array(2, 1, 4, 3, 5)
   */
  def swapAdjacent(a: Array[Int]): Array[Int] = {
    for (i <- 1 until a.length if (i % 2) != 0) {
      val tmp = a(i - 1)
      a(i - 1) = a(i)
      a(i) = tmp
    }

    a
  }

  /**
   * Task 3:
   *   Repeat the preceding assignment, but produce a new array
   *   with the swapped values. Use for/yield
   */
  def swapAdjacentYield(a: Array[Int]) = {
    for (i <- a.indices) yield a(
      if ((i % 2) == 0)
        if (i + 1 == a.length) i
        else i + 1
      else i - 1
    )
  }

  /**
   * Task 4:
   *   Given an array of integers, produce a new array that contains
   *   all positive values of the original array, in their original order,
   *   followed by all values that are zero or negative,
   *   in their original order
   */
  def positivesThenNegatives(a: Array[Int]): Array[Int] = {
    val length = a.length
    val b = new Array[Int](length)
    var index = 0
    for (i <- 0 until length if a(i) > 0) {
      b(index) = a(i)
      index += 1
    }

    if (index < length) {
      for (i <- 0 until length if a(i) <= 0) {
        b(index) = a(i)
        index += 1
      }
    }

    b
  }

  /**
   * Task 5:
   *   How do you compute the average of an Array[Double] ?
   */
  def computeAverage(a: Array[Double]): Double = {
    a.sum / a.length
  }

  /**
   * Reverses the given array in place.
   *
   * <p>Got from here:
   * <br>http://javarevisited.blogspot.de/2015/03/how-to-reverse-array-in-place-in-java.html
   */
  private def reverse[T](a: Array[T]): Array[T] = {
    for (i <- 0 until a.length / 2) {
      // swap elements
      val temp = a(i)
      val j = a.length - 1 - i
      a(i) = a(j)
      a(j) = temp
    }

    a
  }

  /**
   * Task 6a:
   *   How do you rearrange the elements of an Array[Int]
   *   so that they appear in reverse sorted order?
   */
  def reverseSortArray(a: Array[Int]): Array[Int] = {
    Sorting.quickSort(a)
    reverse(a)
  }

  /**
   * Task 6b:
   *   How do you rearrange the elements of an ArrayBuffer[Int]
   *   so that they appear in reverse sorted order?
   */
  def reverseSortArrayBuffer(buf: ArrayBuffer[Int]): ArrayBuffer[Int] = {
    val arr: Array[Int] = reverseSortArray(buf.toArray)
    buf.clear()
    arr.copyToBuffer(buf)
    buf
  }

  /**
   * Task 7:
   *   Write a code snippet that produces all values from an array with duplicates removed.
   *   (Hint: Look at Scaladoc.)
   */
  def removeDuplicates(a: Array[Int]): Array[Int] = a.distinct

  /**
   * Task 8:
   *   Rewrite the example at the end of Section 3.4, "Transforming Arrays", on page 34
   *   using the drop method for dropping the index of the first match.
   *   Look the method up in Scaladoc.
   */
  def dropNegativesExceptFirst(a: ArrayBuffer[Int]): ArrayBuffer[Int] = {
    val allNegativeIndexes = for (i <- a.indices if a(i) < 0) yield i
    val indexes = allNegativeIndexes.drop(1)

    for (j <- indexes.indices.reverse) a.remove(indexes(j))
    a
  }

  /**
   * Task 9:
   *   Make a collection of all time zones returned by java.util.TimeZone.getAvailableIDs
   *   that are in America. Strip off the "America/" prefix and sort the result.
   */
  def americaTimeZones: Array[String] = {
    TimeZone.getAvailableIDs.filter(_.startsWith("America/"))
      .map(_.stripPrefix("America/"))
      .sorted
  }

  /**
   * Task 10:
   *   Import java.awt.datatransfer._ and make an object of type SystemFlavorMap with the call
   *
   *   val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
   *
   *   Then call the getNativesForFlavor method with parameter DataFlavor.imageFlavor
   *   and get the return value as a Scala buffer. (Why this obscure class? It’s hard
   *   to find uses of java.util.List in the standard Java library.)
   */
  def javaListAsScalaBuffer: mutable.Buffer[String] = {
    import scala.collection.JavaConversions.asScalaBuffer

    SystemFlavorMap.getDefaultFlavorMap.asInstanceOf[SystemFlavorMap]
      .getNativesForFlavor(DataFlavor.imageFlavor)
  }
}
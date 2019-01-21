import scala.math._
import scala.util._

object Chap1Exo{
    def main(args: Array[String]){
        var y: BigInt = (BigInt(2)).pow(1024)
        println(y+"\n")
        var x: String = Random.alphanumeric.take(20).mkString.toLowerCase
        println(x+"\n")
        println(x(0)+"\n")
        println(x(x.length-1)+"\n")
        println(x.take(4)+"\n")
        println(x.drop(4)+"\n")
        println(x.takeRight(4)+"\n")
        println(x.dropRight(4)+"\n")
    }
}
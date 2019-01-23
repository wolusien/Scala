import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.util.{Random, Sorting}
import java.util._
import java.awt.datatransfer._

object Chap3Exo{

    def rand_tab(n:Int):Array[Int]={
        val a = new Array[Int](n)
        for(i<-a.indices) {
            a(i) = Random.nextInt(n)
        }
        a
    }

    def main(args: Array[String]){
        val tab = ArrayBuffer[Int]()
        tab += (0,1,2,3,4,5)
        tab ++= ArrayBuffer(6,7,8,9)
        for(i<-tab.indices) print(i+" ")
        println("\n")
        for(i<-tab.indices.reverse) print(i+" ")
        val a = Array(2, 3, 5, 7, 11)
        val result = for (elem <- a) yield 2 * elem // result is Array(4, 6, 10, 14, 22)
        for(i <- result) print(i+" ")
        println()
        println()
        val b = rand_tab(12)
        for(i<-b.indices) print(i+"b ")
        println("\n")
        val c = Array(1, 2, 3, 4, 5)
        for(i<-1 until c.length if(i%2!=0)){
            val tmp = c(i)
            c(i) = c(i-1)
            c(i-1) = tmp
        }
        for(i<-c) print(i+"c ")
        println("\n")
        val d = ArrayBuffer(1,2,3,4,5)
        val e = for (i <- d.indices) yield d{
            if ((i % 2) == 0)
                if (i + 1 == d.length) i
                else i + 1
            else i - 1
        }
        for(i<-e) print(i+"e ")
        println("\n")
        val f = ArrayBuffer(-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6)
        val g = f.filter(_>0)
        println(g.getClass)
        g++=(f.filter(_<=0))
        for(i<-g) print(i+"g ")
        println("\n")
        val h:Array[Double] = Array(-6,-5,-4,-3,-2,0,0,1,2,3)
        for(i<-h) print(i)
        print("\nmoyenne du tablea "+h.sum/h.length)
        println("\n")
        val k:Array[Int] = Array(0,7,3,9,5,8,10)
        for(i<-k.sorted.reverse) print(i+"k ")
        val m:ArrayBuffer[Int] = ArrayBuffer(0,7,3,9,5,8,10)
        println("\n")
        for(i<-m.sorted.reverse) print(i+"m ")
        println("\n")
        var o:ArrayBuffer[Int] = ArrayBuffer(1,1,2,2,3,4,5,5,6)
        o = o.distinct
        for(i<-o) print(i+"o ")
        println("\n")
        var p:ArrayBuffer[Int] = ArrayBuffer(-6,9,8,-4,0,-2,-8,6,8) 
        val allNegativeIndexes = for (i <- p.indices if p(i) < 0) yield i
        val indexes = allNegativeIndexes.drop(1)
        for (j <- indexes.indices.reverse) p.remove(indexes(j))
        for(i<-p) print(i+"tab ")
        println("\n")
        val q = TimeZone.getAvailableIDs().filter(_.startsWith("America")).map(_.stripPrefix("America/"))
        for(i<-q) print(i+"; ")
        println("\n")
        val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
        val r = flavors.getNativesForFlavor(DataFlavor.imageFlavor)
        print(r+"\n")
        print(r.getClass)
    }
}
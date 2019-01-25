import scala.collection.JavaConverters._
import scala.collection.mutable
import scala.collection.immutable
import java.util.Scanner
import scala.io.Source
import java.util.TreeMap

object Chap4Exo{

    def main(args: Array[String]){
        /*Exercice 1*/
        val m = immutable.Map("PS5"->800, "PS4"->400, "PS3"->200, "PS2"->100)
        val n = m mapValues(_ * 0.90)
        for((k,v) <- n) print(k+" "+v+"\n")

        /*Exercie 2*/
        /*
        val in = new Scanner(System.in);
        print("Nom du fichier à compter les mots : ")
        val file = in.nextLine()
        val buffer = Source.fromFile(file) 
        val lines = buffer.mkString
        buffer.close()
        val words = (lines.split(" "))
        var dic = mutable.Map[String,Int]()
        for(i <- words.distinct) dic(i) = words.count(_==i)
        for(i <- dic) print(i+"\n")
        */

        /*Exercice 3*/
        /*
        val dic = (for(i <- words.distinct) yield (i -> words.count(_==i))).toMap
        for(i <- dic) print(i+"\n")
        print(dic.getClass)
        */

        /*Exercice 4*/
        /*
        var dic = mutable.SortedMap[String,Int]()
        for(i <- words.distinct) dic(i) = words.count(_==i)
        for(i <- dic) print(i+"\n")
        */

        /*Exercice 5*/
        /*
        var dic = new TreeMap[String, Integer]()
        for(i <- words.distinct) dic.put(i,words.count(_==i))
        val keys = asScalaSet(dic.keySet())
        print(keys.getClass)
        for(i<-keys) print(i+" : "+dic.get(i)+"\n")
        */
        /*Exercice 6*/
        var calendar = mutable.LinkedHashMap[String,Integer]()
        calendar += ("Monday"->java.util.Calendar.MONDAY)
        calendar += ("Tuesday"->java.util.Calendar.TUESDAY)
        calendar += ("Wednesday"->java.util.Calendar.WEDNESDAY)
        calendar += ("Thursday"->java.util.Calendar.THURSDAY)
        calendar += ("Friday"->java.util.Calendar.FRIDAY)
        calendar += ("Saturday"->java.util.Calendar.SATURDAY)
        calendar += ("Sunday"->java.util.Calendar.SUNDAY)
        for(i <- calendar) print(i+"\n")

        /*Exercice 7*/
        val props:mutable.Map[String,String] = java.lang.System.getProperties().asScala
        //for((k,v)<-props) println(k+" || "+v)
        val taller_key = props.foldLeft(0)((taille,entree) => 
        {
            if(entree._1.length>taille) entree._1.length
            else taille
        })

        val q
        print(immutable.10*" ")
        print("oo")
    }
}
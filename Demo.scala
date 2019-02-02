import scala.math._

object Demo {
   def main(args: Array[String]) {
      var myVar :Int = 10;
      val myVal :String = "Hello Scala with datatype declaration.";
      var myVar1 = 20;
      val myVal1 = "Hello Scala new without datatype declaration.";
      
      println(myVar); println(myVal); println(myVar1); 
      println(myVal1);
      println(sqrt(2))
      println(pow(2,4))
      println(min(3,Pi))
      println(BigInt("1234567890"))
      println(BigInt.apply("1234567890"))
   }
}
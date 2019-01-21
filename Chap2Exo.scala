import scala.io._

object Chap2Exo{

    def signum(x: Int) : Int = {
        if(x>0) 1 
        else if(x==0) 0 
        else -1
    }

    def countdown(n: Int):Unit={
        for(i <- n to (0,-1)) print(i+"\t")
    }

    def product(s:String):Int={
        s.map(_.toInt).product
    }

    def rec_product(s:String):Int={
        if(s.isEmpty) 1
        else s.head*rec_product(s.tail)
    }

    def rec_Xn(x:Int,n:Int):Double={
        if(n%2==0 && n>0) rec_Xn(x,n/2)*rec_Xn(x,n/2)
        else if(n%2!=0 && n>0) x*rec_Xn(x,n-1) 
        else if(n==0) 1
        else 1/rec_Xn(x,-n)
    }

    def main(args: Array[String]){
        val name = StdIn.readLine("Your name: ")
        print("Your age: ")
        val age = StdIn.readInt()
        println(s"Hello, ${name}! Next year, you will be ${age +1}.")
        for (i <- 1 to 3; from = 4 - i; j <- from to 3) print(f"i=${i}%d  j=${j}%d \t")
        println(signum(age))

        for(i <- 10 to (0, -1)) print(i+"\t")
        println("\n")
        countdown(20)
        var s: Int = 1
        for(i <- "Hello") s=s*i
        println("\n\n"+s)

        println("Hello".map(_.toInt).product)
        println(product("Hello"))
        println(rec_product("Hello"))
        println(rec_Xn(10,-1))
    }
}
object Chap6_5 extends App{
    if(args.length>0){
        println((args.reverse).mkString(" "))
    }else throw new Exception("Not enough arguments")
}
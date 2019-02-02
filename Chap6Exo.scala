object Chap6Exo extends App{

    /*Exercice 1*/
    object Conversions{
        def inchesToCentimeters(x:Int):Double= x*2.54
        def gallonsToLiters(x:Int):Double = x*3.78541
        def milesToKilometers(x:Int):Double = x*1.60934
    }
    println(Conversions.inchesToCentimeters(10))
    println(Conversions.gallonsToLiters(10))
    println(Conversions.milesToKilometers(10))

    /*Exercice 2*/
    abstract class UnitConversion{
        def convert(x:Int):Double
    }
    object InchesToCentimeters extends UnitConversion{
        override def convert(x:Int):Double = x*2.54
    }
    object GallonsToLiters extends UnitConversion{
        override def convert(x:Int):Double = x*3.78541
    }
    object MilesToKilometers extends UnitConversion{
        override def convert(x:Int):Double = x*1.60934
    }
    println(InchesToCentimeters.convert(10))
    println(GallonsToLiters.convert(10))
    println(MilesToKilometers.convert(10))

    /*Exercice 3*/
    object Origin extends java.awt.Point {
        // Its not a good idea since java.awt.Point class is mutable.
    }

    /*Exercice 4
    Define a Point class with a companion object so that you can construct Point
    instances as Point(3, 4), without using new.*/
    class Point(val x:Int, val y:Int){}
    object Point{
        def apply(x:Int, y:Int):Point = new Point(x,y)
    }
    val p = Point(3,4)
    println(p.x)
    println(p.y)

    /*Exercice 6*/
    object PlayCards extends Enumeration{
        val Clubs = Value("♣")
        val Diamonds = Value("♦")
        val Hearts = Value("♥")
        val Spades = Value("♠")

        /*Exercice 7*/
        def isRed(card: PlayCards.Value): Boolean = {
            card == Hearts || card == Diamonds
        }
    }
    println(PlayCards.Clubs.toString)
    println(PlayCards.Hearts.toString)
    println(PlayCards.Spades.toString)
    println(PlayCards.Diamonds.toString)
    println(PlayCards.isRed(PlayCards.Diamonds))
}
import scala.beans.BeanProperty

object Chap5Exo{
    def main(args: Array[String]){
        
        /*Exercice 1*/
        class Counter(private var value:Int = 0){
            def increment(){
                if(value == Int.MaxValue) throw new Exception("Too big")
                else value += 1
            }

            def current:Int = value
        }

        val co = new Counter(Int.MaxValue-1)
        println(co.current)
        co.increment()
        println(co.current)
        //co.increment()

        /*Exercice 2*/
        class BankAccount(private var amount:Int=0){
            def deposit(x:Int):Unit ={
                amount += x
            }
            def withdraw(x:Int):Unit={
                amount -= x
            }
            def balance:Int=amount 
        }
        val b = new BankAccount(500)
        println(b.balance)
        b.withdraw(300)
        println(b.balance)
        b.deposit(100)
        println(b.balance)

        /*Exercice 3*/
        class Time(private var hrs:Int, private var min:Int){
            if(hrs>23 && hrs<0) hrs=0
            if(min<0 && min>59) min=0 
            def before(other: Time):Boolean={
                if(hrs<other.hrs) true
                else if(hrs==other.hrs && min<other.min) true
                else false
            }
        }
        val t = new Time(24,24)
        println(t.before(new Time(23,23)))

        /*Exercice 4*/
        class Time4(private var hrs:Int, private var min:Int){
            private val _time = hrs*60 + min
            def before(other: Time4):Boolean = _time<other._time
        }
        val t1 = new Time4(17,17)
        println(t1.before(new Time4(18,12)))

        /*Exercice 6*/
        class Person(var name:String="Do", var age:Int=1){
            if(age<0) age=0
        }
        val p = new Person("John Do",31)
        println(p.name+" a "+p.age+" ans")

        /*Exercice 7*/
        class Person7 private(names:Array[String]){
            val firstName:String = names(0)
            val lastName:String = names(1)

            def this(name:String){ //Constructeur auxiliaire
                this(Person7.parse_name(name))
            }
        }

        object Person7{
            def parse_name(name:String):Array[String]={
                val names = name.split(' ')
                if(names.length!=2) throw new Exception("Format de nom invalide")
                names
            }
        }

        val p7 = new Person7("John Do")
        println(p7.firstName+" "+p7.lastName)

        /*Exercice 8*/
        class Car(val manufacturer:String, 
            val modelName:String, 
            val modelYear:Int = -1, 
            val licensePlate:String = ""){

            def this(manufacturer:String, modelName:String, licensePlate:String){
                this(manufacturer, modelName, -1, licensePlate)
            }
        }

        val car = new Car("a","b","goka")
        println(car.manufacturer+" "+car.modelName+" "+car.modelYear+" "+car.licensePlate)

        /*Exercice 9
        public class Chapter05Car {

            private final String manufacturer;
            private final String modelName;
            private final int modelYear;
            private final String licensePlate;

            public Chapter05Car(final String manufacturer, final String modelName) {
                this(manufacturer, modelName, -1);
            }

            public Chapter05Car(final String manufacturer, final String modelName, final int modelYear) {
                this(manufacturer, modelName, modelYear, "");
            }

            public Chapter05Car(final String manufacturer,
                    final String modelName,
                    final String licensePlate) {

                this(manufacturer, modelName, -1, licensePlate);
            }

            public Chapter05Car(final String manufacturer,
                    final String modelName,
                    final int modelYear,
                    final String licensePlate) {

                this.manufacturer = manufacturer;
                this.modelName = modelName;
                this.modelYear = modelYear;
                this.licensePlate = licensePlate;
            }
        }
        */

        /*Exercice 10*/
        class Employe(val name: String="John Q. Public", var salary: Double=0.0){}
    }
}
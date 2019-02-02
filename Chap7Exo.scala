object Chap7Exo extends App{
    /*Exercice 1*/
    package com {
        object FromCom {
            val value = 1
        }
        package horstmann {
            object FromHorstmann {
                val value = 2
            }    
            package impatient {
                object FromImpatient {
                    val value = 3
                }
            }
        }
    }
    /*Exercice 2*/
    package com {
        object FromCom{
            val value = 21
        }
    }
    /*Exercice 3*/
    package object random {
        private val addition: Int = (1013904223 % (1L << 32)).toInt
        private var seed : Int = 0
        def nextInt(): Int = {
            seed = (seed * 1664525) + addition
            if (seed < 0) ~seed
            else seed
        }
        def nextDouble(): Double = {
            nextInt() / (Int.MaxValue + 1.0)
        }
        def setSeed(seed: Int): Unit = this.seed = seed
    }
    /*Exercice 4
They decided to make it explicit by adding just one word "object" to package declaration,
 in my opinion, for a couple of reasons:
 _ since its possible to have package declarations in different files, it would be hard
 to maintain functions and variable in different places for the same package
 _ because variables in package object are global (singletons) they didn't want to make it
 available by default
 */
    /*Exercice 5*/
}
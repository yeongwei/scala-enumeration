package com.example

/*
 * Reference: 
 * 1. http://underscore.io/blog/posts/2014/09/03/enumerations.html
 * Resource:
 * 1. http://stackoverflow.com/questions/20089920/custom-scala-enum-most-elegant-version-searched
 */
object Main {
  def main(args: Array[String]): Unit = {
    val fruitOrder = FruitOrder(FruitStore.Apple)
    println(fruitOrder.f)
    println(PhoneBooth.Andriod.getClass) // class scala.Enumeration$Val
    println(PhoneBooth.Andriod) // Andriod
    // FIXME: Functionality still not the similar to Java Enumeration
  }
}

object FruitStore {
  sealed abstract class Fruit(name: String, price: Double) {
    def getName = name
    def getPrice = price
    override def toString = s"${getName}: RM ${getPrice}"
  }
  
  case object Apple extends Fruit("Fuji Apple", 1.00)
  case object Orange extends Fruit("Mandarin Citrus", 2.00)
  case object Pear extends Fruit("Green Stock", 3.00)
}

case class FruitOrder[T <: FruitStore.Fruit](f: T)

object PhoneBooth extends Enumeration { 
  type Phone = Value
  val Andriod, Iphone = Value
}
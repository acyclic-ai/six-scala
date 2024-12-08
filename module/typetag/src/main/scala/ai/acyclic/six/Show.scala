package ai.acyclic.six

object Show {

  import scala.quoted.*

  inline def showType[T](): String =
    ${ showTypeImpl[T]() }

  def showTypeImpl[T: Type]()(
      using
      quotes: Quotes
  ): Expr[String] = {

    import quotes.reflect.*
    Expr(TypeRepr.of[T].dealias.show)
  }

  // Usage
//  @main def test =
//    val x = 42
//    val y = "hello"
//    val z = List(1, 2, 3)
//
//    println(showType(x)) // prints: Int
//    println(showType(y)) // prints: String
//    println(showType(z)) // prints: List[Int]
}

//println(showType(x)) // prints: Int
//println(showType(y)) // prints: String
//println(showType(z)) // prints: List[Int]

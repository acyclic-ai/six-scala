package ai.acyclic.six.lower

import java.io.{ByteArrayInputStream, ByteArrayOutputStream, ObjectInputStream, ObjectOutputStream}
import java.util.Base64
import scala.quoted.*

trait SerialisingLowering[T] extends ToExpr[T] {

  def apply(x: T)(
      using
      Quotes
  ): Expr[T] = {
    val stringsExpr: Expr[Seq[String]] = Varargs(serialize(x).map(Expr(_)))

    deserialize('{ $stringsExpr.toList })
  }

  protected def serialize(x: T): List[String]

  protected def deserialize(expr: Expr[List[String]])(
      using
      Quotes
  ): Expr[T]
}

object SerialisingLowering {}

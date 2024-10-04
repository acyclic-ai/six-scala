package ai.acyclic.six.typetag

import ai.acyclic.six.lower.SerialisingLowering

import scala.quoted.{Expr, Quotes, Type}

object TypeTagLowering {

  protected def deserialize[T: Type](expr: Expr[List[String]])(
      using
      Quotes
  ): Expr[TypeTag[T]] = {

    '{ TypeTag[T]($expr)() }
  }
}

// not used, TypeTag is very structural
@Deprecated
case class TypeTagLowering[T]() extends SerialisingLowering[TypeTag[T]] {

  override protected def serialize(x: TypeTag[T]): List[String] = {
    x.tastyBinary
  }

  override protected def deserialize(expr: Expr[List[String]])(
      using
      Quotes
  ): Expr[TypeTag[T]] = {

//    TASTyLowering.deserialize(expr)
    ???
    // TODO: wait for https://github.com/scala/scala3/issues/21696
  }
}

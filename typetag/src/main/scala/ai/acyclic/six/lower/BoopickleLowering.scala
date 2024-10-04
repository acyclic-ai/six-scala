package ai.acyclic.six.lower

import boopickle.Default.{Pickle, Unpickle}
import boopickle.Pickler

import java.nio.ByteBuffer
import java.util.Base64
import scala.quoted.*

class BoopickleLowering[T: Pickler] extends SerialisingLowering[T] {

  import BoopickleLowering.*

  override protected def serialize(x: T): List[String] = {

    val bytes = Pickle.intoBytes(x)

    val serialized = encoder.encodeToString(bytes.array())
    serialized.sliding(MAX_LITERAL_LENGTH, MAX_LITERAL_LENGTH).toList
  }

  override protected def deserialize(expr: Expr[List[String]])(
      using
      Quotes
  ): Expr[T] = {

    ???
  }
}

object BoopickleLowering {

  @transient lazy val encoder: Base64.Encoder = Base64.getEncoder
  @transient lazy val decoder: Base64.Decoder = Base64.getDecoder

  private inline val MAX_LITERAL_LENGTH = 32768

  protected def deserializeImpl[T: Pickler](strings: Seq[String]): T = {
    val bytes = strings.map(decoder.decode).reduce(_ ++ _)

    val v = Unpickle[T].fromBytes(ByteBuffer.wrap(bytes))
    v
  }

  def deserialize[T: Type](expr: Expr[Seq[String]])(
      using
      Quotes
  ): Expr[T] = {

    import boopickle.Default.*
    '{ deserializeImpl[T]($expr) }
  }

  object Implicits {

    given only[T: Pickler]: BoopickleLowering[T] = BoopickleLowering[T]()
  }
}

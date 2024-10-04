package ai.acyclic.six.lower

import java.io.{ByteArrayInputStream, ByteArrayOutputStream, ObjectInputStream, ObjectOutputStream}
import java.util.Base64
import scala.quoted.*

object JavaLowering {

  @transient lazy val encoder: Base64.Encoder = Base64.getEncoder
  @transient lazy val decoder: Base64.Decoder = Base64.getDecoder

  private inline val MAX_LITERAL_LENGTH = 32768

  protected def deserializeImpl[T](strings: Seq[String]): T = {
    val bytes = strings.map(decoder.decode).reduce(_ ++ _)
    val bIStream = new ByteArrayInputStream(bytes)
    val oIStream = new ObjectInputStream(bIStream)
    val v = oIStream.readObject()
    v.asInstanceOf[T]
  }

  def deserialize[T: Type](expr: Expr[Seq[String]])(
      using
      Quotes
  ): Expr[T] = {

    '{ deserializeImpl[T]($expr) }
  }

  //    def only[T <: Serializable: Type]: JVMNative[T] = JVMNative[T]()

  object Implicits {

    given only[T <: Serializable: Type]: JavaLowering[T] = JavaLowering[T]()
  }
}

class JavaLowering[T <: Serializable: Type] extends SerialisingLowering[T] {

  import JavaLowering.*

  override protected def serialize(x: T): List[String] = {
    val bOStream = new ByteArrayOutputStream()
    val oOStream = new ObjectOutputStream(bOStream)
    oOStream.writeObject(x)
    val serialized = encoder.encodeToString(bOStream.toByteArray)
    serialized.sliding(MAX_LITERAL_LENGTH, MAX_LITERAL_LENGTH).toList
  }

  override protected def deserialize(expr: Expr[List[String]])(
      using
      Quotes
  ): Expr[T] = {

    JavaLowering.deserialize[T](expr)
  }
}

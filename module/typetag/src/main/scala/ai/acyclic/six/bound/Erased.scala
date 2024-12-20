package ai.acyclic.six.bound

trait Erased extends AnyRef

object Erased {
  // every type definition in this object reduce to null in runtime

  def apply[T <: Erased](): T = null.asInstanceOf[T]
}

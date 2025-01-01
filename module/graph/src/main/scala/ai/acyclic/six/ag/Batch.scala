package ai.acyclic.six.ag

trait Batch[+V] {

  def collect: Seq[V]
}

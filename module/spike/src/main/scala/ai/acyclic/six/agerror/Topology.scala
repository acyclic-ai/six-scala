package ai.acyclic.six.agerror

trait Topology { // constructor of axioms

  type _I <: Topology.AnyGraph._I

  class _Template[V] extends Foundation.Template {
    final type _I = Topology.this._I
    final type _V = V
  }

//  def newTemplate[V]: _Template[V] = _Template[V]()

  type Node[V] = Foundation.Node[_I, V]
  type Setter[V] = Foundation.Setter[_I, V]
}

object Topology {

  object AnyGraph extends Topology {

    trait _I extends Foundation.Induction {}

  }

  object Tree extends Topology {

    trait _I extends AnyGraph._I

  }

  { // sanity

    object t1 extends Tree._Template[Int]

    def node2Setter[I <: Topology.AnyGraph._I, V](v: Foundation.Node[I, V])(
        implicit
        ev: Foundation.T[I, V]
    ): ev._Setter = {

      ???
    }

    val n1: t1._Node = ???
    val setter: t1._Setter = {
      node2Setter[Tree._I, Int](n1)
//      node2Setter(n1)
    }
  }
}

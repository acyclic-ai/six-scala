package ai.acyclic.six.graph

object Foundation {

  trait Arrow
//  object Arrow {
//    trait Outbound extends Arrow
//  }

  trait Induction {
    def arrow: Arrow

    type FBound <: Induction

    protected def getInduction: Seq[FBound]
  }

  trait Node extends Induction {
    final override def arrow: Nothing = ???
  }

  object Induction {}

  trait Graph {

    type Batch[+T] <: Iterable[T]

//    type _Node <: Node

    def entries: Batch[Node]
  }

  trait Domain {

//    type MaxNode <: Foundation.Node
    type MaxGraph <: Foundation.Graph

    trait FP extends Induction {

      type FBound = Domain.this.FBound
    }
    type FBound <: Induction // doesn't work on Scala 3: https://github.com/scala/scala3/issues/22257

    type Node = FBound & Foundation.this.Node

    type Graph = MaxGraph { type _Node <: Node }
  }

  trait Topology extends Domain {

//    type MaxNode = Foundation.this.Node

    type MaxGraph = Foundation.this.Graph

//    trait Node_ extends MaxNode {
//      type FBound = Topology.this.FBound
//    }
  }

  {
    // sanity

    trait Arrow1 extends Arrow

    object T1 extends Topology {

      trait FBound extends FP {
        def arrow: Arrow1
      }
    }

    object T2 extends Topology {

      trait FBound extends FP with T1.FBound
    }
  }
}

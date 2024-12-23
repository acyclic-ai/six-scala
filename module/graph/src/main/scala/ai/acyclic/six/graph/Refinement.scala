//package ai.acyclic.six.graph
//
//object Refinement {
//
//  trait Arrow extends Foundation.Arrow
//  object Arrow {
//    trait Outbound extends Arrow
//  }
//
//  trait Refined {
//
//    type Value
//  }
//  object Refined {
//    type Lt[+V] = Refined { type Value <: V }
//  }
//
//  trait Node extends Foundation.Node with Refined {
//
//    def value: Value
//  }
//
//  trait Graph extends Foundation.Graph with Refined
//
//  trait Topology extends Foundation.Topology {
//
//    trait Refined[V] extends Foundation.Domain {
//
//      override type MaxNode = Refinement.this.Node { type Value <: V }
//      override type MaxGraph = Refinement.this.Graph { type Value <: V }
//
////      trait FPP extends Foundation.Induction {
////
////        def node: Refined.this.Node
////      }
//
//      override type FBound = Topology.this.FBound & FP
//    }
//  }
//
//  object Outbound extends Topology {
//
//    trait FBound extends FP {
//      def arrow: Arrow.Outbound
//    }
//  }
//
//  object Poset extends Topology {
//
//    trait FBound extends FP {}
//  }
//
//  object Semilattice extends Topology {
//
//    trait FBound extends FP with Poset.FBound
//
//    object Upper extends Topology {
//
//      trait FBound extends FP with Semilattice.FBound with Outbound.FBound
//    }
//  }
//
//  object Tree extends Topology {
//
//    trait FBound extends FP with Semilattice.Upper.FBound {}
//  }
//
//  {
//    // sanity
//
////    object Node1 extends Tree.Node_ {
////
////      override protected def getInduction: Seq[Tree.FBound] = {
////        Seq(
////          new Tree.FBound {
////            override def arrow: Arrow.Outbound = ???
////
////            override def node: Tree.Node = ???
////          }
////        )
////      }
////    }
//
//    implicitly[Semilattice.Upper.Node <:< Semilattice.Node]
//    implicitly[Semilattice.Upper.Node <:< Outbound.Node]
//
//    implicitly[Semilattice.Upper.Graph <:< Semilattice.Graph]
//    implicitly[Semilattice.Upper.Graph <:< Outbound.Graph]
//  }
//}

package ai.acyclic.six.agerror

object Foundation {

  trait Induction {}

  trait Template {

    type _I <: Induction
    type _V

    type _Node = Foundation.Node[_I, _V]
    type _Setter = Foundation.Setter[_I, _V]

    trait Node_ extends Node.Prime[this.type] {
      override val T: Template.this.type = Template.this
    }

    trait Setter_ extends Node.Prime[this.type] {
      override val T: Template.this.type = Template.this
    }
  }

  type T[I, V] = Template { type _I = I; type _V = V }

  implicit def newTemplate[I <: Induction, V]: Template {
    type _I = I
    type _V = V
  } = ???

  trait XProto {
    val T: Template
  }

//  trait X_T[X <: Template] extends XProto { // short for axiomatic
//    override val T: X
//  }

  trait Def {

    type Prime <: XProto

    type Lt[+I <: Induction, +V] = Prime { val x: Template { type _X <: I; type _V <: V } }
//    type Lt[+I <: Induction, +V] = Prime[? <: Template { type _X <: I; type _V <: V }]
//    type Lt[+I <: Induction, +V] = Prime[Template { type _X <: I; type _V <: V }]

    type Aux[I <: Induction, V] = Prime { val x: Template { type _X = I; type _V = V } }
  }

  object Node extends Def {

    trait Prime[X <: Template] extends XProto {

      def value: T._V

      def induction: Seq[(T._I, T._V)]
    }
  }
  type Node[+I <: Induction, +V] = Node.Lt[I, V]

  object Setter extends Def {

    trait Prime[X <: Template] extends XProto {

      def link(node: T._Node)(
          to: Seq[(T._I, T._V)]
      ): T._Node
    }
  }
  type Setter[I <: Induction, V] = Setter.Aux[I, V]
}

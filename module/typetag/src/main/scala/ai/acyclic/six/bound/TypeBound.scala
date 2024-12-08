package ai.acyclic.six.bound

trait TypeBound extends Erased {

  /**
    * used like a type argument with lower & upper bound
    *
    * e.g. [[fn[T >: Min <: Max](t: T): Unit]] is equivalent to:
    *
    * [[fn[B <: TypeBound.K[Min, Max](implicit bound: B = Erased())(t: bound.Range): Unit]]
    *
    * OR (with type projection)
    *
    * [[fn[B <: TypeBound.K[Min, Max](t: B#Range): Unit]]
    *
    * but it has the extra benefit of making Min & Max accessible, which is not possible in before
    */

  type Min
  type Max >: Min

  type Range >: Min <: Max

  type Less = TypeBound.Lt[this.Min, this.Max]
  type More = TypeBound.Gt[this.Min, this.Max]
}

object TypeBound {
  type K[TMin, TMax >: TMin] = TypeBound {
    type Min = TMin
    type Max = TMax
  }

  type |~|[TMin, TMax >: TMin] = K[TMin, TMax]

  type Lt[TMin, TMax >: TMin] = TypeBound {
    type Min >: TMin
    type Max <: TMax
  }
  type <~>[TMin, TMax >: TMin] = Lt[TMin, TMax]

  type Gt[TMin, TMax >: TMin] = TypeBound {
    type Min <: TMin
    type Max >: TMax
  }
  type >~<[TMin, TMax >: TMin] = Gt[TMin, TMax]

  type Top = K[Nothing, Any]
  val Top: Top = Erased()

  type Pinpoint = TypeBound { type Max = Min }
  type |[T] = Pinpoint { type Min = T }

  trait __Sanity {

    val maxBound: TypeBound

    type Bound = maxBound.Less & TypeBound.Pinpoint

    {
      val less: maxBound.Less = ???
      implicitly[less.Max <:< maxBound.Max]
    }

    {
      val less: maxBound.Less & TypeBound.Pinpoint = ???
      implicitly[less.Max <:< maxBound.Max]
    }
  }
}

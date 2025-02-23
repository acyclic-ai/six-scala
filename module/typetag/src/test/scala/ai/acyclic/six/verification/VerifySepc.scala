package ai.acyclic.six.verification

import org.tribbloid.scaffold.BaseSpec

import scala.compiletime.testing.typeCheckErrors

class VerifySepc extends BaseSpec {

  it("sanity") {

    val ee = typeCheckErrors("1: String")

    require(ee.size == 1)
    println(ee)
  }

  it("type assignment error") {

    Verify.typeError("1: String")

    Verify.typeError("1: Product")
  }

  it("implicit error") {

    Verify.typeError("summon[Int <:< String]")
  }
}

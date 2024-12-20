package ai.acyclic.six.testing

import org.tribbloid.scaffold.BaseSpec

import scala.compiletime.testing.typeCheckErrors

class VerifySepc extends BaseSpec {

  it("sanity") {

    val ee = typeCheckErrors("1: String")

    require(ee.size == 1)
    println(ee)
  }

  it("type assignment error") {

    Verify.mustHaveTypeErrors("1: String")

    Verify.mustHaveTypeErrors("1: Int")
  }

  it("implicit error") {

    Verify.mustHaveTypeErrors("summon[Int <:< String]")
  }
}

package ai.acyclic.six.testing

import org.tribbloid.scaffold.BaseSpec

import scala.compiletime.testing.typeCheckErrors

class AssertSepc extends BaseSpec {

  it("sanity") {

    val ee = typeCheckErrors("1: String")

    require(ee.size == 1)
    println(ee)
  }

  it("type assignment error") {

    Assert.typeError("1: String")

    Assert.typeError("1: Int")
  }

  it("implicit error") {

    Assert.typeError("summon[Int <:< String]")
  }
}

package ai.acyclic.six.verification

import org.tribbloid.scaffold.BaseSpec

import scala.compiletime.testing.typeCheckErrors

class AssertSepc extends BaseSpec {

  it("sanity") {

    val ee = typeCheckErrors("1: String")

    require(ee.size == 1)
    println(ee)
  }

  it("type assignment error") {

<<<<<<<< HEAD:module/typetag/src/test/scala/ai/acyclic/six/verification/AssertSepc.scala
    Assert.typeError("1: String")

    Assert.typeError("1: Int")
========
    Verify.typeError("1: String")

    Verify.typeError("1: Int")
>>>>>>>> 5d92854 (simplify Assert class):module/typetag/src/test/scala/ai/acyclic/six/verification/VerifySepc.scala
  }

  it("implicit error") {

<<<<<<<< HEAD:module/typetag/src/test/scala/ai/acyclic/six/verification/AssertSepc.scala
    Assert.typeError("summon[Int <:< String]")
========
    Verify.typeError("summon[Int <:< String]")
>>>>>>>> 5d92854 (simplify Assert class):module/typetag/src/test/scala/ai/acyclic/six/verification/VerifySepc.scala
  }
}

package ai.acyclic.six.spark.serialization

import org.scalatest.funspec.AnyFunSpec

// only 1 test for classpath error
class AssertSerializableSpec extends AnyFunSpec {

  it("string") {

    val v = "abc"
    AssertSerializable(v).weakly()
  }
}

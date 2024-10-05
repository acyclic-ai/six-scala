package ai.acyclic.six.typetag

import org.tribbloid.scaffold.BaseSpec

class TypeTagSpec extends BaseSpec {
  import TypeTagSpec.*

  describe("TypeTag") {

    val tag0 = TypeTag.get[T1[Int]]
    val tag1 = TypeTag.get[Seq[T1[Int]]]

    it("toString") {

      assert(tag0.toString == classOf[T1[?]].getCanonicalName + "[Int]")
      assert(tag1.toString == "Seq[" + tag0 + "]")
    }

    it("runtimeClass") {

      assert(tag0.runtimeClass == classOf[T1[?]])
      assert(tag1.runtimeClass == classOf[Seq[?]])
    }

    it("summon") {

      val s = summon[TypeTag[T1[Int]]]

      assert(s == tag0)
      assert(s != tag1)
    }

    it("minimal showcase") {

      val ttg = summon[TypeTag[List[String]]]
      require(ttg.toString == "List[String]")
      require(ttg.runtimeClass.toString == "class scala.collection.immutable.List")
    }
  }
}

object TypeTagSpec {

  trait T1[T]
}

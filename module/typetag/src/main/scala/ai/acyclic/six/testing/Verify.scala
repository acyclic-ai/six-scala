package ai.acyclic.six.testing

object Verify {
  import scala.compiletime.testing

  inline infix def mustHaveTypeErrors(inline code: String): Unit = {

    val errors = testing.typeCheckErrors(code)

    if (errors.isEmpty) {
      throw new IllegalArgumentException("Expected type errors but got None")
    }
    ()
  }

  // from
  // https://git.rossabaker.com/http4s/http4s/commit/1b5598249a3fc63bbbddd074ef215161a2aaa38d
//  inline def mustHaveTypeErrors(code: String): Unit = {
//    if (testing.typeChecks(code)) {
//      throw new IllegalArgumentException(s"${code} has no type error")
//    }
//    ()
//  }

//  inline def ensureDoesNotCompile(inline code: String): Unit = {
//    requireConst(code)
//  }
}

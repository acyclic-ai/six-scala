val vs = versions()

dependencies {

    api("org.apache.spark:spark-core_2.13:4.0.0-preview2")
    api("org.apache.spark:spark-sql_2.13:4.0.0-preview2")


    tasks {

        withType<ScalaCompile> {

            scalaCompileOptions.apply {

                additionalParameters.addAll(
                    listOf(
                        "-source:3.3"
                    )
                )
            }
        }
    }
}
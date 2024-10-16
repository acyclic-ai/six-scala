val vs = versions()

dependencies {
//    testFixturesApi(project(":spark:spark-test-fixtures"))

    api("org.apache.spark:spark-core_2.13:4.0.0-preview2")

// https://mvnrepository.com/artifact/org.virtuslab/iskra
//    api("org.virtuslab:iskra_3:0.0.3") // TODO: add back after API is finalized

}
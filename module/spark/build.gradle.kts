val vs = versions()

dependencies {
//    testFixturesApi(project(":spark:spark-test-fixtures"))

    api("org.apache.spark:spark-core_2.13:4.0.0-preview2")
    api("org.apache.spark:spark-sql_2.13:4.0.0-preview2")

// https://mvnrepository.com/artifact/org.virtuslab/iskra
    api(project(":six:iskra"))
//    api("org.virtuslab:iskra_3:0.0.3") // don't move, cannot include spark-sql directly
}
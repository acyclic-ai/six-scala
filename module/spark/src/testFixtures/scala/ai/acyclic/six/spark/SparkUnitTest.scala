package ai.acyclic.six.spark

import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}
import org.scalatest.BeforeAndAfterAll
import org.scalatest.funspec.AnyFunSpec

abstract class SparkUnitTest extends AnyFunSpec, BeforeAndAfterAll:
  def appName: String = getClass.getSimpleName

  given spark: SparkSession =

    val sparkConf = new SparkConf(true).setAll(
      Map(
      )
    )

    SparkSession
      .builder()
      .master("local")
      .config(sparkConf)
      .appName(suiteName)
      .getOrCreate()

  def sc: SparkContext = spark.sparkContext

  override def afterAll(): Unit =
    spark.stop()

  export org.scalatest.matchers.should.Matchers.shouldEqual

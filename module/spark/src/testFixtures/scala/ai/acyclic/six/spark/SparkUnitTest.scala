package ai.acyclic.six.spark

import org.apache.spark.SparkContext
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.BeforeAndAfterAll
import org.scalatest.funspec.AnyFunSpec
import org.virtuslab.iskra.api.*

abstract class SparkUnitTest extends AnyFunSpec, BeforeAndAfterAll:
  def appName: String = getClass.getSimpleName
  
  given spark: SparkSession =
    SparkSession
      .builder()
      .master("local")
      .appName(suiteName)
      .getOrCreate()

  def sc: SparkContext = spark.sparkContext
  
  override def afterAll(): Unit =
    spark.stop()

  export org.scalatest.matchers.should.Matchers.shouldEqual
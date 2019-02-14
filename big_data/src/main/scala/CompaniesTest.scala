package dollin

import org.apache.spark.sql.SparkSession
import org.slf4j.{Logger, LoggerFactory}

object CompaniesTest {

  def main(args: Array[String]) {
    case class Company(name: String, employeeCount: Int, isPublic: Boolean)
    println("Starting SPARK App")

    val sqlContext = SparkSession.builder
      .master("local[*]")
      .appName("Word Count")
      .getOrCreate()

    val emeaCompanies = sqlContext.read.json("file:///coursera-github/big_data/src/main/resources/EMEACompanies.json")
    val usCompanies = sqlContext.read.json("file:///coursera-github/big_data/src/main/resources/USCompanies.json")

    emeaCompanies.show()
    emeaCompanies.printSchema()
    var allCompanies = emeaCompanies.union(usCompanies)
    allCompanies.whereshow()
  }
}

//val allCompaniesDF = companiesDF.unionAll(companiesJsonDF)
//val companiesJsonIntDF = companiesJsonDF.select($"name", $"employeeCount".cast("int").as("employeeCount"), $"isPublic")
//val allCompaniesDF = companiesDF.unionAll(companiesJsonIntDF)
//allCompaniesDF.groupBy(allCompaniesDF.col("isPublic")).agg(avg("employeeCount")).show
//allCompaniesDF.where($"employeeCount" > 1000).show
//allCompaniesDF.where(allCompaniesDF.col("employeeCount").gt(1000))
//import org.apache.spark.sql.Row
//allCompaniesDF.map(company=>company(0).asInstanceOf[String])
//  .foreach(println)
//allCompaniesDF.write.json("file:///Data/all.json")
//allCompaniesDF.registerTempTable("Companies")
//sql("SELECT * FROM Companies")
//  .show
//sql("SELECT AVG(employeeCount) AS AverageEmpCount FROM Companies GROUP BY isPublic").show
//sql("CACHE TABLE Companies")
//sql("CACHE LAZY TABLE Companies")
//
//
//

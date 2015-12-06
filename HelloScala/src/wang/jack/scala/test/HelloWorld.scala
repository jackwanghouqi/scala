package wang.jack.scala.test

object HelloWorld {
  def main(args: Array[String]) {
    println("Hello, world!");
  }

  def test() {
    val textFile = spark.textFile("hdfs://...")
    val errors = textFile.filter(line => line.contains("ERROR"))
    // Count all the errors
    errors.count()
    // Count errors mentioning MySQL
    errors.filter(line => line.contains("MySQL")).count()
    // Fetch the MySQL errors as an array of strings
    errors.filter(line => line.contains("MySQL")).collect()
  }
}
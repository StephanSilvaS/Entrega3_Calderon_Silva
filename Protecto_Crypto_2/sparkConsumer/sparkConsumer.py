import pyspark
import pyspark.sql

conf = {
  "spark.cassandra.connection.host": "localhost",
  "spark.cassandra.connection.port": 9042,
  "spark.cassandra.keyspace": "crypto"
}

conf_dict = dict(conf)

spark = pyspark.sql.SparkSession.builder.appName("PySpark Cassandra").config(conf=conf_dict).getOrCreate()

df = spark.read.cassandra("crypto", "bitcoin")

# Print the first 10 rows of the DataFrame.
df.show(10)


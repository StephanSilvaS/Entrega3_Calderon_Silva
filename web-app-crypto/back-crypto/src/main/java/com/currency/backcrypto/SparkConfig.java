package com.currency.backcrypto;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.functions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SparkConfig {

    @Bean
    public SparkConf sparkConf() {
        return new SparkConf().setAppName("My Spark Application").setMaster("local[*]");
    }

    @Bean
    public SparkSession sparkSession() {
        return SparkSession.builder().appName("My Spark Application").master("local[*]").getOrCreate();
    }

    // Read data from Cassandra.
    public Dataset<Row> dataframe() {
        SparkSession sesion = sparkSession();
        return sesion.read().format("org.apache.spark.sql.cassandra").option("keyspace", "crypto").option("table", "bitcoin").load();
    }

    // Show the data.
    public void showData() 
    {
        dataframe().show(10);
    }

    // Save the dataframe as a .csv file.
    public void saveData() {
        // Se setea repartition para evitar las particiones del archivo csv
        dataframe().repartition(1).write().format("csv").save("tablaBitcoin");
    }

    // Calculate the mean of the dataframe
    public double mean() {
        Dataset<Row> df = dataframe();
        double mean = df.select(functions.mean("valor")).first().getDouble(0);
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println(mean);
        System.out.println("");
        System.out.println("");
        System.out.println("");
        return mean;
    }
    
}



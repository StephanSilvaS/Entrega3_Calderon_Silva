package com.currency.backcrypto.controllers;
/*
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.functions;

import java.io.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.currency.backcrypto.models.Bitcoin;

@RestController
public class SparkController {
    /*
    @Autowired
    private SparkSession sparkSession;

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
        dataframe().repartition(1).write().format("csv").save("tablacrypto.csv");
    }

    @GetMapping("/read-csv")
    @ResponseBody
    public String readCSV() throws NumberFormatException, IOException {
    // Get the .csv file
    File csvFile = new File("E:\\Programas_USACH\\Sistemas Distribuidos\\back-crypto\\tablacrypto.csv\\part-00000-f10703a5-ce51-486c-ab49-dd6e606fc7c0-c000.csv");

    // Create a reader for the .csv file
    BufferedReader reader = new BufferedReader(new FileReader(csvFile));

    // Iterate over the rows in the .csv file
    String line;
    while ((line = reader.readLine()) != null) {
        // Split the row into columns
        String[] columns = line.split(",");

        // Create a new user from the columns
        Bitcoin nuevoBitcoin = new Bitcoin();
        nuevoBitcoin.setId(Integer.parseInt(columns[0]));
        nuevoBitcoin.setValor(columns[1]);

    }

    // Close the reader
    reader.close();

    // Return a success message
    return "CSV leido exitosamente";
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

    // Add more endpoints for other Spark operations as needed
}
*/
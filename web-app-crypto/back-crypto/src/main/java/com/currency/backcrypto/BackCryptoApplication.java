package com.currency.backcrypto;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.datastax.oss.driver.api.core.session.Session;
import com.datastax.oss.driver.api.core.session.SessionBuilder;


@SpringBootApplication
public class BackCryptoApplication {	
	public static void main(String[] args) {
		// SpringApplication.run(BackCryptoApplication.class, args);
		SparkConfig sparkConfig = new SparkConfig();
    	sparkConfig.saveData();
	}
}

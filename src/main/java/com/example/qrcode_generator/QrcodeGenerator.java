package com.example.qrcode_generator;

/**
 * 
 * @author memon
 * Main Class
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class QrcodeGenerator {

	public static void main(String[] args) {
		SpringApplication.run(QrcodeGenerator.class, args);
	}

}

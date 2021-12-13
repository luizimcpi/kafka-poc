package com.devlhse.kafkapoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class KafkaPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaPocApplication.class, args);
	}

}

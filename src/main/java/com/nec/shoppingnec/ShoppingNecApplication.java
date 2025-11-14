package com.nec.shoppingnec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.nec.shoppingnec.model")               // where your @Entity classes live
@EnableJpaRepositories("com.nec.shoppingnec.repository") // where your JpaRepository interfaces live
@ComponentScan("com.nec.shoppingnec")
public class ShoppingNecApplication {

	public static void main(String[] args) {

        SpringApplication.run(ShoppingNecApplication.class, args);
        System.out.println("ShoppingNecApplication started successfully.");
	}

}

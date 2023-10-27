package com.Gamer.Joks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

//@SpringBootApplication
/*@EnableSpringDataWebSupport
@ComponentScan(basePackages={"com.Gamer.Joks*"})
@EntityScan("com.Gamer.Joks.persistence.entity")*/
@SpringBootApplication
//@EnableAutoConfiguration
public class JoksApplication {
	public static void main(String[] args) {
		SpringApplication.run(JoksApplication.class, args);
	}

}

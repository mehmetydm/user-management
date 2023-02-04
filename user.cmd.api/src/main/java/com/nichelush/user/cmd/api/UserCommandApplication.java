package com.nichelush.user.cmd.api;

import com.nichelush.user.core.configuration.AxonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({AxonConfig.class})
public class UserCommandApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserCommandApplication.class, args);
	}
}

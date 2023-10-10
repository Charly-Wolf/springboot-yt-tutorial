package com.example.beispielprojekt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class BeispielProjektApplication {

	public interface SaySomethingSevice {
		public String saySomething();
	}

	@Component
	public class SayHelloService implements SaySomethingSevice {
		@Override
		public String saySomething() {
			return "Hello World";
		}
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(BeispielProjektApplication.class, args);
		SaySomethingSevice saySomethingSevice = applicationContext.getBean(SaySomethingSevice.class);
		System.out.println(saySomethingSevice.saySomething());
	}

}

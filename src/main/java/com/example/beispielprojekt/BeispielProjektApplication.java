package com.example.beispielprojekt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class BeispielProjektApplication {

	public interface SaySomethingSevice {
		public String saySomething();
	}

//	@Component
//	public class SayHelloService implements SaySomethingSevice {
//		@Override
//		public String saySomething() {
//			return "Hello World";
//		}
//	}

	@Configuration
	public class SaySomethingConfiguration {
		@Bean
		public SaySomethingConfigurableService saySomethingConfigurableService() {
			SaySomethingConfigurableService saySomethingConfigurableService = new SaySomethingConfigurableService();
			saySomethingConfigurableService.setWhatToSay("Goodbye");
			return saySomethingConfigurableService;
		}
	}

	public class SaySomethingConfigurableService implements SaySomethingSevice {
		private String whatToSay = "";

		@Override
		public String saySomething() {
			return whatToSay;
		}

		public String getWhatToSay() {
			return whatToSay;
		}

		public void setWhatToSay(String whatToSay) {
			this.whatToSay = whatToSay;
		}
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(BeispielProjektApplication.class, args);
		SaySomethingSevice saySomethingSevice = applicationContext.getBean(SaySomethingSevice.class);
		System.out.println(saySomethingSevice.saySomething());
	}

}

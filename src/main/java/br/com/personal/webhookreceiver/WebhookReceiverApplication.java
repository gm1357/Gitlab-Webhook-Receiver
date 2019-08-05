package br.com.personal.webhookreceiver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@EnableAsync
public class WebhookReceiverApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebhookReceiverApplication.class, args);
	}

}

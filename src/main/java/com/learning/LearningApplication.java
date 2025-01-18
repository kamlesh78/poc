package com.learning;

import com.learning.observer.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableWebMvc
public class LearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningApplication.class, args);
		Parent gunMan = new GunMan();
		gunMan.setFireAction(new Bow());
		gunMan.doAction();


		Subject stock  = new StockSubject();
		Observer emailObserver   =  new EmailAlertObserver(stock,"temp@gmail.com");
		Observer smsObserver   =  new SmsAlertObserver(stock,"temp@gmail.com");
		stock.add(emailObserver);
		stock.add(smsObserver);
		stock.setStock(10);
	}

}

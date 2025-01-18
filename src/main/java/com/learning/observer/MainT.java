package com.learning.observer;

import com.learning.LearningApplication;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Getter
@Setter
@RequiredArgsConstructor
public class MainT {
    public static void main(String[] args){
        SpringApplication.run(LearningApplication.class, args);

        Subject stock  = new StockSubject();
        Observer emailObserver   =  new EmailAlertObserver(stock,"temp@gmail.com");
        Observer smsObserver   =  new SmsAlertObserver(stock,"temp@gmail.com");
        stock.add(emailObserver);
        stock.add(smsObserver);
        stock.setStock(10);

    }
}

package com.learning.observer;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class SmsAlertObserver implements Observer{

    private Subject subject;
    private String email;
    public SmsAlertObserver(Subject subject, String email) {
        this.subject = subject;
        this.email = email;
    }

    @Override
    public void update() {
        System.out.println("sms");
    }
}

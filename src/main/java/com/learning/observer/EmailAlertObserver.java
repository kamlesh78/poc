package com.learning.observer;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class EmailAlertObserver implements Observer{

    private Subject subject;
    private String email;
    public EmailAlertObserver(Subject subject,String email) {
        this.subject = subject;
        this.email = email;
    }

    @Override
    public void update() {
        System.out.println("email");
    }
}

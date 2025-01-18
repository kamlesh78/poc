package com.learning.observer;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class StockSubject implements Subject{
    private List<Observer> observers = new ArrayList<>();
    private int stock = 0;
    @Override
    public void add(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for(Observer observer : observers){
            observer.update();
        }
    }

    @Override
    public void setStock(int stock) {
        if(this.stock == 0){
           notifyObserver();
        }
        this.stock = stock;
    }
}

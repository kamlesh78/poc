package com.learning.observer;

public interface Subject {

    void add(Observer observer);
    void remove(Observer  observer);

    void notifyObserver();
    void setStock(int stock);

}

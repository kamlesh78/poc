package com.learning;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Parent {

    private Fire fire;
    public void doAction(){
        fire.fire();
    }

    public void setFireAction(Fire fire){
        this.fire= fire;
    }
}

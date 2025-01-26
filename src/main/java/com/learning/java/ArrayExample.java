package com.learning.java;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
public class ArrayExample {

    public static void main(String[] args) {
        List<String> list= new ArrayList<>(Arrays.asList("1","2"));
        //convert List to array
        String[] array = list.toArray(new String[0]);
        for(String s : array){
            System.out.println(s);
        }

        //convert array to  list
        List<String> arrayToList = Arrays.asList(array);

        List<String> arrayToModifiableList = new ArrayList<>(Arrays.asList(array));

      //  Collections.reverseOrder() -> return a comparator to sort in reverse order
        Collections.sort(arrayToList,Collections.reverseOrder());

    }
}

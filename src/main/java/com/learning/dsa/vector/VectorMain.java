package com.learning.dsa.vector;

import lombok.extern.slf4j.Slf4j;

import java.util.Vector;

@Slf4j
public class VectorMain {

    public static void main(String[] args) {
        // just like array but this is thread safe and legacy class
        // default initial capacity is 10
        Vector<Integer> vector = new Vector<>();
        log.info("vector capacity :: {}",vector.capacity());

        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        vector.add(5);

        log.info("vector elements :: {}",vector);

        vector.remove(1);
        log.info("vector elements :: {}",vector);
        vector.add(2);
        vector.remove(Integer.valueOf(1));
        log.info("vector elements :: {}",vector);

        vector.removeIf(x->x%2==0);
        log.info("vector elements :: {}",vector);

        log.info("vector capacity :: {}",vector.capacity());
        log.info("vector size :: {}",vector.size());


    }
}

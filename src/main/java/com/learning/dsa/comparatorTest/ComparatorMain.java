package com.learning.dsa.comparatorTest;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Slf4j
public class ComparatorMain{

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(4, 2, 5, 6, 10));
        list.sort(new ComparatorTest());
        log.info("{}",list);
    }


}
class ComparatorTest implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1-o2;
    }
}
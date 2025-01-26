package com.learning.dsa.linkedlist;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;

@Slf4j
public class LinkedListMain {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);

        log.info("linkedList :: {}",linkedList);
        linkedList.addFirst(3);
        log.info("addFirst :: {}",linkedList);
        linkedList.addLast(4);
        log.info("addLast :: {}",linkedList);
        linkedList.remove();
        log.info("remove :: {}",linkedList);
        log.info("getFirst :: {}",linkedList.getFirst());
        log.info("getLast :: {}",linkedList.getLast());
        linkedList.removeFirst();
        log.info("removeFirst :: {}",linkedList);
        linkedList.removeLast();
        log.info("removeLast :: {}",linkedList);


        ArrayListNode arrayListNode = new ArrayListNode();
        arrayListNode.add(10);
        arrayListNode.add(20);
        log.info("arrayListNode :: {}",arrayListNode.getLast());






    }
}

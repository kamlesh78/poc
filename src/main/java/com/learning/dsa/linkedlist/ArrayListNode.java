package com.learning.dsa.linkedlist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArrayListNode {

    private Node head;

    public void add(int data){
        Node node = new Node(data);
        if(head == null){
            head = node;
            return;
        }

        Node currentNode = head;
        if(currentNode.nextNode !=null){
            currentNode = currentNode.nextNode;
        }
        currentNode.nextNode = node;
    }

    public int getLast(){
        Node currentNode = head;
        while(currentNode.nextNode!=null){
            currentNode = currentNode.nextNode;
        }
        return currentNode.data;
    }

    private class Node{
        int data;
        Node nextNode;

        public Node(int data) {
            this.data = data;
            this.nextNode = null;
        }


    }
}


package com.learning.dsa.HashMapTest;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
public class HashMapTest<K,V> {

    public static void main(String[] args) {
        MyHashMap<Integer,Integer> map = new MyHashMap<>();
        map.put(1,100);
        map.put(2,200);
        System.out.println("get 1 :: " + map.get(1));
        System.out.println("get 2 :: " + map.get(2));

    }

}
class MyHashMap<K,V>{
    public static final int capacity = 10;
    public static int size=0;
    public static final double loadFactor = 0.75;

    private List<Node<K,V>> bucket;
    private class Node<K,V>{

        K key;
        V data;

        Node<K,V> next;

        public Node(K key, V data) {
            this.data = data;
            this.key = key;
            this.next = null;
        }
    }

    public MyHashMap() {
        bucket = new ArrayList<>();
        for(int i=0;i<capacity;i++){
            bucket.add(null);
        }
    }
    private int getBucket(K key) {
        return key.hashCode()%capacity;
    }
    public V get(K key){
        int bucketIndex = getBucket(key);
        Node<K, V> head = bucket.get(bucketIndex);
        while(head != null){
            if(head.key.equals(key)){
                return head.data;
            }
            head = head.next;
        }
        return null;
    }

    public void put(K key,V value){
        int bucketIndex = getBucket(key);
        Node<K, V> head = bucket.get(bucketIndex);
        Node<K,V> node = new Node<>(key,value);
        if(head == null){
            bucket.set(bucketIndex,node);
            return;
        }
        Node<K,V> nodePrev= null;
        while(head!=null){
            if(head.key.equals(key)){
                head.data = value;
                return;
            }
            nodePrev = head;
            head = head.next;
        }

        nodePrev.next = node;

    }

    @Override
    public String toString() {
        return "MyHashMap{" +
                "bucket=" + bucket +
                '}';
    }
}
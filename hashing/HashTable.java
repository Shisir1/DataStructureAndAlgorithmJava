package org.example.hashing;

public class HashTable {
    private HashNode[] buckets;
    private int numOfBuckets;   //capacity of Array
    private int size;   //no. of key value pair in hash table or hash nodes in hash table

    public HashTable(){
        this(10);   //default capacity
    }
    public HashTable(int capacity){
        this.numOfBuckets = capacity;
        buckets = new HashNode[numOfBuckets];
        this.size = 0;
    }

    private class HashNode {
        private Integer key;    //any generic Type
        private String value;   //any generic Type
        private HashNode next;

        public HashNode(Integer key, String value){
            this.key = key;
            this.value = value;
        }
    }

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public void put(Integer key, String value){

    }
    public String get(Integer key){
        return null;
    }
    public String remove(Integer key){
        return null;
    }
}

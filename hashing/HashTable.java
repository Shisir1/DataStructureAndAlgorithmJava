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
        if(key == null || value == null){
            throw new IllegalArgumentException("Key or Value is null!!");
        }
        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];
        while (head != null){
            if(head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        head = buckets[bucketIndex];
        HashNode node = new HashNode(key, value);   //(key,value) --> null
        node.next = head;
        buckets[bucketIndex] = node;
    }

    private int getBucketIndex(Integer key){
        return key % numOfBuckets;  //also can be buckets.length
    }
    public String get(Integer key){
        if(key == null){
            throw new IllegalArgumentException("key is null !!!");
        }

        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];
        while (head != null){
            if(head.key.equals(key)){
                return head.value;
            }
            head = head.next;
        }
        return null;
    }
    public String remove(Integer key){
        if(key == null){
            throw new IllegalArgumentException("Key is null !!");
        }
        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];
        HashNode previous = null;

        while (head != null){
            if(head.key.equals(key)){
                break;
            }
            previous = head;
            head = head.next;
        }
        if(head == null){
            return null;
        }
        size--;
        if(previous != null){
            previous.next = head.next;
        } else {
            buckets[bucketIndex] = head.next;
        }
        return head.value;
    }

    public static void main(String[] args) {
        HashTable table = new HashTable(10);
        table.put(105, "Tom");
        table.put(21, "Sana");
        table.put(21, "Harry"); //this node replaces Sana node because key is same
        table.put(31, "Shisir");
        System.out.println(table.size());

        System.out.println(table.get(31));  //returns "Shisir"

        System.out.println(table.get(21));

        System.out.println(table.remove(31));
        System.out.println(table.size());
    }
}

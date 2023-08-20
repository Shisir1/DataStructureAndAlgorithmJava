package org.example.PriorityQueue;

public class MaxPriorityQueue {

    private Integer[] heap;
    private int n;  //stores the size of max heap

    public MaxPriorityQueue(int capacity){
        heap = new Integer[capacity + 1];
        n = 0;
    }
    public boolean isEmpty(){
        return n ==0;
    }
    public int size(){
        return n;
    }

    public static void main(String[] args){
        MaxPriorityQueue pq = new MaxPriorityQueue(3);
        System.out.println(pq.size());
        System.out.println(pq.isEmpty());
    }
}

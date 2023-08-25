package org.example.PriorityQueue;

public class MaxPQ_Swim_Sink {

    private Integer[] heap;
    private int n;  //stores the size of max heap

    public MaxPQ_Swim_Sink(int capacity){
        heap = new Integer[capacity + 1];
        n = 0;
    }
    public boolean isEmpty(){
        return n ==0;
    }
    public int size(){
        return n;
    }
    public void insert(int x){
        if(n == heap.length - 1){
            resize(2*heap.length);
        }
        n++;
        heap[n] = x;
        swim(n);
    }

    //Bottom-up reheapify (swim)
    private void swim(int index ){
        while(index > 1 && heap[index/2] < heap[index]){
            int temp = heap[index];
            heap[index] = heap[index/2];
            heap[index/2] = temp;
            index = index/2;    //to continue shifting up till new value inserted is at correct position
        }
    }

    private void resize(int capacity) {
        Integer[] temp = new Integer[capacity];
        for(int i = 0; i < heap.length; i++){
            temp[i] = heap[i];
        }
        heap = temp;
    }
    public void printMaxHeap(){
        for(int i = 1; i <= n; i++){
            System.out.print(heap[i] + " ");
        }
    }

    public int deleteMax(){
        int max = heap[1];
        swap(1,n);
        n--;

        //now shift down from the top until its binary tree
        sink(1);
        heap[n + 1] = null;

        if(n > 0 && (n == (heap.length - 1) / 4)){
            resize(heap.length/2);
        }

        return max;
    }

    private void sink(int k) {
        while (2*k <= n){
            int j = 2*k;
            if(j < n && heap[j] < heap[j + 1]){
                j++;
            }
            if(heap[k] >= heap[j]){
                break;
            }
            swap(k,j);
            k = j;
        }
    }

    public void swap(int a, int b){
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }


    public static void main(String[] args){
        MaxPQ_Swim_Sink pq = new MaxPQ_Swim_Sink(3);
//        System.out.println(pq.size());
//        System.out.println(pq.isEmpty());
        pq.insert(4);
        pq.insert(5);
        pq.insert(2);
        pq.insert(6);
        pq.insert(1);
        pq.insert(3);

        System.out.println("Adjusted size : " + pq.size());
        pq.printMaxHeap();
        pq.deleteMax();
        System.out.println("\nAfter deletion:");
        pq.printMaxHeap();

    }
}

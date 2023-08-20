package org.example.DoublyLinedList;

import java.util.List;
import java.util.NoSuchElementException;

public class DoublyLinkedList {
    private ListNode head;
    private ListNode tail;
    private int length;
    private class ListNode{
        private int data;
        private ListNode previous;
        private ListNode next;

        public ListNode(int data){
            this.data = data;

        }
    }

    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty(){
        return length ==0; //or --> head == null
    }

    public int lenth(){
        return length;
    }

    public void insertLast(int value){
        ListNode newNode = new ListNode(value);
        if(isEmpty()){
            head = newNode;
        } else {
            tail.next = newNode;
        }
        newNode.previous = tail;
        tail = newNode;
        length++;
    }

    public void displayForward(){
        if(head == null){
            return;
        }
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void displayBackward(){
        if(tail == null){
            return;
        }
        ListNode temp = tail;
        while (temp != null){
            System.out.print(temp.data + "-->");
            temp = temp.previous;
        }
        System.out.println("null");
    }

    public void insertFirst(int value){
        ListNode newNode = new ListNode(value);
        if(isEmpty()){
            tail = newNode;
        } else {
            head.previous = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }

    public ListNode deleteFirst(){
        if(isEmpty()){
            throw new NoSuchElementException("NodeList is Empty!!!");
        }
        ListNode temp = head;
        if(temp == tail){
            tail = null;
        } else {
            head.next.previous = null;
        }
        head = head.next;
        temp.next = null;
        length--;

        return temp;
    }
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertLast(1);
        dll.insertLast(10);
        dll.insertLast(15);
//        dll.insertLast(3);
//        dll.insertLast(4);
//        dll.insertLast(5);
//        dll.insertFirst(1);
//        dll.insertFirst(2);
        dll.displayForward();

//        dll.deleteFirst();
//        dll.deleteFirst();
//        dll.deleteFirst();
//        dll.deleteFirst();
//
//
//        dll.displayForward();
//        dll.displayBackward();
    }

}

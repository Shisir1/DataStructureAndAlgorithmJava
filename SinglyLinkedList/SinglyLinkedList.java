package org.example.SinglyLinkedList;

public class SinglyLinkedList {

    private ListNode head;

    private static class ListNode {
        private int data; //Generic type
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void display() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public int length() {
        if (head == null) {
            return 0;
        }
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void insertFirst(int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }

    public void insert(int position, int value) {
        //1 --> 4 --> 5
        //after method execution 1 --> 6 --> 4 --> 5

        ListNode node = new ListNode(value);
        if (position == 1) {
            node.next = head;
            head = node;
        } else {
            ListNode previous = head;
            int count = 1;  //position -1

            while (count < position - 1) {
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            previous.next = node;
            node.next = current;
        }
    }

    public ListNode deleteFirst() {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }

    public ListNode deleteLast() {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        ListNode previous = null;

        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        previous.next = null; //break the chain
        return current;

    }
    public void insertLast(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void delete(int position) {
        //position is valid and starting from 1
        // our linked list -> 3 --> 4 --> 7 --> 8 --> 9 --> null
        if (position == 1) {
            head = head.next;
        } else {
            ListNode previous = head;
            int count = 1;

            while (count < position - 1) {
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            previous.next = current.next;
        }
    }

    public boolean find(ListNode head, int searchKey) {
        if (head == null) {
            return false;
        }

        ListNode current = head;
        while (current != null) {
            if (current.data == searchKey) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public ListNode getMiddleNode() {
        if (head == null) {
            return null;
        }

        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }

    public ListNode startNodeInALoop() {
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if(fastPtr == slowPtr){
                return getStartingNode(slowPtr);
            }
        }
    return null;
}

    private ListNode getStartingNode(ListNode slowPtr) {
        ListNode temp = head;
        while (temp != slowPtr){
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        return temp;    //starting nod eof the loop
    }

    private void removeLoop() {
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if(fastPtr == slowPtr){
                removeLoop(slowPtr);
                return;
            }
        }
    }

    private void removeLoop(ListNode slowPtr){
        ListNode temp = head;
        while (temp.next != slowPtr.next){
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        slowPtr.next = null;
    }

    public void createALoopInLinkedList(){
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);

        head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = third;
    }
    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.createALoopInLinkedList();
        System.out.println(sll.startNodeInALoop().data);
        sll.removeLoop();
        sll.display();



//
//        //Now we will connect them together to form a chain
//        sll.head.next = second; //10 -> 1
//        second.next = third;  // 10 --> 1 --> 8
//        third.next = fourth;  //10 --> 1 --> 8 --> 11 --> null

//        sll.insertLast(11);
//        sll.insertLast(8);
//        sll.insertLast(1);
//
//        sll.display();
//        System.out.println("Length is : " + sll.length());
//
//        sll.insert(1,3);
//        sll.insert(2,5);
//        sll.insert(3,2);
//        sll.insert(4,4);
//        sll.insert(5,10);
//        sll.insert(6,7); //2 --> 4 --> 3 --> 5 --> 7 --> null

//        System.out.println("Deleted node -> " + sll.deleteLast().data);
//        System.out.println("Deleted node -> " + sll.deleteLast().data);
//        sll.delete(1);
//        sll.delete(3);
//        sll.delete(3);

//        if(sll.find(sll.head,3)){
//            System.out.println("Search Key found!!!");
//        } else {
//            System.out.println("Search key NOT found!!!");
//        }

//        ListNode reversedListHead = sll.reverse(sll.head);
//        System.out.println("Reversed Linked List :");
//        sll.display(reversedListHead);
//
//        ListNode middleNode = sll.getMiddleNode();
//        System.out.println("MiddleNode is : " + middleNode.data);

    }
}

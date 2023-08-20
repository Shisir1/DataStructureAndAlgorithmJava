package org.example.SinglyLinkedList;

public class MergeTwoSortedListsLeetCode21 {

    private ListNode head;

    private static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static ListNode merge(ListNode a, ListNode b){
        //a --> 1 --> 3 --> 5 --> null
        //b --> 2 --> 4 --> 6 --> null
        //result --> 1 --> 2 --> 3 --> 4 --> 5 --> 6 --> null
        ListNode dummy = new ListNode(0); //data can be anything
        ListNode tail = dummy;

        while (a != null && b != null){
            if(a.data <= b.data){
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        if(a == null){
            tail.next = b;
        } else {
            tail.next = a;
        }
        return dummy.next;
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

    public void display() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        MergeTwoSortedListsLeetCode21 sll1 = new MergeTwoSortedListsLeetCode21();
        sll1.insertLast(1);
        sll1.insertLast(4);
        sll1.insertLast(8);

        MergeTwoSortedListsLeetCode21 sll2 = new MergeTwoSortedListsLeetCode21();
        sll2.insertLast(3);
        sll2.insertLast(5);
        sll2.insertLast(8);
        sll2.insertLast(9);
        sll2.insertLast(14);
        sll2.insertLast(18);

        sll1.display();
        sll2.display();

        System.out.println("After Merge :");
        MergeTwoSortedListsLeetCode21 result = new MergeTwoSortedListsLeetCode21();
        result.head = merge(sll1.head, sll2.head);

        result.display();

    }
}

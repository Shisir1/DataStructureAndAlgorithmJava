package org.example.SinglyLinkedList;

public class AddTwoLinkedListLeetCode2 {

    private ListNode head;

    private static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static ListNode add(ListNode a, ListNode b){
        //a --> 1 --> 3 --> 5 --> null  531 + 642 = 1173
        //b --> 2 --> 4 --> 6 --> null
        //result --> 1 --> 1 --> 7 --> 3 --> null
        ListNode dummy = new ListNode(0); //data can be anything
        ListNode tail = dummy;
        int carry = 0;

        while (a != null || b != null){
            int x = (a != null) ? a.data : 0;
            int y = (b != null) ? b.data : 0;

            int sum = carry + x + y;
            carry = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            if(a != null) a = a.next;
            if(b != null) b = b.next;
        }
        if(carry > 0){
            tail.next = new ListNode(carry);
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
        AddTwoLinkedListLeetCode2 sll1 = new AddTwoLinkedListLeetCode2();
        sll1.insertLast(1);
        sll1.insertLast(4);
        sll1.insertLast(8);

        AddTwoLinkedListLeetCode2 sll2 = new AddTwoLinkedListLeetCode2();
        sll2.insertLast(3);
        sll2.insertLast(5);
        sll2.insertLast(8);
        sll2.insertLast(9);
        sll2.insertLast(14);
        sll2.insertLast(18);

        sll1.display();
        sll2.display();

        System.out.println("After Add :");
        AddTwoLinkedListLeetCode2 result = new AddTwoLinkedListLeetCode2();
        result.head = add(sll1.head, sll2.head);

        result.display();

    }
}

package org.example.socialMedia;

//Amazon Interview Question
class ListNode {
    int data;
    ListNode next;
    ListNode (int data){
        this.data = data;
        this.next = null;
    }
}
public class RemoveBiggerNodesFromSinglyLinkedList {
    public ListNode removeNodes(ListNode head, int value){

        ListNode previous = new ListNode(0);
        previous.next = head;
        ListNode current = previous;

        while (current.next != null){
            if(current.next.data > value){
                //remove node
                current.next = current.next.next;
            } else {

                current = current.next;
            }
        }
        return head;
    }


    public void display(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        RemoveBiggerNodesFromSinglyLinkedList rbn = new RemoveBiggerNodesFromSinglyLinkedList();

        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original list: ");
        rbn.display(head);

        head = rbn.removeNodes(head,2);
        System.out.println("Modified list: ");
        rbn.display(head);

            }
}

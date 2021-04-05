package me.helpeachother.algorithm.linkedlist;

import java.util.List;
import java.util.Stack;

public class ReverseLinkedList {

    /**
     *
     * linkedlist reverse 어려움...
     */

    public static void main(String[] args) {

        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);

        ReverseLinkedList a = new ReverseLinkedList();
        ListNode reverse = a.reverserList(node);

        while (reverse != null) {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }


    }
    
    public ListNode reverserList(ListNode current) {
        ListNode prev = null;
        ListNode next = null;

        while(current != null) {
            next=current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }

    public ListNode reverserList_practice(ListNode current) {

        Stack<ListNode> stack = new Stack<>();

        while(current!=null) {
            stack.push(current);
            current = current.next;
        }

        ListNode newHead = new ListNode(0);
        ListNode p = newHead;

        
        while(!stack.isEmpty()) {
            p.next=stack.pop();
            p = p.next;
        }


        return newHead.next;




    }
}

package me.helpeachother.algorithm.linkedlist;

import java.util.*;

public class MergeKSortedList {
    
    
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] list = {l1, l2, l3};
        
        MergeKSortedList a = new MergeKSortedList();
        ListNode node = a.mergeKLists(list);
        
        while(node!=null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    private ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(Comp);
        ListNode newHead = new ListNode(0);
        ListNode p = newHead;

        for(ListNode node : lists) {
            if(node!=null) {
                queue.offer(node);
            }
        }

        while(!queue.isEmpty()) {
            ListNode node = queue.poll();
            p.next = node;
            p = p.next;

            if(node.next != null) {
                queue.offer(node.next);
            }
        }

        return newHead.next;

    }

    Comparator<ListNode> Comp = new Comparator<ListNode>() {
        @Override
        public int compare(ListNode a, ListNode b) {
            return a.val - b.val;
        }
    };

    public ListNode mergeKLists_practice(ListNode[] lists) {
        List<Integer> list = new ArrayList<>();
        
        for (ListNode node : lists) {
            while(node != null) {
                list.add(node.val);
                node = node.next;
            }
        }
        
        Collections.sort(list, (a,b)->a-b);

        ListNode result = new ListNode(list.get(0));


        for(int i=1; i<list.size(); i++) {
            result.next = new ListNode(list.get(i));
        }


        return null;
        
    }
}

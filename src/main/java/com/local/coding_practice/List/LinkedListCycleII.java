package com.local.coding_practice.List;

import java.util.Objects;

public class LinkedListCycleII {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        ListNode result = detectCycle(head);
        System.out.println(Objects.requireNonNull(result).val);
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                break;
            }
        }

        if(fast == null || fast.next == null){
            return null;
        }

        while(head != slow){
            head = head.next;
            slow = slow.next;
        }

        return head;
    }
}

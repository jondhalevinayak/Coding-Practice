package com.local.coding_practice.List;

public class RemoveDupFrmSortedListII {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        ListNode result = deleteDuplicates(head);

        while(result != null){
            System.out.print(result.val+" ");
            result = result.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;

        while(head != null){
            if(head.next != null && head.val == head.next.val){
                while(head.next != null && head.val == head.next.val){
                    head.next = head.next.next;
                }
                temp.next = head.next;
            } else {
                temp = temp.next;
            }
            head = head.next;
        }

        return pre.next;
    }
}

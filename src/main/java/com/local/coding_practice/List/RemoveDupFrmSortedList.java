package com.local.coding_practice.List;

public class RemoveDupFrmSortedList {

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
        ListNode dummy = head;
        while(dummy != null){
            if(dummy.next != null && dummy.val == dummy.next.val){
                dummy.next = dummy.next.next;
            } else {
                dummy = dummy.next;
            }
        }
        return head;
    }
}

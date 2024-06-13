package com.local.coding_practice.List;

public class RemoveNthNode {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        /*l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);*/
        ListNode listNode = removeNthFromEnd(l1, 1);

        while(listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        int count = 0;
        ListNode dummy = new ListNode(-1, head);
        ListNode temp = dummy;
        while (temp != null) {
            count += 1;
            temp = temp.next;
        }

        int remove = count - n;
        temp = dummy;

        while (temp != null) {
            remove -= 1;
            if(remove < 0){
                remove = 0;
            }

            if (remove == 0 && temp.next != null) {
                temp.next = temp.next.next;
                break;
            } else {
                temp = temp.next;
            }
        }

        return dummy.next;

    }

}

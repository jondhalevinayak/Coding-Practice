package com.local.coding_practice.List;

class SinglyLinkedListException extends RuntimeException {

    public SinglyLinkedListException() {
        super();
    }

    public SinglyLinkedListException(String message) {
        super(message);
    }
}

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}

public class SinglyLinkedList {

    Node first;

    public SinglyLinkedList() {
        first = null;
    }

    void add(int val) {
        Node node = new Node(val);

        if (first == null) {
            first = node;
            return;
        }

        Node tempNode = first;
        while (tempNode.next != null) {
            tempNode = tempNode.next;
        }

        tempNode.next = node;
    }

    Node delete() {

        if (this.first == null) {
            throw new SinglyLinkedListException("List is null");
        }

        if (this.first.next == null) {
            Node tempNode = this.first;
            this.first = this.first.next;
            return tempNode;
        }

        Node prev = null;
        Node curr = this.first;

        while (curr.next != null) {
            curr = curr.next;
            prev = curr;
        }

        prev.next = null;
        return curr;
    }

    public void displayList() {

        if(first == null){
            System.out.println("Intialize list first");
        }

        while(first != null){
            System.out.println(first.val);
            first = first.next;
        }
    }
}

class ListExecutor {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.displayList();

        list.delete();
        list.displayList();
    }
}

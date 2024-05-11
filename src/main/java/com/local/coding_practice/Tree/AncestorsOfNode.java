package com.local.coding_practice.Tree;

import java.util.Stack;

public class AncestorsOfNode {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(7);
        //boolean b = printAncestors(root, 7);
        boolean b = printAncestorsUsingStack(root, 3);
    }

    private static boolean printAncestors(Node root, int target) {
        if (root == null) {
            return false;
        }

        if (root.data == target) {
            return true;
        }

        if (printAncestors(root.left, target) || printAncestors(root.right, target)) {
            System.out.println(root.data);
            return true;
        }

        return false;
    }

    private static boolean printAncestorsUsingStack(Node root, int target) {
        Stack<Node> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null && root.data != target) {
                stack.push(root);
                root = root.left;
            }

            if (root != null && root.data == target) {
                break;
            }

            if (!stack.isEmpty() && stack.peek().right == null) {
                root = stack.pop();
                while (!stack.isEmpty() && stack.peek().right == root) {
                    root = stack.pop();
                }
            }

            root = !stack.isEmpty() ? stack.peek().right : null;
        }

        if (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                System.out.print(stack.pop().data + " ");
            }
            return true;
        }

        return false;
    }
}

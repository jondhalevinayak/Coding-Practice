package com.local.coding_practice.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class RightSideView {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(5);
        root.right.right = new Node(4);

        List<Integer> ans = rightSideView(root);

    }

    public static List<Integer> rightSideView(Node root) {
        List<Integer> ans = new ArrayList<>();
        ArrayDeque<Node> q = new ArrayDeque<>();
        if (root == null) {
            return ans;
        }

        q.add(root);
        while (!q.isEmpty()) {

            Node node = q.remove();
            ans.add(node.data);

            if (node.right != null) {
                q.add(root.right);

            }
        }

        return ans;
    }
}

package com.local.coding_practice.Tree;

public class SumOfLeftLeafNode {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        int sum = sumLeftLeafNodes(root);

        System.out.println("Sum is :: " + sum);
    }

    private static int sumLeftLeafNodes(TreeNode root) {
        int sum = 0;

        if(root != null){
            if(isLeaf(root.left)){
                sum += root.left.val;
            } else {
                sum += sumLeftLeafNodes(root.left);
            }

            sum += sumLeftLeafNodes(root.right);
        }

        return sum;
    }

    private static boolean isLeaf(TreeNode node) {
        if(node == null){
            return false;
        }  else return node.left == null && node.right == null;
    }
}

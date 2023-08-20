package org.example.InterViewQuestions;

public class LeetCode98ValidBST {
    private TreeNode root;

    private class TreeNode {
        private int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data){
            this.data = data;
        }
    }

    public void createBinaryTree(){
        TreeNode first = new TreeNode(5);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(6);
        TreeNode fourth = new TreeNode(1);
        TreeNode fifth = new TreeNode(8);

        root = first;
        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = fifth;
    }

    public boolean isValidBST(TreeNode root, Long min, Long max){

        if(root == null){
            return true;
        }
        if(root.data <= min || root.data >= max){
            return false;
        }
        boolean left = isValidBST(root.left, min, (long) root.data);
        if(left){
            boolean right = isValidBST(root.right, (long) root.data, max);
            return right;
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode98ValidBST lcvbst = new LeetCode98ValidBST();
        lcvbst.createBinaryTree();
        if(lcvbst.isValidBST(lcvbst.root,Long.MIN_VALUE,Long.MAX_VALUE)){
            System.out.println("This is a valid Binary Search Tree");
        } else {
            System.out.println("This is NOT a valid Binary Search Tree");
        }
    }
}

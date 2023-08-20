package org.example.BinaryTree;

import javax.swing.tree.TreeCellRenderer;
import java.util.Stack;

public class PostOrderTraversal {

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
        TreeNode first = new TreeNode(9);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);
        TreeNode sixth = new TreeNode(6);

        root = first;
        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = fifth;
        third.right = sixth;


    }
    public void postOrder(TreeNode root){
        if(root == null){  //base case
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public void postOrderIterative(TreeNode root){
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        while (current != null || !stack.isEmpty()){
            if(current != null){
                stack.push(current);
                current = current.left;
            } else {
                TreeNode temp = stack.peek().right;
                if(temp == null){
                    temp = stack.pop();
                    System.out.print(temp.data + " ");

                    while (!stack.isEmpty() && temp == stack.peek().right){
                        temp = stack.pop();
                        System.out.print(temp.data + " ");
                    }
                } else {
                    current =  temp;
                }
            }
        }

    }

    public static void main(String[] args) {
        PostOrderTraversal pot = new PostOrderTraversal();
        pot.createBinaryTree();
        System.out.print("PostOrder Traversal sequence -> ");
        //pot.postOrder(pot.root);
        pot.postOrderIterative(pot.root);
    }
}

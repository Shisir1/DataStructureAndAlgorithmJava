package org.example.BinaryTree;

import java.util.Stack;

public class InOrderTraversal {

    private TreeNode root;

    private class TreeNode{
        private TreeNode left;
        private TreeNode right;
        private int data;  //Generic type

        public TreeNode(int data){
            this.data = data;
        }
    }

    public void createBinaryTree(){
        TreeNode first = new TreeNode(9);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);

        root = first;
        first.left = second;
        first.right = third; //second <-- first --> third
        second.left = fourth;


    }

      public void inOrder(TreeNode root){
        if(root == null){
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
      }

      public void inOrderIterative(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;

        while(!stack.isEmpty() || temp != null){
            if(temp != null){
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                System.out.print(temp.data + " ");
                temp = temp.right;
            }
        }
      }

    public static void main(String[] args) {
        //Traverse order : left -> root -> right
        InOrderTraversal bt = new InOrderTraversal();
        bt.createBinaryTree();
        //bt.inOrder(bt.root);
        bt.inOrderIterative(bt.root);

    }
}

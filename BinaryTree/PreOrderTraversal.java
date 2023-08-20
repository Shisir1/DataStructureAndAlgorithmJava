package org.example.BinaryTree;

import java.util.Stack;

public class PreOrderTraversal {
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

//    public void preOrder(TreeNode root){
//        if(root == null){
//            return;
//        }
//        System.out.print(root.data + " ");
//        preOrder(root.left);
//        preOrder(root.right);
//    }
    public void preOrderIterative(){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            System.out.print(temp.data + " ");
            if(temp.right != null){
                stack.push(temp.right);
            }
            if(temp.left != null){
                stack.push(temp.left);
            }
        }
    }

    public static void main(String[] args) {
        //Traverse order --> root->left->right
        PreOrderTraversal bt = new PreOrderTraversal();
        bt.createBinaryTree();
        //bt.preOrder(bt.root);
        bt.preOrderIterative();
    }
}

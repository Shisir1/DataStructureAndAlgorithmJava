package org.example.BinaryTree;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

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
        TreeNode first = new TreeNode(4);
        TreeNode second = new TreeNode(3);
        TreeNode third = new TreeNode(7);
        TreeNode fourth = new TreeNode(5);
        TreeNode fifth = new TreeNode(8);

        root = first;
        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = fifth;
    }
    public void levelOrder(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            System.out.print(temp.data + " ");

            if(temp.left != null){
                queue.offer(temp.left);
            }
            if(temp.right != null){
                queue.offer(temp.right);
            }
        }
    }

    public int findMax(TreeNode root){
         if(root == null){ //base case
             return Integer.MIN_VALUE;
         }
         int result = root.data;
         int left = findMax(root.left);
         int right = findMax(root.right);

         if(left > result)
             result = left;
         if( right > result)
             result = right;

        return result;
    }

    public static void main(String[] args) {
        LevelOrderTraversal lot = new LevelOrderTraversal();
        lot.createBinaryTree();
        System.out.print("LevelOrderTraversal -> ");
        lot.levelOrder(lot.root);
        System.out.print("\nMaximum value in Binary Tree: " + lot.findMax(lot.root));

    }
}

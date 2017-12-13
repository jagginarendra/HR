package com.practice;

import java.util.Scanner;

class TreeNode{
    TreeNode left,right;
    int data;
    TreeNode(int data){
        this.data=data;
        left=right=null;
    }
}

public class BinarySearchTree {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        TreeNode root=null;
        while(T-->0){
            int data=sc.nextInt();
            root=insert(root,data);
        }
        int height=getHeight(root);
        System.out.println(height);
    }

    private static int getHeight(TreeNode root) {

        if(root == null)
            return -1;

        int left = 1 + getHeight(root.left);
        int right = 1+ getHeight(root.right);
        int height = left > right ? left : right;
        return height;
    }



    private static TreeNode insert(TreeNode root, int data) {
        if(root==null){
            return new TreeNode(data);
        }
        else{
            TreeNode cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }
}

package com.practice;

import java.util.Scanner;

public class LowestCommonAncestor {



    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        TreeNode root=null;
        while(T-->0){
            int data=sc.nextInt();
            root=insert(root,data);
        }

        int first = sc.nextInt();
        int second = sc.nextInt();

        traverse(first,second,root);

    }

    private static void traverse(int first, int second, TreeNode current) {

        if(first == current.data || second == current.data ){
            System.out.println(current.data);
            return;
        }
        else if( first < current.data && second > current.data
                    ||
                  second < current.data && first > current.data
                ){
            System.out.println(current.data); // we are at intersection point
            return;
        }
        else if( first < current.data && second < current.data){
            traverse(first,second,current.left);
        }
        else if(first > current.data && second > current.data){
            traverse(first,second,current.right);
        }

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

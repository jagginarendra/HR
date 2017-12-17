package com.practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BSTNode{

    public BSTNode left;
    public BSTNode right;
    public int data;

    public BSTNode(int data){
        this.data = data;
    }

}

public class LevelOrderTraversal {

    static BSTNode root;

    public static BSTNode insert(BSTNode current, int data){

        if(current== null){
            current = new BSTNode(data);
            if(root == null ) root = current;
            return current;
        }
        if(current.data > data){
            current.left = insert(current.left , data);
        }else{
            current.right = insert(current.right , data);
        }
        return current;
    }


    public static void levelOrderTraversal(BSTNode root){

        System.out.println("********Level Order Traversal************");
        Queue<BSTNode> queue = new LinkedList<>();
        queue.add(root);
        while(! queue.isEmpty()){

            BSTNode current = queue.poll();
            System.out.println(current.data);
            if(current.left != null)
                queue.add(current.left);
            if(current.right != null)
                queue.add(current.right);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        BSTNode root = null;
        while(N -- > 0){
            int temp = scanner.nextInt();
            root = insert(root,temp);
        }


        levelOrderTraversal(root);

        scanner.close();
    }

}

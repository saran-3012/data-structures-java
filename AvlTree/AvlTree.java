package AvlTree;

import java.util.ArrayList;

public class AvlTree {
    public class TreeNode {
        public int data;
        public int height;
        public TreeNode left, right;
        
        TreeNode(int data){
            this.data = data;
            this.height = 1;
            this.right = this.left = null;
        } 
    }

    protected TreeNode root;

    AvlTree(){
        this.root = null;
    }

    public TreeNode getRoot(){
        return root;
    }
    
    private int height(TreeNode node){
        return node == null ? 0 : node.height;
    }

    public int height(){
        return height(root);
    }

    private int balanceFactor(TreeNode node){
        if(node == null){
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    private TreeNode rightRotate(TreeNode node){
        TreeNode leftChild = node.left;
        TreeNode leftRightGrandChild = leftChild.right;

        leftChild.right = node;
        node.left = leftRightGrandChild;

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        leftChild.height = Math.max(height(leftChild.left), height(leftChild.right)) + 1;

        return leftChild;
    }

    private TreeNode leftRotate(TreeNode node){
        TreeNode rightChild = node.right;
        TreeNode rightLeftGrandChild = rightChild.left;

        rightChild.left = node;
        node.right = rightLeftGrandChild;

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        rightChild.height = Math.max(height(rightChild.left), height(rightChild.right)) + 1;

        return rightChild;
    }

    private TreeNode balance(TreeNode node) {
        if (balanceFactor(node) > 1) {
            if (balanceFactor(node.left) < 0) {
                node.left = leftRotate(node.left);
            }
            return rightRotate(node);
        } 
        else if (balanceFactor(node) < -1) {
            if (balanceFactor(node.right) > 0) {
                node.right = rightRotate(node.right);
            }
            return leftRotate(node);
        }
        return node;
    }

    private TreeNode insert(TreeNode node, int data){
        if(node == null){
            return new TreeNode(data);
        }

        if(data < node.data){
            node.left = insert(node.left, data);
        }
        else if(data > node.data){
            node.right = insert(node.right, data);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return balance(node);
    }

    public void insert(int data){
        root = insert(root, data);
    }

    private TreeNode remove(TreeNode node, int data){
        if(node == null){
            return node;
        }

        if(data < node.data){
            node.left = remove(node.left, data);
        }
        else if(data > node.data){
            node.right = remove(node.right, data);
        }
        else{
            if(node.left == null){
                return node.right;
            }
            else if(node.right == null){
                return node.left;
            }
            TreeNode successor = node.right;
            while(successor != null && successor.left != null){
                successor = successor.left;
            }
            node.data = successor.data;
            node.right = remove(node.right, successor.data);
        }

        if(node != null){
            node.height = Math.max(height(node.left), height(node.right)) + 1;
        }

        return balance(node);
    }

    public void remove(int data){
        root = remove(root, data);
    }

    public boolean search(int data){

        TreeNode node = root;
        while(node != null){
            if(data == node.data){
                return true;
            }
            else if(data < node.data){
                node = node.left;
            }
            else{
                node = node.right;
            }
        }
        return false;
    }

    private void traverse(TreeNode node){
        if(node == null){
            return;
        }
        traverse(node.left);
        System.out.print(node.data + " ");
        traverse(node.right);
    }

    public void print(){
        traverse(root);
        System.out.println();
    }

    private void traverse(TreeNode node, ArrayList<Integer> list){
        if(node == null){
            return;
        }
        traverse(node.left);
        list.add(node.data);
        traverse(node.right);
    }

    public ArrayList<Integer> getArrayList(){
        ArrayList<Integer> list = new ArrayList<>();
        traverse(root, list);
        return list;
    }
}

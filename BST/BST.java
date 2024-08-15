package BST;

import java.util.ArrayList;

public class BST {
    public class TreeNode {
        public int data;
        public TreeNode left, right;

        TreeNode(int data){
            this.data = data;
            this.right = this.left = null;
        }
    }

    protected TreeNode root;

    BST(){
        this.root = null;
    }

    public TreeNode getRoot(){
        return root;
    }

    private TreeNode insert(int data, TreeNode node){
        if(node == null){
            return new TreeNode(data);
        }

        if(data < node.data){
            node.left = insert(data, node.left);
        }
        else if(data > node.data){
            node.right = insert(data, node.right);
        }

        return node;
    }

    public void insert(int data){
        this.root = insert(data, root);
    }

    private TreeNode remove(int data, TreeNode node){
        if(node == null){
            return node;
        }
        if(node.data > data){
            node.left = remove(data, node.left);
        }
        else if(node.data < data){
            node.right = remove(data, node.right);
        }
        else{
            if(node.right == null){
                return node.left;
            }
            else if(node.left == null){
                return node.right;
            }

            TreeNode successor = node.right;
            while (successor != null && successor.left != null) {
                successor = successor.left;
            }
            node.data = successor.data;
            node.right = remove(successor.data, node.right);
        }
        return node;
    }

    public void remove(int data){
        this.root = remove(data, root);
    }

    public boolean search(int data){

        TreeNode temp = root;

        while (temp != null) {
            if(temp.data == data){
                return true;
            }
            else if(temp.data > data){
                temp = temp.left;
            }
            else{
                temp = temp.right;
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

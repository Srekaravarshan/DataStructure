package data_structures;

import java.util.ArrayList;

//class Main {
//    public static void main(String[] args) {
//        BinarySearchTree tree = new BinarySearchTree();
//
//        tree.insert(1);     //      1
//        tree.insert(2);     //          2
//        tree.insert(0);     //  0
//        tree.insert(6);     //              6
//        tree.insert(3);     //          3
//        tree.insert(7);     //                  7
//
//        System.out.println("ascending :");
//        tree.printAllNodes(tree.getRoot());
//
//        ArrayList<BSTNode> nodes = tree.breadthFirstSearch();
//        for(BSTNode node : nodes){
//            System.out.print(node.getData() + ", ");
//        }
//
//        System.out.println();
//
//        nodes = tree.depthFirstPreOrder();
//        System.out.println("Depth first pre order :");
//        for(BSTNode node : nodes){
//            System.out.print(node.getData() + ", ");
//        }
//        System.out.println();
//
//        nodes = tree.depthFirstPostOrder();
//        System.out.println("Depth first post order :");
//        for(BSTNode node : nodes){
//            System.out.print(node.getData() + ", ");
//        }
//        System.out.println();
//
//        nodes = tree.depthFirstInOrder();
//        System.out.println("Depth first in order :");
//        for(BSTNode node : nodes){
//            System.out.print(node.getData() + ", ");
//        }
//
////            1
////        0       2
////                    6
////                 3     7
//}
//}

public class BinarySearchTree {
    private BSTNode root = null;

    public BSTNode getRoot() {
        return root;
    }

    public void printAllNodes(BSTNode node){
        BSTNode left = node.getLeft();
        BSTNode right = node.getRight();
//        System.out.println("node: "+ node.getData());
//        if (left == null) {
//            System.out.println("null");
//        } else {
//            System.out.println("left: " + node.getLeft().getData());
//        }
//        if( right == null){
//            System.out.println("null");
//        } else {
//            System.out.println("right: " + node.getRight().getData());
//        }
        if(left == null && right == null){
            System.out.print(node.getData() + ", ");
        } else if (left == null){
            System.out.print(node.getData() + ", ");
            printAllNodes(right);
        } else if (right == null){
            printAllNodes(left);
        } else {
            printAllNodes(left);
            System.out.print(node.getData() + ", ");
            printAllNodes(right);
        }
    }

    public BSTNode find(Object data){
        if(root == null) return null;
        BSTNode node = root;

        while(node != null){

            if(data.hashCode() == node.getData().hashCode()) return node;

            if(data.hashCode() < node.getData().hashCode()) {
                if(node.getLeft() == null) return null;
                if(data.hashCode() == node.getLeft().getData().hashCode()) return node;
                else{
                    node = node.getLeft();
                }
            }

            else {
                if(node.getRight() == null) return null;
                if(data.hashCode() == node.getRight().getData().hashCode()) return node;
                else{
                    node = node.getRight();
                }
            }

        }
        return null;
    }

    public void insert(Object data){
        if(root == null) {
            root = new BSTNode(data);
        } else {
            BSTNode newNode = new BSTNode(data);
            BSTNode temp = root;
            while(true){
                if (data.hashCode() == temp.getData().hashCode()) return;
                if(data.hashCode() < temp.getData().hashCode()){
                    if(temp.getLeft() == null){
                        temp.setLeft(newNode);
                        return;
                    }
                        temp = temp.getLeft();
                } else {
                    if(temp.getRight() == null){
                        temp.setRight(newNode);
                        return;
                    }
                        temp = temp.getRight();
                }

            }
        }
    }

    public ArrayList<BSTNode> breadthFirstSearch() {

        BSTNode node = root;
        ArrayList<BSTNode> queue = new ArrayList<>();
        ArrayList<BSTNode> data = new ArrayList<>();

        queue.add(node);

        System.out.println();
        while(!queue.isEmpty()){
            node = queue.get(0);
            queue.remove(0);
            data.add(node);
            if(node.getLeft() != null) queue.add(node.getLeft());
            if(node.getRight() != null) queue.add(node.getRight());
        }
        return data;
    }

    public ArrayList<BSTNode> depthFirstPreOrder(){
        ArrayList<BSTNode> data = new ArrayList<>();
        dFPreOHelper(root, data);
        return data;
    }

    private void dFPreOHelper(BSTNode node, ArrayList<BSTNode> data){
        data.add(node);
        if(node.getLeft()!= null) dFPreOHelper(node.getLeft(), data);
        if(node.getRight()!= null) dFPreOHelper(node.getRight(), data);
    }

    public ArrayList<BSTNode> depthFirstPostOrder(){
        ArrayList<BSTNode> data = new ArrayList<>();
        dFPostOHelper(root, data);
        return data;
    }

    private void dFPostOHelper(BSTNode node, ArrayList<BSTNode> data){
        if(node.getLeft() != null) dFPostOHelper(node.getLeft(), data);
        if(node.getRight() != null) dFPostOHelper(node.getRight(), data);
        data.add(node);
    }

    public ArrayList<BSTNode> depthFirstInOrder(){
        ArrayList<BSTNode> data = new ArrayList<>();
        dFInOHelper(root, data);
        return data;
    }

    private void dFInOHelper(BSTNode node, ArrayList<BSTNode> data){
        if (node.getLeft() != null) dFInOHelper(node.getLeft(), data);
        data.add(node);
        if(node.getRight() != null) dFInOHelper(node.getRight(), data);
    }
}

class BSTNode{
    private Object data;
    private BSTNode left = null;
    private BSTNode right = null;

    public BSTNode(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public BSTNode getLeft() {
        return left;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public BSTNode getRight() {
        return right;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }
}
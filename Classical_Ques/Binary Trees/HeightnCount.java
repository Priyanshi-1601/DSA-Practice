import java.util.*;

public class HeightnCount {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    } 
    //Calculate for right and left parts with recursion
    // and return with faith with desired operation based on ques.

    public static int height(Node root) { //Height of binary tree
        if(root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh, rh) + 1;
    }

    public static int count(Node root) { //Count of nodes of BT
        if(root == null) {
            return 0;
        }
        int lCount = count(root.left);
        int rCount = count(root.right);

        return lCount + rCount + 1;
    }

    public static int sum(Node root) {//Sum of data of roots
        if(root == null) {
            return 0;
        }
        int lSum = sum(root.left);
        int rSum = sum(root.right);

        return lSum + rSum + root.data;
    }
    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        //System.out.println(height(root));
        //System.out.println(count(root));
        System.out.println(sum(root));
    }
}

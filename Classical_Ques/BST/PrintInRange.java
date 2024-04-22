public class PrintInRange {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static void printInRange(Node root, int k1, int k2) {
        if(root == null) {
            return;
        }

        if(root.data > k1 && root.data > k2) {
            printInRange(root.left, k1, k2);
        } else if(root.data < k1 && root.data < k2) {
            printInRange(root.right, k1, k2);
        } else {
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        }
    }

    public static void main(String args[]) {
        Node root = new Node(8); 
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(11);
        root.right.right.right = new Node(14);
        root.left.left.left = new Node(1);
        root.left.left.right = new Node(4);

        int k1 = 12; 
        int k2 = 14;

        printInRange(root, k1, k2);
    }
}

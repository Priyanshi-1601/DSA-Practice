public class searchKey {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static boolean search(Node root, int key) { //Function to search for a key in BST
        if(root == null) {
            return false;
        }

        if(root.data == key) {
            return true;
        }

        if(root.data > key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
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

        int key = 20; //key to search for in bst
        if(search(root, key)) {
            System.out.println("Found");
        } else {
            System.out.println("Not fount");
        }
    }
}

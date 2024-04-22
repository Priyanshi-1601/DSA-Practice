//Find the size of the largest BST in a BT

public class LargestBST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }
    static class Info { //Information passed from every node
        Boolean isBST;
        int min;
        int max;
        int size;

        Info(Boolean isBST, int min, int max, int size) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.size = size;
        }
    }

    public static int maxSize; //Keeps track of BST size

    public static Info largestBST(Node root) {
        if(root == null) {
            return new Info(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);

        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));
        int size = leftInfo.size + rightInfo.size + 1;

        //Check for current node
        if(root.data < leftInfo.max || root.data > rightInfo.min) {
            return new Info(false, min, max, size);
        }

        //Check if left and right subtrees are BST or not
        if(leftInfo.isBST && rightInfo.isBST) {
            maxSize = Math.max(maxSize, size);
            return new Info(true, min, max, size);
        }

        return new Info(false, min, max, size);  
    }

    public static void main(String args[]) {
        Node root = new Node(50); 
        root.left = new Node(30);
        root.right = new Node(60);
        root.left.left = new Node(5);
        root.left.right = new Node(20);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);

        Info info = largestBST(root);
        System.out.println(maxSize);
    }
}

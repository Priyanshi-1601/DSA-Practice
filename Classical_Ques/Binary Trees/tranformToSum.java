public class tranformToSum {
    static class Node { //Node creation
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static int transformToSum(Node root) {
        if(root == null) {
            return 0;
        }

        int leftChild = transformToSum(root.left);
        int rightChild = transformToSum(root.right);

        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;

        int value = root.data; //Stores original root data

        root.data = newLeft + leftChild + newRight + rightChild; //Upadated value of root data

        return value; //Return original value
    }

    static void preOrder(Node root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        transformToSum(root);
        preOrder(root);

        // O/P =>   27
        //        9     13
        //     0   0   0   0
    }
}

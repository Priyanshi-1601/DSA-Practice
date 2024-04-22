public class CreateBST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node create(Node root, int val) {
        //base case
        if(root == null) {
            root = new Node(val);
            return root;
        }

        //when val < root value, attach the left subtree root to current root
        if(val < root.data) {
            root.left = create(root.left, val);
        } else { //when val > root value, attach the right subtree root to current root
            root.right = create(root.right, val);
        }

        return root; //return current root
    }

    public static void inOrder(Node root) {
        if(root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        int nodesValues[] = {5,1,4,3,2,7};
        Node root = null;

        for(int i=0; i<nodesValues.length; i++) {
            root = create(root, nodesValues[i]);
        }

        inOrder(root); //to print the values of bst in ascen. order
        System.out.println();
    }
}

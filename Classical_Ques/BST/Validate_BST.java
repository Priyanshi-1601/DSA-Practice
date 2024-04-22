public class Validate_BST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }
    
    //Check if tree is BST or not --> find min from right subtree and max from left subtree and compare with root
    public static boolean isValidBST(Node root, Node min, Node max) {
        if(root == null) {
            return true;
        }

        if(min != null && root.data <= min.data) { //min < root to be valid
            return false;
        }

        if(max != null && root.data >= max.data) { //max > root to be valid
            return false;
        }

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    //Mirror a BST
    public static Node mirrorBST(Node root) {
        if(root == null) {
            return null;
        }

        Node leftMirror = mirrorBST(root.left); //Obtaining the root of left and right subtrees
        Node rightMirror = mirrorBST(root.right);

        root.left = rightMirror; //Swapping the left and right subtrees around the root
        root.right = leftMirror;

        return root;
    }

    public static void main(String args[]) {
        Node root = new Node(8); 
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(11);
        root.right.right.right = new Node(14);

        // if(isValidBST(root, null, null)) {
        //     System.out.println("Isvalid");
        // } else {
        //     System.out.println("Not valid");
        // }

        System.out.println(mirrorBST(root).data);
    }    
}

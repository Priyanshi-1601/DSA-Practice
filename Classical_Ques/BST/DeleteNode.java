public class DeleteNode {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static void inOrder(Node root) {
        if(root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static Node findInorderSuccessor(Node root) {
        while(root.left != null) {
            root = root.left;
        }
        //root.left = null
        return root;
    }   

    public static Node deleteNode(Node root, int key) {
        if(root.data > key) {
            root.left = deleteNode(root.left, key);
        } else if(root.data < key) { 
            root.right = deleteNode(root.right, key);
        } else {

            //case 1 - no children
            if(root.left == null && root.right == null) {
                return null;
            }

            //case 2 - 1 child
            if(root.left == null) { 
                return root.right;
            } else if(root.right == null) {
                return root.left;
            }

            //case 3 - 2 children
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data; //Replace parent data with child data of node
            root.right = deleteNode(root.right, IS.data); //delete inorder successor
        }

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
        root.left.left.left = new Node(1);
        root.left.left.right = new Node(4);

        int key = 3;
        inOrder(root);
        System.out.println();

        deleteNode(root, key);
        inOrder(root);
    }    
}

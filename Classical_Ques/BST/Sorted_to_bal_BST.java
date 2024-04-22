public class Sorted_to_bal_BST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    //Create a balanced BST given a sorted array
    public static Node createBST(int[] nodes, int st, int end) {
        if(st > end) {
            return null;
        }

        int mid = (st + end)/2;
        Node root = new Node(nodes[mid]);

        root.left = createBST(nodes, st, mid-1);
        root.right = createBST(nodes, mid+1, end);

        return root;
    }

    //Print the resulting balenced BST
    public static void preOrder(Node root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        int[] nodes = {3,5,6,8,10,11,12};

        Node root = createBST(nodes, 0, nodes.length-1);
        preOrder(root);
    }
}

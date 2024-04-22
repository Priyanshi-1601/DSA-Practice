//Find the kth ancestor for given node -> node - 5, k = 2

public class kthAncestor {
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

    static int kthAncestor(Node root, int n, int k) {
        if(root == null) { //base case
            return -1;
        }

        if(root.data == n) { //Check the data of root with node
            return 0;
        }

        int lDist = kthAncestor(root.left, n, k); //if value of root != node then call for left and right subtrees
        int rDist = kthAncestor(root.right, n, k);

        if(lDist == -1 && rDist == -1) {//Current node is not ancestor of given node
            return -1;
        }

        int maxDist = Math.max(lDist, rDist); //Root comes in valid path of node
        if(maxDist + 1 == k) { //Check for the level or distn.
            System.out.println(root.data);
        }

        return maxDist + 1;  //Given root is ancestor but not the kth anc. so return to previous ances.
    }
    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int n = 6, k = 1;
        kthAncestor(root, n, k);
    }
}

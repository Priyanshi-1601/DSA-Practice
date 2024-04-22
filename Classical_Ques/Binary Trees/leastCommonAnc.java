import java.util.ArrayList;

public class leastCommonAnc {
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

    static boolean findPath(Node root, int n, ArrayList<Node> path) {
        if(root == null) {
            return false;
        }

        path.add(root);

        if(root.data == n) {
            return true;
        }

        boolean foundLeft = findPath(root.left, n, path);
        boolean foundRight = findPath(root.right, n, path);

        if(foundLeft || foundRight) {
            return true;
        }

        path.remove(path.size()-1);
        return false;
    }

    public static Node lca1(Node root, int n1,int n2) {
        ArrayList<Node> path1 = new ArrayList<>(); //Stores path from root to n1
        ArrayList<Node> path2 = new ArrayList<>(); //Stores path from root to n2

        //Finding path from root to node
        findPath(root, n1, path1);
        findPath(root, n2, path2);

        //Finding last ca from both AL
        int i = 0;
        //loop till unequal nodes are encountered
        for(; i < path1.size() && i < path2.size(); i++) {
            if(path1.get(i) != path2.get(i)) {
                break;
            }
        }
        Node lca = path1.get(i-1);
        return lca;
    }

    public static Node lca2(Node root, int n1, int n2) {
        if(root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        //Finding lca in left and right subtrees
        Node leftLca = lca2(root.left, n1, n2);
        Node rigthLca = lca2(root.right, n1, n2);

        if(leftLca == null) {
            return rigthLca;
        }
        if(rigthLca == null) {
            return leftLca;
        }

        return root;
    }
    public static void main(String args[]) {
        //Creating a tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        int n1 = 6, n2 = 5;
        //System.out.println(lca1(root, n1, n2).data);
        System.out.println(lca2(root, n1, n2).data);
    }
}

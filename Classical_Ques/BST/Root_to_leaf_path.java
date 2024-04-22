import java.util.ArrayList;

public class Root_to_leaf_path {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static void printPath(ArrayList<Integer> path) { //Prints a particular path
        for(int i=0; i<path.size(); i++) {
            System.out.print(path.get(i)+"->");
        }
        System.out.println("Null");
    }

    public static void root2Leaf(Node root, ArrayList<Integer> path) {
        if(root == null) {
            return;
        }
        path.add(root.data); //adding current node to AL

        if(root.left == null & root.right == null) {//Reached leaf node -> print the path
            printPath(path);
        }
        root2Leaf(root.left, path); //left subtrees prints and deletes from path
        root2Leaf(root.right, path); //right subtrees prints and deletes from path

        path.remove(path.size()-1);
    }

    public static void main(String args[]) {
        Node root = new Node(8); 
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(11);
        root.right.right.right = new Node(14);
        // root.left.left.left = new Node(1);
        // root.left.left.right = new Node(4);

        ArrayList<Integer> path = new ArrayList<>(); //Stores path of root to leaf

        root2Leaf(root, path);
    }
}

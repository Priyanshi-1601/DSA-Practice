public class Diameter {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    } 
    public static int height(Node root) { //Height of binary tree
        if(root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh, rh) + 1;
    }

    //Approach 1 - O(n^2)
    public static int diameter(Node root) {
        if(root == null) { //base case
            return 0;
        }
        int lDiam = diameter(root.left); //left dia
        int lHt = height(root.left); //left height

        int rDiam = diameter(root.right);
        int rHt = height(root.right);

        int selfDiam = lHt + rHt + 1;

        return Math.max(selfDiam, Math.max(rDiam, lDiam));
    }
    
    static class Info {
        int diam;
        int ht;

        public Info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }
    //Approach 2 - O(n)
    public static Info diameter2(Node root) {
        if(root == null) { //base case
            return new Info(0, 0);
        }
        Info lInfo = diameter2(root.left);
        Info rInfo = diameter2(root.right);

        int diam = Math.max(Math.max(lInfo.diam, rInfo.diam), lInfo.ht + rInfo.ht + 1); // maximum diamter
        int ht = Math.max(lInfo.ht, rInfo.ht) + 1;
        
        return new Info(diam, ht);
    }

    public static void main(String args[]) {
        //Creating a tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

       System.out.println(diameter2(root).diam);
    }
}

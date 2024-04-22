import java.util.*;

public class KthLevelNodes {
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

    public static void kthLevel(Node root, int level, int k) {
        //Using preorder traversal (Approach 1)
        if (root == null) {
            return;
        }
        if(level == k) {
            System.out.print(root.data + " ");
            return;
        }

        kthLevel(root.left, level + 1, k);
        kthLevel(root.right, level + 1, k);

        //Using level order (Approach 2)
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()) {
            Node curr = q.remove();
            if(curr == null) {
                if(q.isEmpty()) {
                    break;
                } else {
                    level++;
                    q.add(null);
                }
            } else {
                if(level == k) {
                    while(curr != null) {
                        System.out.print(curr.data +" ");
                        curr = q.remove();
                    }
                } else {
                    if(curr.left != null) {
                        q.add(curr.left);
                    }
                    if(curr.right != null) {
                        q.add(curr.right);
                    }
                }
            }
        }
    }

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        kthLevel(root, 1, 3);
    }
}

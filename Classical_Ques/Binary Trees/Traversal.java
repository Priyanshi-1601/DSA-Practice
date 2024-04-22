import java.util.LinkedList;
import java.util.Queue;

import javax.naming.LinkException;

public class Traversal {
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
    static class BinaryTree {
        static int idx = -1;
        public static Node buildTree(int nodes[]) { //make tree from the array of nodes using preorder traversal
            idx++;
            if(nodes[idx] == -1) { //leaf nodes are having no left and right subtrees or empty BT
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        public static void preOrder(Node root) {
            if(root == null) {
                return;
            }
            System.out.print(root.data + " "); //prints root
            preOrder(root.left); //left subtree
            preOrder(root.right);//right subtree
        }

        public static void inOrder(Node root) {
            if(root == null) {
                return;
            }
            inOrder(root.left); //left subtree
            System.out.print(root.data + " "); //prints root
            inOrder(root.right);//right subtree
        }

        public static void postOrder(Node root) {
            if(root == null) {
                return;
            }
            postOrder(root.left); //left subtree
            postOrder(root.right);//right subtree
            System.out.print(root.data + " "); //prints root
        }

        public static void levelOrder(Node root) {
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()) {
                Node currNode = q.remove();
                if(currNode == null) {
                    if(q.isEmpty()) {
                        break;
                    } else {
                        System.out.println();
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data + " ");

                    if(currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if(currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }
    }    

    public static void main(String args[]) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

        // tree.preOrder(root); // preorder traversal
        // tree.inOrder(root); //inorder traversal
        // tree.postOrder(root); //postorder traversal
        tree.levelOrder(root); //level order traversal
        
    }
}
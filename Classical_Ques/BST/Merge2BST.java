
import java.util.ArrayList;

public class Merge2BST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static void getInorder(Node root, ArrayList<Integer> arr) {
        if(root == null) {
            return;
        }

        getInorder(root.left, arr);
        arr.add(root.data);
        getInorder(root.right, arr);
    }

    public static Node createBST(ArrayList<Integer> arr, int st, int end) {
        if(st > end) {
            return null;
        }

        int mid = (st + end)/2;
        Node root = new Node(arr.get(mid)); //creating node for the bst

        root.left = createBST(arr, st, mid-1);
        root.right = createBST(arr, mid+1, end);

        return root;
    }

    public static Node mergeBST(Node root1, Node root2) {
        //get inorder of BST1
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1, arr1);

        //get inorder of BST2
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2, arr2);

        //Merge the sequences in sorted order
        ArrayList<Integer> mergedArr = new ArrayList<>();
        int i = 0, j = 0;
        while(i < arr1.size() &&  j < arr2.size()) {
            if(arr1.get(i) <= arr2.get(j)) {
                mergedArr.add(arr1.get(i));
                i++;
            } else {
                mergedArr.add(arr2.get(j));
                j++;
            }
            
        }

        while(i < arr1.size()) {
            mergedArr.add(arr1.get(i));
            i++;
        }

        while(j < arr2.size()) {
            mergedArr.add(arr2.get(j));
            j++;
        }

        //sorted seq. -> balanced BST
        return createBST(mergedArr, 0, mergedArr.size()-1);
    }

    public static void preOrder(Node root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String args[]) {
        Node root1 = new Node(2); 
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9); 
        root2.left = new Node(3);
        root2.right = new Node(12);

        Node root = mergeBST(root1, root2);
        preOrder(root);
    }
}

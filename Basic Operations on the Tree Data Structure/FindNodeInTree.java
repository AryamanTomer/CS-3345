/* Finding a Node in the Tree:
Implement a method that traverses the tree
recursively in a depth first manner until 
the target node is found.
 */

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        // The target Node is 5
        TreeNode node = findNode(root, target);

        if(node != null) {
            System.out.println("Node " + target + " found in the tree.");
        } else {
            System.out.println("Node " + target + " not found in the tree.");
        }
    }

    public static TreeNode findNode(TreeNode root, int target) {
        if (root == null) {
            return null;
            // This is an empty tree or the node isn't found
        }
        if (root.data == target) {
            return root;
            // The Node is found at the current position;
        }
        // This is a recursive search in the left Subtree
        TreeNode leftResult = findNode(root.left, target);
        if(leftResult != null) {
            return leftResult;
            // The node is found in the left subtree
        }
        // This is a recursive search in the right Subtree
        TreeNode rightResult = findNode(root.right, target);
        if(rightResult != null) {
            return rightResult;
            // The node is found in the right subtree
        }
    }
}
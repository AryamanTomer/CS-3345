/* Level of a Node in a Binary Tree:
You can modify the existing binary tree 
class to include a method for 
finding the level of a specific node.
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

        // We will use the node with the value of 5
        TreeNode node = root.left.right;

        int level = findLevel(root, node, 1);

        System.out.println("Level of node " + node.data + " is: " + level);
    }

    public static int findLevel(TreeNode root, TreeNode node, int level) {
        if(root == null) {
            return 0;
        }
        if(root == node) {
            return level;
        }

        // Check in Left Subtree
        int leftLevel = findLevel(root.left, node, level + 1);
        if(leftLevel != 0) {
            return leftLevel;
            // The Node was found in the left subtree;
        }

        // Checking in the right subtree;

        int rightLevel = findLevel(root.right, node, level + 1);
        return rightLevel;
    }
}
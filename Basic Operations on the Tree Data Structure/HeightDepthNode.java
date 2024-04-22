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
        // This node has a value of 5
        TreeNode node = root.left.right;

        int dept = findDepth(root, node, 0);
        int height = findHeight(node);

        System.out.println("Depth of node " + node.data + " is: " + depth);
        System.out.println("Height of node" + node.data + " is: " + height);
    }
    // This method recursively finds the depth of a given node in the tree relative to the root node
    // The findDepth method takes the root node of the tree, targetNode, and its depth as its parameters.
    // Traverses the tree recursively in a depth first manner.
    public static int findDepth(TreeNode root, TreeNode node, int depth) {
        if(root == null) {
            return -1;
            // The Node was not found
        }

        if(root == node) {
            return depth;
            // The Node was found and we return the depth
        }

        int leftDepth = findDepth(root.left, node, depth + 1);
        if(leftDepth != -1) {
            return leftDepth;
            // The Node was found in the left subtree
        }

        int rightDepth = findDepth(root.right, node, depth + 1);
        if(rightDepth != -1) {
            return rightDepth;
        }
        // The node was found in the right subtree
    }

    public static int findHeight(TreeNode node) {
        if (node == null) {
            return -1;
            //The height of null node is -1
        }

        int leftHeight = findHeight(node.left);
        int rightHeight = findHeight(node.right);

        // The height of the node is the maximum of leftHeight and rightHeight + 1 for the node itself
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
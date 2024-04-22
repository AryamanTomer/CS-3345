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

        int height = findHeight(root);
        System.out.println("Heigh of the binary tree is: " + height);
    }
    /*  In this method, we first check if the root is null.
    If it is, then the height of that subtree is 0;
    If it is not null, we find the height of the left and right subtress using the same
    find Height method.
    We will calculate the height of the current node as
    the max of the height of the left & right subtrees + 1.
    This continues until we reach the leaf nodes where the height is calculated as 0.
    The height of the entire tree is returned from the main method.
    */
    public static int findHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        else {
            int leftHeight = findHeight(root.left);
            int rightHeight = findHeight(root.right);

            // Height of the tree is the maximum of leftHeight and rightHeight, plus 1 for the root
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
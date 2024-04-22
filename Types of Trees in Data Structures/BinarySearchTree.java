/* Binary Search Tree (BST):

A binary search tree is a binary tree
in which the left child of a node contains
only values less than the node's value, and the 
right child contains only values greater than
the node's value

*/

class BinarySearchTree {
    TreeNode root;
    
    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(int data) {
        root = insertRecursive(root, data);
    }

    private TreeNode insertRecursive(TreeNode root, int data) {
        if (root == null) {
            root = new TreeNode(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertRecursive(root.left, data);
        } else if (data > root.data) {
            root.right = insertRecursive(root.right, data);
        }
    }

    return root;
}
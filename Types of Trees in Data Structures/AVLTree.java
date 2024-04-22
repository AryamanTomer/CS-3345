/* AVL Tree:  
An AVL tree is a self-balancing binary
search tree in which the heights of the 
two child subtrees of any node differ
by at most one.
*/
class AVLNode {
    int data;
    AVLNode left;
    AVLNode right;
    int height;

    public AVLNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.height = 1;
    }
}

public class AVLTree {
    private AVLNode root;

    public AVLTree() {
        this.root = null;
    }

    // Getting the height of the node
    private int height(AVLNode node) {
        if(node == null) {
            return 0;
        }
        return node.height;
    }

    // Calculating the balance factor of the node
    private int balanceFactor(AVLNode node) {
        if(node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    // The Right rotation subtree is rooted with y
    private AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        // Perform the rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        // Return the new root
        return x;
    }

    // The Left rotation subtree is rooted with x
    private AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        // Perform the rotation
        y.left = x;
        x.right = T2;

        // Update the heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Return the new root
        return y;
    }

    // Insert a node
    public void insert(int data) {
        root = insertNode(root, data);
    }

    private AVLNode insertNode(AVLNode node, int data) {
        // Perform the normal BST insertion
        if(node == null) {
            return new AVLNode(data);
        }

        if(data < node.data) {
            node.left = insertNode(node.left, data);
        }
        else if(data > node.data) {
            node.right = insertNode(node.right, data);
        }
        // The Duplicate Keys are not Allowed
        else {
            return node;
        }


        // Update the height of this ancestor node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Getting the balance factor of this ancestor node to check if the node became unbalanced
        int balance = balanceFactor(node);
        
        // If this node becomes unbalances, then there are 4 cases

        // Left Left Case
        if(balance > 1 && data < node.left.data) {
            return rightRotate(node);
        }

        // Right Right Case
        if(balance < -1 && data > node.right.data) {
            return leftRotate(node);
        }

        // Left Right Case
        if(balance > 1 && data > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if(balance < -1 && data < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        // If the tree is balanced, return the unchanged node
        return node;
    }

    // Delete a node
    public void delete(int data) {
        root = deleteNode(root, data);
    }

    private AVLNode deleteNode(AVLNode root, int data) {
        // Perform the standard BST delete
        if(root == null) {
            return root;
        }

        if(data < root.data) {
            root.left = deleteNode(root.left, data);
        }
        else if(data > root.data) {
            root.right = deleteNode(root.right, data);
        }
        else {
            // Node with only one child or no child
            if ((root.left == null) || (root.right == null)) {
                AVLNode temp = null;
                if(temp == root.left) {
                    temp = root.right;
                }
                else {
                    temp = root.left;
                }

                // No child case
                if (temp == null) {
                    temp = root;
                    root = null;
                } else {  // One child case
                    root = temp; // Copy the contents of the non-empty child
                }
            } else {
                // Node with 2 children: Get the inorder successor
                // The smallest in the right subtree
                AVLNode temp = minValueNode(root.right);

                // Copy the inorder successor's data to this temporary node
                root.data = temp.data;

                // Delete the inorder successor
                root.right = deleteNode(root.right, temp.data);
            }
        }

        // If the tree had only 1 node then return
        if(root == null) {
            return root;
        }

        // Update the height of the current node
        root.height = Math.max(height(root.left), height(root.right)) + 1;

        // Get the balance factor of this node to check whether this node became unbalanced
        int balance = balanceFactor(root);

        // If this node becomes unbalanced, then there are four cases

        // Left Left Case
        if(balance > 1 && balanceFactor(root.left) >= 0) {
            return rightRotate(root);
        }

        // Left Right Case
        if(balance > 1 && balanceFactor(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Right Case
        if(balance < -1 && balanceFactor(root.right) <= 0) {
            return leftRotate(root);
        }

        // Right Left Case
        if(balance < -1 && balanceFactor(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    // Find the node with the minimum value
    private AVLNode minValueNode(AVLNode node) {
        AVLNode current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    // Preorder traversal
    private void preOrder(AVLNode node) {
        if(node != null) {
            System.out.println(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // Print the tree
    public void printTree() {
        preOrder(root);
        System.out.println();
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);

        tree.printTree();

        tree.delete(30);

        tree.printTree();
    }
}
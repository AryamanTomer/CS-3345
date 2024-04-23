public class BinarySearchNode<T> extends BinaryNode<T> {
    public BinarySearchNode(T value) {
        super(value);
    }

    public BinarySearchNode<T> left() {
        return (BinarySearchNode<T>) getLeftTree();
    }

    public BinarySearchNode<T> right() {
        return (BinarySearchNode<T>) getRightTree();
    }

    public T front() {
        return getNodeValue();
    }

    public T back() {
        BinarySearchNode<T> current = this;
        while (current.right() != null) {
            current = current.right();
        }
        return current.getNodeValue();
    }

    public boolean find(T value) {
        BinarySearchNode<T> current = this;
        while (current != null) {
            int cmp = ((Comparable<T>) value).compareTo(current.getNodeValue());
            if (cmp == 0) {
                return true;
            } else if (cmp < 0) {
                current = current.left();
            } else {
                current = current.right();
            }
        }
        return false;
    }

    public void clear() {
        setLeftTree(null);
        setRightTree(null);
    }

    public boolean insert(T value) {
        BinarySearchNode<T> current = this;
        while (true) {
            int cmp = ((Comparable<T>) value).compareTo(current.getNodeValue());
            if (cmp == 0) {
                return false; // Value already exists
            } else if (cmp < 0) {
                if (current.left() == null) {
                    current.setLeftTree(new BinarySearchNode<>(value));
                    return true;
                }
                current = current.left();
            } else {
                if (current.right() == null) {
                    current.setRightTree(new BinarySearchNode<>(value));
                    return true;
                }
                current = current.right();
            }
        }
    }

    public boolean erase(T value, BinarySearchNode<T>[] root) {
        BinarySearchNode<T> parent = null;
        BinarySearchNode<T> current = this;

        // Find the node to erase and its parent
        while (current != null) {
            int cmp = ((Comparable<T>) value).compareTo(current.getNodeValue());
            if (cmp == 0) {
                break; // Node found
            } else {
                parent = current;
                if (cmp < 0) {
                    current = current.left();
                } else {
                    current = current.right();
                }
            }
        }

        // If node not found
        if (current == null) {
            return false;
        }

        // Node to erase has no children
        if (current.left() == null && current.right() == null) {
            if (parent == null) {
                root[0] = null;
            } else if (current == parent.left()) {
                parent.setLeftTree(null);
            } else {
                parent.setRightTree(null);
            }
            return true;
        }

        // Node to erase has one child
        if (current.left() == null || current.right() == null) {
            BinarySearchNode<T> child = (current.left() != null) ? current.left() : current.right();
            if (parent == null) {
                root[0] = child;
            } else if (current == parent.left()) {
                parent.setLeftTree(child);
            } else {
                parent.setRightTree(child);
            }
            return true;
        }

        // Node to erase has two children
        BinarySearchNode<T> successor = current.right();
        BinarySearchNode<T> successorParent = current;
        while (successor.left() != null) {
            successorParent = successor;
            successor = successor.left();
        }
        current.setNodeValue(successor.getNodeValue());
        if (successor == successorParent.left()) {
            successorParent.setLeftTree(successor.right());
        } else {
            successorParent.setRightTree(successor.right());
        }
        return true;
    }
}

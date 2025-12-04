public class BinarySearchTree<E extends Comparable<E>> {
    // not linear data structure
    // trees have internal nodes (1 + children) and leaf nodes (0 children)
    // the degree of a noce is the number of subtrees
    // tree's height is the maximum distance from the root to a leaf node

    private TreeNode<E> root;
    private int size;

    public BinarySearchTree() {
        clear();
    }

    public void clear() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public void add(E data) {
        if (data == null) {
            throw new IllegalStateException("data must not be null");
        }
        root = add(data, root);
        size++;
    }

    private TreeNode<E> add(E data, TreeNode<E> startNode) {
        if (startNode == null) {
            startNode = new TreeNode<>(data);
        } else if (data.compareTo(startNode.data) <= 0) {
            startNode.left = add(data, startNode.left);
        } else {
            startNode.right = add(data, startNode.right);
        }
        return startNode;
    }

    // TODO : Delete this method later. It is for learning purposes
    public int count() {
        return count(root);
    }

    private int count(TreeNode<E> startNode) {
        if (startNode == null) {
            return 0;
        } else {
            return 1 + count(startNode.left) + count(startNode.right);
        }
    }

    private static class TreeNode<T> {
        public T data;
        public TreeNode<T> left; // one child
        public TreeNode<T> right; // one child

        public TreeNode(T data) {
            this.data = data;
            left = right = null;
        }
    }
}


/**
 * public class BinarySearchTree<E extends Comparable<E>> {
 *
 *     private TreeNode<E> root;
 *     private int size;
 *
 *     public BinarySearchTree() {
 *         clear();
 *     }
 *
 *     public void clear() {
 *         root = null;
 *         size = 0;
 *     }
 *
 *     public int size() {
 *         return size;
 *     }
 *
 *     public void add(E data) {
 *         if (data == null) {
 *             throw new IllegalStateException("data must not be null");
 *         }
 *         root = add(data, root);
 *         size++;
 *     }
 *
 *     private TreeNode<E> add(E data, TreeNode<E> startNode) {
 *         if (startNode == null) {
 *             startNode = new TreeNode<>(data);
 *         } else if (data.compareTo(startNode.data) <= 0) {
 *             startNode.left = add(data, startNode.left);
 *         } else {
 *             startNode.right = add(data, startNode.right);
 *         }
 *         return startNode;
 *     }
 *
 *     //TODO: remove later, just for pedagogy
 *     public int count() {
 *         return count(root);
 *     }
 *
 *     private int count(TreeNode<E> startNode) {
 *         if (startNode == null) {
 *             return 0;
 *         } else {
 *             return 1 + count(startNode.left) + count(startNode.right);
 *         }
 *     }
 *
 *     private static class TreeNode<T> {
 *         public T data;
 *         public TreeNode<T> left;
 *         public TreeNode<T> right;
 *
 *         public TreeNode(T data) {
 *             this.data = data;
 *             left = right = null;
 *         }
 *     }
 *
 * }
 */
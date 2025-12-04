import java.util.Arrays;

/**
 * @param <K> the type of keys maintained by this TreeMap; must implement Comparable.
 * @param <V> the type of values associated with the keys.
 *
 * @author Anna Scribner
 * @version May 22, 2025
 * <p>
 * A TreeMap is a generic implementation of a binary search tree that stores key-value pairs.
 * Keys must implement the Comparable interface to maintain the ordering of the tree.
 * The TreeMap supports operations such as insertion, updating, retrieval, and checking for the presence of keys.
 */
public class TreeMap<K extends Comparable<K>, V> implements TreeMapInterface<K, V> {
    /**
     * Represents the root node of the binary search tree used internally by the TreeMap.
     */
    private TreeMapNode<K, V> overallRoot;
    /**
     * Represents the count of key-value pairs currently stored in the TreeMap.
     */
    private int size;

    /**
     * Constructs an empty TreeMap.
     */
    public TreeMap() {
        clear();
    }

    /**
     * {@inheritDoc}
     */
    public void clear() {
        overallRoot = null;
        size = 0;
    }

    /**
     * Adds a key-value pair to the TreeMap. If the key already exists, its associated value is updated.
     * If the key does not exist, a new key-value pair is inserted.
     *
     * @param key   the key to be added or updated in the TreeMap; must not be null.
     * @param value the value to be associated with the specified key; can be null.
     */
    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("You cannot add key null");
        }
        overallRoot = put(key, overallRoot, value);
    }

    /**
     * Recursively inserts or updates a key-value pair in the TreeMap. If the key does not exist in the tree,
     * a new node is created and inserted. If the key already exists, its associated value is updated.
     *
     * @param key   the key to be added or updated; must not be null.
     * @param root  the root of the current subtree where the key-value pair is to be added or updated.
     * @param value the value to be associated with the specified key; can be null.
     *
     * @return the potentially updated root node of the current subtree.
     */
    private TreeMapNode<K, V> put(K key, TreeMapNode<K, V> root, V value) {
        if (root == null) {
            size++;
            return new TreeMapNode<>(key, value);
        } else {
            int compare = key.compareTo(root.key);
            if (compare == 0) {
                root.data = value;
            } else if (compare < 0) {
                root.left = put(key, root.left, value);
            } else {
                root.right = put(key, root.right, value);
            }
            return root;
        }
    }

    /**
     * {@inheritDoc}
     */
    public int size() {
        return size;
    }

    /**
     * {@inheritDoc}
     */
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        return get(key, overallRoot);
    }

    /**
     * Retrieves the value associated with the specified key from the provided subtree.
     *
     * @param key  the key to search for in the subtree; must not be null.
     * @param root the root node of the current subtree to begin the search.
     *
     * @return the value associated with the specified key if found, or null if the key does not exist in the subtree.
     */
    private V get(K key, TreeMapNode<K, V> root) {
        if (root == null) {
            return null;
        }
        V value;
        if (key.compareTo(root.key) == 0) {
            value = root.data;
        } else if (key.compareTo(root.key) < 0) {
            value = get(key, root.left);

        } else {
            value = get(key, root.right);
        }
        return value;
    }

    /**
     * {@inheritDoc}
     */
    public boolean containsKey(K key) {
        return containsKey(overallRoot, key);
    }

    /**
     * Recursively searches for the presence of a specified key in the given subtree rooted at the provided node.
     *
     * @param root the root node of the current subtree where the key is to be searched; can be null.
     * @param key  the key to search for; must not be null and must implement Comparable.
     *
     * @return true if the key exists in the subtree rooted at the provided node, false otherwise.
     */
    private boolean containsKey(TreeMapNode<K, V> root, K key) {
        if (root == null) {
            return false;
        } else {
            int compare = key.compareTo(root.key);
            if (compare == 0) {
                return true;
            } else if (compare < 0) {
                return containsKey(root.left, key);
            } else {
                return containsKey(root.right, key);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    public K[] toKeyArray(K[] keys) {
        if (keys.length < size) {
            keys = Arrays.copyOf(keys, size);
        }
        toKeyArray(keys, overallRoot, 0);

        if (keys.length > size) {
            keys[size] = null;
        }
        return keys;
    }

    /**
     * Recursively populates the provided array with the keys from the subtree rooted at the specified node,
     * in order, starting from the provided index.
     *
     * @param keys the array to store the keys into; must not be null.
     * @param root the root of the subtree to traverse; can be null.
     * @param i    the starting index at which to insert keys into the array.
     *
     * @return the updated index after processing all keys in the subtree.
     */
    private int toKeyArray(K[] keys, TreeMapNode<K, V> root, int i) {
        if (root != null) {
            i = toKeyArray(keys, root.left, i);
            keys[i++] = root.key;
            i = toKeyArray(keys, root.right, i);
        }
        return i;
    }

    /**
     * Represents a single node in a binary search tree structure used within a TreeMap.
     * Each node holds a key-value pair and references to left and right child nodes.
     *
     * @param <K> the type of keys maintained by this TreeMapNode must implement Comparable.
     * @param <V> the type of values associated with the keys.
     */
    private static class TreeMapNode<K, V> {
        /**
         * The key associated with this node in the binary search tree.
         */
        public K key;
        /**
         * Represents the data or information stored in conjunction with the node's key.
         */
        public V data;
        /**
         * Represents the left child node of the current TreeMapNode in a binary search tree.
         */
        public TreeMapNode<K, V> left;
        /**
         * Represents the right child node of the current TreeMapNode in a binary search tree.
         */
        public TreeMapNode<K, V> right;

        /**
         * Constructs a new TreeMapNode with the specified key and associated data.
         * The left and right child references of the node are initialized to null.
         *
         * @param key  the key associated with this node; must not be null and must implement Comparable.
         * @param data the value associated with the specified key; can be null.
         */
        public TreeMapNode(K key, V data) {
            this(key, data, null, null);
        }

        /**
         * Constructs a new TreeMapNode with the specified key, associated data, and references to child nodes.
         *
         * @param key   the key associated with this node; must not be null and must implement Comparable.
         * @param data  the value associated with the specified key; can be null.
         * @param left  the left child node; can be null if the node has no left child.
         * @param right the right child node; can be null if the node has no right child.
         */
        public TreeMapNode(K key, V data, TreeMapNode<K, V> left,
                           TreeMapNode<K, V> right) {
            this.key = key;
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}



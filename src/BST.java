package src;

import java.util.ArrayList;

public class BST<K extends Comparable<K>, V> {
    private Node root;

    private class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public void put(K key, V val) {
        Node newNode = new Node(key, val);
        if (root == null) {
            root = newNode;
            return;
        }
        Node current = root;
        while (true) {
            if (key.compareTo(current.key) < 0) {
                if (current.left == null) {
                    current.left = newNode;
                    break;
                }
                current = current.left;
            } else if (key.compareTo(current.key) > 0) {
                if (current.right == null) {
                    current.right = newNode;
                    break;
                }
                current = current.right;
            } else {
                current.val = val;
                break;
            }
        }
    }

    public V get(K key) {
        Node current = root;
        while (current != null) {
            if (key.compareTo(current.key) < 0) {
                current = current.left;
            } else if (key.compareTo(current.key) > 0) {
                current = current.right;
            } else {
                return current.val;
            }
        }
        return null;
    }

    public Iterable<K> iterator() {
        ArrayList<K> keys = new ArrayList<>();
        inorder(root, keys);
        return keys;
    }

    private void inorder(Node x, ArrayList<K> keys) {
        if (x == null) return;
        inorder(x.left, keys);
        keys.add(x.key);
        inorder(x.right, keys);
    }
}

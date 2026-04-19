package com.dsa.bst;

public class BinarySearchTree {
    private BSTNode root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int value) {
        root = insertHelper(root, value);
    }

    private BSTNode insertHelper(BSTNode node, int value) {
        if (node == null) {
            return new BSTNode(value);
        }
        if (value < node.data) {
            node.leftChild = insertHelper(node.leftChild, value);
        } else if (value > node.data) {
            node.rightChild = insertHelper(node.rightChild, value);
        }
        return node;
    }

    public int height() {
        return heightHelper(root);
    }

    private int heightHelper(BSTNode node) {
        if (node == null) {
            return -1;
        }
        int leftHeight = heightHelper(node.leftChild);
        int rightHeight = heightHelper(node.rightChild);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int findSmallest() {
        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }
        BSTNode current = root;
        while (current.leftChild != null) {
            current = current.leftChild;
        }
        return current.data;
    }

    public int findLargest() {
        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }
        BSTNode current = root;
        while (current.rightChild != null) {
            current = current.rightChild;
        }
        return current.data;
    }

    public void delete(int value) {
        root = deleteHelper(root, value);
    }

    private BSTNode deleteHelper(BSTNode node, int value) {
        if (node == null) {
            return null;
        }

        if (value < node.data) {
            node.leftChild = deleteHelper(node.leftChild, value);
        } else if (value > node.data) {
            node.rightChild = deleteHelper(node.rightChild, value);
        } else {

            if (node.leftChild == null && node.rightChild == null) {
                return null;
            }

            if (node.leftChild == null) {
                return node.rightChild;
            }
            if (node.rightChild == null) {
                return node.leftChild;
            }

            BSTNode predecessor = findPredecessor(node.leftChild);

            node.data = predecessor.data;

            node.leftChild = deleteHelper(node.leftChild, predecessor.data);
        }
        return node;
    }

    private BSTNode findPredecessor(BSTNode node) {
        BSTNode current = node;
        while (current.rightChild != null) {
            current = current.rightChild;
        }
        return current;
    }

    public void inorder() {
        inorderHelper(root);
        System.out.println();
    }

    private void inorderHelper(BSTNode node) {
        if (node != null) {
            inorderHelper(node.leftChild);
            System.out.print(node.data + " ");
            inorderHelper(node.rightChild);
        }
    }
}

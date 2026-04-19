package com.dsa.tree;

public class BinaryTree {
	private BTNode root;
	
	public BinaryTree() {
		root = null;
	}
	
	public void createTree01() {
		BTNode n1 = new BTNode(5);
		BTNode n2 = new BTNode(1);
		BTNode n3 = new BTNode(3);
		BTNode n4 = new BTNode(2);
		
		n1.leftChild = n2;
		n1.rightChild = n3;
		n2.leftChild = n4;
		
		root = n1;
	}
	
	private int callCount;

	private void printUsingInorder(BTNode root) {
		++callCount;

		if (root == null) {
			return;
		}
		
		printUsingInorder(root.leftChild);
		System.out.println(root.data);
		printUsingInorder(root.rightChild);
	}
	
	public void printUsingInorder() {
		callCount = 0;
		printUsingInorder(root);
		System.out.println("Call count is " + callCount);
	}

    // 1. Print tree contents using preorder
    public void printUsingPreorder() {
        printPreorderHelper(root);
    }

    private void printPreorderHelper(BTNode node) {
        if (node == null) return;
        System.out.println(node.data);
        printPreorderHelper(node.leftChild);
        printPreorderHelper(node.rightChild);
    }

    // 1. Print tree contents using postorder
    public void printUsingPostorder() {
        printPostorderHelper(root);
    }

    private void printPostorderHelper(BTNode node) {
        if (node == null) return;
        printPostorderHelper(node.leftChild);
        printPostorderHelper(node.rightChild);
        System.out.println(node.data);
    }

    // 2. Return number of nodes in a binary tree
    public int CountNodes() {
        return countNodesHelper(root);
    }

    private int countNodesHelper(BTNode node) {
        if (node == null) return 0;
        return 1 + countNodesHelper(node.leftChild) + countNodesHelper(node.rightChild);
    }

    // 3. Return number of leaf nodes in a binary tree
    public int CountLeafNodes() {
        return countLeafNodesHelper(root);
    }

    private int countLeafNodesHelper(BTNode node) {
        if (node == null) return 0;
        // Leaf condition: A node with no left and no right child
        if (node.leftChild == null && node.rightChild == null) return 1;
        return countLeafNodesHelper(node.leftChild) + countLeafNodesHelper(node.rightChild);
    }

    // 4. Return number of nodes in a binary tree, with specific value in it
    public int CountNodesWithValue(int value) {
        return countNodesWithValueHelper(root, value);
    }

    private int countNodesWithValueHelper(BTNode node, int value) {
        if (node == null) return 0;
        int matchCount = (node.data == value) ? 1 : 0;
        return matchCount 
             + countNodesWithValueHelper(node.leftChild, value) 
             + countNodesWithValueHelper(node.rightChild, value);
    }
}

package com.dsa.tree;

public class TreeApp {

	public static void main(String[] args) {
		BinaryTree bt01 = new BinaryTree();
		
		bt01.createTree01();
		
        System.out.println("====== Tree Traversals ======");
        System.out.println("\nInorder:");
		bt01.printUsingInorder();

        System.out.println("\nPreorder:");
        bt01.printUsingPreorder();

        System.out.println("\nPostorder:");
        bt01.printUsingPostorder();

        System.out.println("\n====== Tree Operations ======");
        System.out.println("Total Nodes: " + bt01.CountNodes());
        System.out.println("Total Leaf Nodes: " + bt01.CountLeafNodes());
        System.out.println("Count of nodes with value 5: " + bt01.CountNodesWithValue(5));
        System.out.println("Count of nodes with value 2: " + bt01.CountNodesWithValue(2));
	}

}

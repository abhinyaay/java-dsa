package com.dsa.bst;

public class Program {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        int[] elements = { 50, 30, 70, 20, 40, 60, 80 };
        System.out.println("Inserting elements to create the BST: 50, 30, 70, 20, 40, 60, 80");
        for (int el : elements) {
            bst.insert(el);
        }

        System.out.print("Current Tree (Inorder Traversal): ");
        bst.inorder();
        System.out.println("-------------------------------------------------");
        System.out.println("1. Find Height of the Binary Search Tree:");
        System.out.println("   Height of the tree is: " + bst.height());
        System.out.println("-------------------------------------------------");

        System.out.println("2. Find Smallest Element:");
        System.out.println("   Smallest element in the BST is: " + bst.findSmallest());
        System.out.println("   Time Complexity of findSmallest(): O(h), where h is the height of the tree.");
        System.out.println("   (O(log n) for a balanced tree, O(n) for a skewed tree)");
        System.out.println("-------------------------------------------------");

        System.out.println("3. Find Largest Element:");
        System.out.println("   Largest element in the BST is: " + bst.findLargest());
        System.out.println("   Time Complexity of findLargest(): O(h), where h is the height of the tree.");
        System.out.println("   (O(log n) for a balanced tree, O(n) for a skewed tree)");
        System.out.println("-------------------------------------------------");

        System.out.println("4. Delete in BST using Inorder Predecessor:");

        System.out.println("\n   a. Deleting node (50) which has TWO children...");
        System.out.println("      (This will replace 50 with its inorder predecessor, which is 40)");
        bst.delete(50);
        System.out.print("      Inorder Traversal after deleting 50: ");
        bst.inorder();

        System.out.println("\n   b. Deleting node (20) which is a LEAF node...");
        bst.delete(20);
        System.out.print("      Inorder Traversal after deleting 20: ");
        bst.inorder();

        System.out.println("\n   c. Deleting node (70) and showing tree...");
        bst.delete(70);
        System.out.print("      Inorder Traversal after deleting 70: ");
        bst.inorder();

        System.out.println("-------------------------------------------------");
    }
}

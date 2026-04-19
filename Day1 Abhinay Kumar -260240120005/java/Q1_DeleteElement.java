import java.util.Arrays;

public class Q1_DeleteElement {

    // Function to delete element from specified position in given array
    public static int deleteFromPosition(int[] arr, int n, int pos) {
        if (pos < 0 || pos >= n) {
            System.out.println("Invalid position");
            return n;
        }
        for (int i = pos; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }
        return n - 1;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 0, 0}; // Output array with extra capacity
        int logicalSize = 5;
        
        System.out.println("Original array: " + Arrays.toString(Arrays.copyOf(arr, logicalSize)));
        System.out.println("Original logical size: " + logicalSize);
        
        int deletePos = 2; // Delete element '30'
        logicalSize = deleteFromPosition(arr, logicalSize, deletePos);
        
        System.out.println("\nAfter deleting element at position " + deletePos + ":");
        System.out.println("Updated array: " + Arrays.toString(Arrays.copyOf(arr, logicalSize)));
        System.out.println("Updated logical size: " + logicalSize);
    }
}

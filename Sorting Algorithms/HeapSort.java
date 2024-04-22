public class HeapSort {
    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Unsorted Array:");
        printArray(array);

        heapSort(array);

        System.out.println("\nSorted Array:");
        printArray(array);
    }

    static void heapSort(int[] array) {
        int n = array.length;

        // Build a max heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // One by one extract an element from the heap
        for (int i = n - 1; i > 0; i--) {
            // Move the current root (largest element) to the end
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Call max heapify on the reduced heap
            heapify(array, i, 0);
        }
        
    }

    static void heapify(int[] array, int n, int i) {
        int largest = i; // Initialize the largest as the root
        int leftChild = 2 * i + 1; // Left child
        int rightChild = 2 * i + 2; // Right child

        // If the left child is larger than the root
        if (leftChild < n && array[leftChild] > array[largest]) {
            largest = leftChild;
        }

        // If the right child is larger than the largest so far
        if (rightChild < n && array[rightChild] > array[largest]) {
            largest = rightChild;
        }

        // If the largest is not the root
        if (largest != i) {
            // Swap the root with the largest element
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(array, n, largest);
        }
        printArray(array);
    }

    static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}

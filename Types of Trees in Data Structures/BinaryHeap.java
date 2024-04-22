/* Heap (Binary Heap):
A binary heap is a complete binary tree in which every
parent node has a value less than or equal to its children
or greater than or equal to its children (for a min heap).
 */

class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        heap = new int[capacity];
    }

    public void insert(int data) {
        if(size == capacity) {
            System.out.println("Heap is full!");
            return;
        }

        size++;
        int index = size - 1;
        heap[index] = data;

            // Heapify

        while (index != 0 && heap[parent(index)] > heap[index]) {
        swap(index, parent(index));
        index = parents(index);
        }
    } 

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}

}


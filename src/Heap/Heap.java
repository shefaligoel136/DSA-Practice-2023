package Heap;

public class Heap {

    int arr[];
    int count;
    int capacity;

    String heap_type;

    Heap(int capacity, String heap_type) {
        this.capacity = capacity;
        this.heap_type = heap_type;
        this.count = 0;
        this.arr = new int[capacity];
    }

    int parent(int i) {
        if (i <= 0 || i >= this.count) {
            return -1;
        }
        return (i - 1) / 2;
    }

    int leftChild(int i) {
        if (i <= 0 || i >= this.count) {
            return -1;
        }
        return 2 * i + 1;
    }

    int rightChild(int i) {
        if (i <= 0 || i >= this.count) {
            return -1;
        }
        return 2 * i + 2;
    }

    int getMaxMin() {
        return arr[0];
    }

    int currentSize() {
        return count;
    }

    void insertKey(int x) {
        if (count == capacity) {
            System.out.println("\nOverflow: Could not insertKey\n");
            return;
        }

        count++;
        int i = count - 1;
        arr[i] = x;

        while (i > 0 && (heap_type == "min" ? arr[parent(i)] > arr[i] : arr[parent(i)] < arr[i])) {
            int temp = arr[i];
            arr[i] = arr[parent(i)];
            arr[parent(i)] = temp;
            i = parent(i);
        }
    }

    int extractMax() {
        if(count == 0){
            System.out.println("Heap is Empty!");
            return Integer.MAX_VALUE;
        }

        int max = getMaxMin();

        if (count == 1) {
            count--;
            return max;
        }

        arr[0] = arr[count -1];
        count--;

        MaxHeapify(0);

        return max;
    }

    void MaxHeapify(int i){
        // percolate down
        int l = leftChild(i);
        int r = rightChild(i);

        int max = i;

        if(l != -1 && arr[i]<arr[l]){
            max = l;
        }

        if(r != -1 && arr[i]<arr[max]){
            max = r;
        }

        if(max != i){
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
            MaxHeapify(max);
        }

    }

    void MinHeapify(int i){
        // percolate down
        int l = leftChild(i);
        int r = rightChild(i);

        int min = i;

        if(l != -1 && arr[i]>arr[l]){
            min = l;
        }

        if(r != -1 && arr[i]>arr[min]){
            min = r;
        }

        if(min != i){
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
            MinHeapify(min);
        }
    }

    // Increases value of key at
    // index 'i' to new_val.
    void increaseKey(int i, int newVal) {
        arr[i] = newVal;
        while (i != 0 && arr[parent(i)] < arr[i]) {
            int temp = arr[i];
            arr[i] = arr[parent(i)];
            arr[parent(i)] = temp;
            i = parent(i);
        }
    }

    // Deletes a key at given index i.
    void deleteKeyMax(int i) {
        // It increases the value of the key
        // to infinity and then removes
        // the maximum value.
        increaseKey(i, Integer.MAX_VALUE);
        extractMax();
    }

    public static void main(String[] args) {
        // Assuming the maximum size of the heap to be 15.
        Heap h = new Heap(15, "max");

        // Asking the user to input the keys:
        int k, i, n = 6;
        System.out.println("Entered 6 keys:- 3, 10, 12, 8, 2, 14 \n");
        h.insertKey(3);
        h.insertKey(10);
        h.insertKey(12);
        h.insertKey(8);
        h.insertKey(2);
        h.insertKey(14);

        // Printing the current size
        // of the heap.
        System.out.println("The current size of the heap is "
                + h.currentSize() + "\n");

        // Printing the root element which is
        // actually the maximum element.
        System.out.println("The current maximum element is " + h.getMaxMin()
                + "\n");

        // Deleting key at index 2.
        h.deleteKeyMax(2);

        // Printing the size of the heap
        // after deletion.
        System.out.println("The current size of the heap is "
                + h.currentSize() + "\n");

        // Inserting 2 new keys into the heap.
        h.insertKey(15);
        h.insertKey(5);
        System.out.println("The current size of the heap is "
                + h.currentSize() + "\n");
        System.out.println("The current maximum element is " + h.getMaxMin()
                + "\n");
    }

}

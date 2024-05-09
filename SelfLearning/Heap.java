package Algo2023.SelfLearning;
import java.util.Arrays;

public class Heap {
    int[] val;
    int heapSize;

    Heap(int[] arr, int len) {
        this.val = new int[len];
        this.heapSize = len;
        System.arraycopy(arr, 0, this.val, 0, len);
    }

    private void swap(int i, int j) {
        int tmp = this.val[i];
        this.val[i] = this.val[j];
        this.val[j] = tmp;
    }

    public void maxHeapify(int idx) {
        int l = 2 * idx + 1, r = 2 * idx + 2;
        int largest = ( l < this.heapSize && this.val[l] > this.val[idx] ) ? l : idx;
        largest = ( r < this.heapSize &&  this.val[r] > this.val[largest] ) ? r : largest;
        if ( largest != idx ) {
            swap(idx, largest);
            maxHeapify(largest);
        }
    }

    public void minHeapify(int idx) {
        int l = 2 * idx + 1, r = 2 * idx + 2;
        int smallest = ( l < this.heapSize && this.val[l] < this.val[idx] ) ? l : idx;
        smallest = ( r < this.heapSize &&  this.val[r] < this.val[smallest] ) ? r : smallest;
        if ( smallest != idx ) {
            swap(idx, smallest);
            minHeapify(smallest);
        }
    }

    public void buildMaxHeap() {
        for ( int i = this.heapSize / 2; i >= 0; i-- ) {
            maxHeapify(i);
        }
    }

    public void buildMinHeap() {
        for ( int i = this.heapSize / 2; i >= 0; i-- ) {
            minHeapify(i);
        }
    }

    public void heapSort() {
        int tmp_len = this.heapSize;
        for ( int i = this.heapSize - 1; i >= 1; i-- ) {
            swap(0, i);
            this.heapSize--;
            maxHeapify(0);
        }
        this.heapSize = tmp_len;
    }

    public void heapSort(int low, int high) {
        int tmp_len = this.heapSize;
        System.out.println(Arrays.toString(this.val) + " " + heapSize);
        for ( int i = this.heapSize - 1; i >= 1; i-- ) {
            swap(0, i);
            this.heapSize--;
            maxHeapify(0);
        }
        this.heapSize = tmp_len;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.val);
    }

    public static void main(String[] args) {
        Heap h = new Heap(new int[]{142, 543, 123, 65, 453, 879, 572, 434, 111, 242, 811, 102}, 12);
//        System.out.println(h);
        h.buildMaxHeap();
        System.out.println(h);
        h.heapSort(100, 600);
        System.out.println(h);

    }


}

package Heaps;

public class HeapImple {

	int[] heap;
	int count;
	int capacity;

	public HeapImple(int capacity) {
		this.capacity = capacity;
		heap = new int[capacity];
		this.count = 0;
	}

	public int getParent(int i) {
		if (i < 0 || i >= count)
			return -1;
		return (i - 1) / 2;
	}

	public int leftChild(int i) {
		int left = 2 * i + 1;
		if (left >= count)
			return -1;
		return left;
	}

	public int rightChild(int i) {
		int right = 2 * i + 2;
		if (right >= count)
			return -1;
		return right;
	}

	public int getMax() {
		if (count == 0)
			return -1;
		return heap[0];
	}

	public void percolateDown(int i) {
		int left = leftChild(i);
		int right = rightChild(i);
		int max, temp;

		if (i < 0)
			return;

		if (left != -1 && heap[left] > heap[i])
			max = left;
		else
			max = i;
		if (right != -1 && heap[right] > heap[max])
			max = right;

		if (max != i) {
			temp = heap[max];
			heap[max] = heap[i];
			heap[i] = temp;
			percolateDown(max);
		}
	}

	public int deleteMax() {
		if (count == 0)
			return -1;
		int data = heap[0];
		heap[0] = heap[count - 1];
		count--;
		percolateDown(0);
		return data;
	}

	public void insert(int data) {
		int i;
		if (count == capacity)
			resizeHeap();
		count++;
		i = count - 1;
		while (i > 0 && data > heap[(i - 1) / 2]) {
			heap[i] = heap[(i - 1) / 2];
			i = (i - 1) / 2;
		}
		heap[i] = data;
	}

	public void resizeHeap() {
		int[] old_heap = new int[capacity];
		System.arraycopy(heap, 0, old_heap, 0, count - 1);
		heap = new int[capacity * 2];
		if (heap == null) {
			System.out.println("Memory Error");
			return;
		}
		for (int i = 0; i < capacity; i++)
			heap[i] = old_heap[i];

		capacity = capacity * 2;
		old_heap = null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HeapImple h = new HeapImple(10);
		h.insert(8);
		h.insert(4);
		h.insert(1);
		h.insert(6);
		h.insert(2);
		h.insert(9);
		System.out.println(h.getMax());
		h.deleteMax();
		System.out.println(h.getMax());
		h.deleteMax();
		System.out.println(h.getMax());
		h.deleteMax();
		System.out.println(h.getMax());
		h.deleteMax();
		System.out.println(h.getMax());
		h.deleteMax();
		System.out.println(h.getMax());
	}

}

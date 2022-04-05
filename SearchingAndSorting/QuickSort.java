package SearchingAndSorting;

public class QuickSort {

	void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int pi = partition(arr, low, high);
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}
	}

	void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	int partition(int[] arr, int low, int high) {

		int pivot = arr[high];
		int i = (low - 1);

		for (int j = low; j <= high - 1; j++) {

			if (arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);
		return (i + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickSort m = new QuickSort();
		int[] A = { 2, 5, 67, 8, 6 };
		m.quickSort(A, 0, A.length - 1);
		for (int i = 0; i < 5; i++)
			System.out.println(A[i]);
	}

}

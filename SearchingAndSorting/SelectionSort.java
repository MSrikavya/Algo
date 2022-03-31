package SearchingAndSorting;

public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] A = { 2, 5, 67, 8, 6 };
		selectionSort(A, 5);
		for (int i = 0; i < 5; i++)
			System.out.println(A[i]);
		BinarySearch(A, 0, 4, 6);

	}

	public static void selectionSort(int[] A, int n) {
		int a;
		if (n <= 0)
			return;
		else {

			int max_index = n - 1;

			for (int i = 0; i < n - 1; i++) {
				if (A[i] < A[max_index]) {
					a = A[i];
					A[i] = A[max_index];
					A[max_index] = a;
					break;
				}
			}
			selectionSort(A, n - 1);
		}
	}

	public static void BinarySearch(int[] A, int min, int max, int num) {
		if (min > max)
			System.out.println("Not Found");
		else {
			if (num == A[(min + max) / 2])
				System.out.println((min + max) / 2);
			else if (num < A[(min + max) / 2])
				BinarySearch(A, min, (min + max) / 2 + 1, num);
			else if (num > A[(min + max) / 2])
				BinarySearch(A, (min + max) / 2 + 1, max, num);
		}
	}
}

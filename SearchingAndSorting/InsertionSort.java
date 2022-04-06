package SearchingAndSorting;

public class InsertionSort {

	public void insertionSort(int n, int[] A) {
		int temp, j;
		for (int i = 1; i < n; i++) {
			int val = A[i];
			for (j = i - 1; j >= 0 && A[j] > val; j--) {
				A[j + 1] = A[j];
			}
			A[j + 1] = val;
		}
	}

	public void print(int n, int[] A) {
		for (int i = 0; i < n; i++)
			System.out.println(A[i]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsertionSort obj = new InsertionSort();

		int A[] = { 12, 5, 7, 3, 9, 1, 4 };

		obj.insertionSort(A.length, A);
		obj.print(A.length, A);
	}
}

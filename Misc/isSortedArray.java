package Misc;

import java.util.Scanner;

public class isSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter array size");
		int n = scan.nextInt();
		int array[] = new int[n];
		System.out.println("Enter array values");
		for (int i = 0; i < n; i++) {
			array[i] = scan.nextInt();
		}
		scan.close();

		if (isSortedCheck(array, n) == true)
			System.out.println("Yes");
		else
			System.out.println("No");
	}

	public static boolean isSortedCheck(int[] A, int n) {

		if (n == 1)
			return true;
		else {
			if (A[n - 1] < A[n - 2])
				return false;
			else
				return isSortedCheck(A, n - 1);
		}
	}

}

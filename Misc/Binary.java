package Misc;

import java.util.Arrays;
import java.util.Scanner;

public class Binary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter array size");
		int n = scan.nextInt();
		int array[] = new int[n];
		scan.close();

		binary(array, n);
		System.out.println("K-array Strings");
		kArray(array, 3, n);
	}

	public static void binary(int[] A, int n) {
		if (n < 1)
			System.out.println(Arrays.toString(A));
		else {
			A[n - 1] = 0;
			binary(A, n - 1);
			A[n - 1] = 1;
			binary(A, n - 1);
		}
	}

	public static void kArray(int[] A, int k, int n) {
		if (k < 1)
			System.out.println(Arrays.toString(A));
		else {
			for (int i = 0; i < n; i++) {
				A[k - 1] = i;
				kArray(A, k - 1, n);
			}
		}
	}

}

package Misc;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out.println("Enter any number");
		int n = s.nextInt();

		System.out.println(factorial(n));

	}

	public static int factorial(int n) {

		if (n == 0 || n == 1) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}

	}
}

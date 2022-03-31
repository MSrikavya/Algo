package Misc;

import java.util.Scanner;

public class Fabinocci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter a value");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for (int i = 0; i < n; i++)
			System.out.print(fabinocci(i) + " ");

	}

	public static int fabinocci(int n) {
		if (n == 0 || n == 1)
			return n;
		else {
			return fabinocci(n - 1) + fabinocci(n - 2);
		}
	}

}

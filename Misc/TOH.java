package Misc;

import java.util.Scanner;

public class TOH {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter number of towers");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println("Enter source tower");
		char src = s.next().charAt(0);
		System.out.println("Enter destination tower");
		char dest = s.next().charAt(0);

		TowersOfHanoi(n, src, dest, 'C');

	}

	public static void TowersOfHanoi(int n, char src, char dest, char Aux) {
		if (n == 1) {
			System.out.println("Move disc from " + src + " to " + dest);
			return;
		} else {
			TowersOfHanoi(n - 1, src, Aux, dest);
			System.out.println("Move disc from " + src + " to " + dest);
			TowersOfHanoi(n - 1, Aux, dest, src);
		}
	}

}

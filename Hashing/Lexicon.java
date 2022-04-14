package Hashing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Lexicon {

	int[] hashtable;
	char[] A;
	int size, end_index;

	/**
	 * public Lexicon(int size) { hashtable = new int[size]; this.size = size;
	 * 
	 * for (int i = 0; i < size; i++) hashtable[i] = -1;
	 * 
	 * A = new char[15 * size]; }
	 **/

	public int hashfunc(String s) {
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			sum = sum + (s.charAt(i));
		}
		return (sum - 2) % size;
	}

	public void insert(String s) {
		int i;
		int hash = hashfunc(s);

		if (hashtable[hash] != -1)
			for (int j = 0; j < size; j++) {
				int hash_2 = (hash + j * j) % size;
				if (hashtable[hash_2] == -1) {
					hash = hash_2 % size;
					break;
				}
			}

		for (i = 0; i < s.length(); i++) {
			A[end_index + i] = s.charAt(i);
		}
		A[end_index + i] = '\0';
		hashtable[hash] = end_index;
		end_index = end_index + i + 1;
	}

	public void create(int size) {
		hashtable = new int[size];
		this.size = size;

		for (int i = 0; i < size; i++)
			hashtable[i] = -1;

		A = new char[15 * size];
	}

	public void delete(String s) {
		int index = getIndex(s);
		int start_index;
		if (index != -1) {
			start_index = hashtable[index];
			hashtable[index] = -1;
			for (int i = start_index, j = 0; j < s.length(); i++, j++)
				A[i] = '*';
			System.out.println(s + " deleted from slot " + index);
		}
	}

	public int getIndex(String s) {
		int index = hashfunc(s);
		if (index == -1)
			return -1;
		int h = 1;
		while (hashtable[index] != -1 && !isString(hashtable[index], s)) {
			index = (index + h * h) % size;
			h++;
		}
		if (hashtable[index] != -1 && isString(hashtable[index], s))
			return index;
		else
			return -1;
	}

	public void search(String s) {
		int index = getIndex(s);
		if (index != -1)
			System.out.println(s + " found at slot " + index);
		else
			System.out.println(s + " not found");
	}

	public boolean isString(int index, String s) {
		boolean isFound = true;
		int i, j;
		for (i = index, j = 0; j < s.length(); i++, j++) {
			if (A[i] != s.charAt(j))
				isFound = false;
		}
		if (isFound == true && A[i] == '\0')
			return true;
		else
			return false;
	}

	public void print() {
		for (int i = 0; i < 11; i++) {
			if (hashtable[i] == -1)
				System.out.println(i + ": ");
			else
				System.out.println(i + ": " + hashtable[i]);
		}

		System.out.println();
		for (int i = 0; i < end_index; i++) {
			if (A[i] == '\0')
				System.out.print("\\");
			else
				System.out.print(A[i]);
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Lexicon l = new Lexicon();
		File file = new File(args[0]);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String st;
		while ((st = br.readLine()) != null) {
			String[] splitStr = st.split("\\s+");
			switch (splitStr[0]) {
			case "10":
				l.insert(splitStr[1]);
				continue;
			case "11":
				l.delete(splitStr[1]);
				continue;
			case "12":
				l.search(splitStr[1]);
				continue;
			case "13":
				l.print();
				continue;
			case "14":
				l.create(Integer.parseInt(splitStr[1]));
				continue;
			default:
			}
		}
	}
}

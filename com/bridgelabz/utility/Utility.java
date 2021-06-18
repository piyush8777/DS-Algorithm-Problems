package com.bridgelabz.utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Utility {
	static Scanner sc = new Scanner(System.in);
	static PrintWriter out = new PrintWriter(
			new OutputStreamWriter(System.out), true);
	public static boolean binarySearch(String[] strArray, String str) {

		int low = 0;
		boolean isPresent = false;
		int high = strArray.length - 1;
		int mid = high / 2;
		while (high >= low) {
			if (strArray[mid] == str) {
				isPresent = true;
				break;
			} 
			else if (strArray[mid] > str) {
				high = mid - 1;
				mid = (low + high) / 2;
			} 
			else if (strArray[mid] < str) {
				low = mid + 1;
				mid = (low + high) / 2;
			}
		}
		return isPresent;
	}
	public static long elapsedTime(long start) {
		long end = System.currentTimeMillis();
		return end - start;
	}

public static <T extends Comparable<T>> boolean binarySearch(T arr[], T str) {
	int low = 0;
	boolean isPresent = false;
	int high = arr.length - 1;
	int mid = high / 2;
	while (high >= low) {
		if (arr[mid].compareTo(str) == 0) {
			isPresent = true;
			break;
		} else if (arr[mid].compareTo(str) < 0) {
			low = mid + 1;
			mid = (low + high) / 2;
		} else if (arr[mid].compareTo(str) > 0) {
			high = mid - 1;
			mid = (low + high) / 2;
		}
	}
	return isPresent;
}
public static void insertionSort(int arr[]) {

	for (int i = 1; i < arr.length; i++) {
		int key = arr[i];
		int j = i - 1;
		while (j >= 0 && arr[j] > key) {
			arr[j + 1] = arr[j];
			j--;
		}
		arr[j + 1] = key;
	}

}
public static <T extends Comparable<T>> void insertionSort(T arr[]) {

	for (int i = 1; i < arr.length; i++) {
		T key = arr[i];
		int j = i - 1;
		while (j >= 0 && arr[j].compareTo(key) > 0) {
			arr[j + 1] = arr[j];
			j--;
		}
		arr[j + 1] = key;
	}

}
public static void bubbleSort(int arr[]) {

	int temp;
	for (int i = 0; i < arr.length - 1; i++) {
		for (int j = 0; j < arr.length - 1; j++) {
			if (arr[j] > arr[j + 1]) {
				temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
			}
		}
	}

}

public static <T extends Comparable<T>> void bubbleSort(T arr[]) {
	T temp;
	for (int i = 0; i < arr.length - 1; i++) {
		for (int j = 0; j < arr.length - 1; j++) {
			if (arr[j].compareTo(arr[j + 1]) > 0) {
				temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
			}
		}
	}
}
public static boolean isAnagram(String str1, String str2) {
	boolean isAnagram = true;
	char arr1[] = str1.toLowerCase().toCharArray();
	char arr2[] = str2.toLowerCase().toCharArray();
	Arrays.sort(arr1);
	Arrays.sort(arr2);
	if (arr1.length != arr2.length) {
		return false;
	} else {
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] == arr2[i]) {
				isAnagram = true;
			} else {
				isAnagram = false;
				break;
			}

		}
	}
	return isAnagram;
}
public static boolean isPrime(int number) {

	// condition to check if no less than two
	if (number < 2) {
		return false;
	}

	// for loop to for checking prime no
	for (int factor = 2; factor * factor <= number; factor++) {
		// if factor divides evenly into n, n is not prime, so break out of
		// loop
		if (number % factor == 0) {
			return false;

		}
	} // End of for loop
	return true;
}

public static void printPrimes() {
	int number = 0;
	for (number = 0; number <= 1000; number++) {
		if (isPrime(number)) {
			System.out.println(number);
		}
	}
}

public static void printPrimePalindrome() {
	for (int number = 2; number < 1000; number++) {
		if (isPrime(number)) {
			if (isPalindrome(Integer.toString(number))) {
				System.out.println(number);
			}
		}
	}
}
public static void primeAnagram() {
	ArrayList<String> primes = new ArrayList<>();
	for (int i = 0; i < 1000; i++) {
		if (isPrime(i)) {
			primes.add(String.valueOf(i));
		}
	}
	for (int i = 0; i < primes.size(); i++) {
		for (int j = i + 1; j < primes.size(); j++) {
			if (isAnagram(primes.get(i), primes.get(j))) {
				System.out.println(primes.get(i) + " " + primes.get(j)
						+ " are anagram");
			}
		}
	}

}
public static boolean isPalindrome(String str) {
	char arr[] = str.toLowerCase().toCharArray();
	boolean isPalindrome = true;
	int j = arr.length - 1;
	for (int i = 0; i < arr.length; i++, j--) {
		if (arr[i] == arr[j]) {
			isPalindrome = true;
		} else {
			isPalindrome = false;
			return isPalindrome;
		}
	}
	return isPalindrome;

}
public static String[][] primeAnagramInRange() {
	int primeArray[][] = {};
	int k = 0;
	String primeAnagram[][] = new String[10][100];
	primeArray = findPrimeInRange(primeArray);

	for (int i = 0; i < 10; i++) {
		for (int j = 0; j < 99 && primeArray[i][j]!=0; j++) {
			
				for (int x = j + 1; x < 100&&primeArray[i][x]!=0; x++) {
					
					if (isAnagram(String.valueOf(primeArray[i][j]),
							String.valueOf(primeArray[i][x]))) {
						//System.out.println(primeArray[i][j]+" "+primeArray[i][x]);
						primeAnagram[i][k] = String
								.valueOf(primeArray[i][j]);
						k++;
						primeAnagram[i][k] = String
								.valueOf(primeArray[i][x]);
						k++;
					}
				}
				
				
		}
		k = 0;
	}
	return primeAnagram;
}
public static int[][] findPrimeInRange(int[][] primeArray) {
	primeArray = new int[10][100];
	int number = 2;
	int k = 0;
	for (int i = 0; i < 10; i++) {
		for (int j = 0; j < 100 && number < ((i + 1) * 100); j++) {
			if (isPrime(number)) {
				primeArray[i][k] = number;
				k++;
			}
			number++;
		}
		k = 0;
	}
	return primeArray;
}
public static void findNumber(int first, int last) {
	int middle = (first + last) / 2;
	if (first < last) {
		System.out.println("Is your number between " + first + " and "+ middle + " [y/n]:");
		char choice = sc.next().charAt(0);
		if (choice == 'y' || choice == 'Y') {
			findNumber(first, middle);

		} else {
			findNumber(middle + 1, last);
		}
	} else if (first == last) {
		System.out.println("Number is " + last);
	}
}
/**
 * @param filePath
 * @return String array This method read words into String array from given
 *         filePath and return it
 */
public static String[] readFile(String filePath) {
	String words[] = {};
	ArrayList<String> lines = new ArrayList<String>();
	String line, temp[] = {};
	BufferedReader bufferedReader;
	FileReader file;
	int index = 0;
	try {
		file = new FileReader(filePath);
		bufferedReader = new BufferedReader(file);
		while ((line = bufferedReader.readLine()) != null) {
			temp = line.split(",|\\s");
			for (int i = 0; i < temp.length; i++) {
				lines.add(temp[i]);

			}
		}
		words = lines.toArray(new String[lines.size()]);
		bufferedReader.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return words;
}
/**
 * @param word
 * @param filePath
 *            This method appends word on filePath
 */
public static void appendFile(String word, String filePath) {

	try {
		FileWriter writer = new FileWriter(filePath, true);
		PrintWriter out = new PrintWriter(writer);
		out.println(word);
		out.close();
		writer.close();
	} catch (FileNotFoundException e) {

		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public static void writeFile(String word[], String filePath) {

	try {
		FileWriter writer = new FileWriter(filePath, false);
		PrintWriter out = new PrintWriter(writer);
		for (int i = 0; i < word.length; i++) {
			out.write(word[i] + " ");
		}
		out.close();
		writer.close();
	} catch (FileNotFoundException e) {

		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}

// ******************************************************
// Numbers.java
//
// Demonstrates insertionSort on an array of integers.
// Uses Integer objects (not primitive int) so it can be
// sorted by a method expecting Comparable[].
// ******************************************************

import java.util.Scanner;

public class Numbers
{
	// --------------------------------------------
	// Reads in an array of integers, sorts them,
	// then prints them in sorted order.
	// --------------------------------------------
	public static void main (String[] args)
	{
		Integer[] intList;
		int size;

		Scanner scan = new Scanner(System.in);

		System.out.print("\nHow many integers do you want to sort? ");
		size = scan.nextInt();

		intList = new Integer[size];

		System.out.println("\nEnter the numbers...");
		for (int i = 0; i < size; i++)
		{
			// Autoboxing converts int -> Integer automatically
			intList[i] = scan.nextInt();
		}

		// Sort (insertionSort is modified to sort in descending order)
		Sorting.insertionSort(intList);

		System.out.println("\nYour numbers in sorted order...");
		for (int i = 0; i < size; i++)
			System.out.print(intList[i] + " ");
		System.out.println();
	}
}

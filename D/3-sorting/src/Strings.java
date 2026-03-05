// ******************************************************
// Strings.java
//
// Demonstrates insertionSort on an array of Strings.
// Sort order is determined by Sorting.insertionSort.
// ******************************************************

import java.util.Scanner;

public class Strings
{
    // --------------------------------------------
    // Reads in an array of strings, sorts them,
    // then prints them in sorted order.
    // --------------------------------------------
    public static void main (String[] args)
    {
        String[] strList;
        int size;

        Scanner scan = new Scanner(System.in);

        System.out.print("\nHow many strings do you want to sort? ");
        size = scan.nextInt();
        scan.nextLine(); // consume newline

        strList = new String[size];

        System.out.println("\nEnter the strings...");
        for (int i = 0; i < size; i++)
            strList[i] = scan.nextLine();

        Sorting.insertionSort(strList);

        System.out.println("\nYour strings in sorted order...");
        for (int i = 0; i < size; i++)
            System.out.print(strList[i] + " ");
        System.out.println();
    }
}

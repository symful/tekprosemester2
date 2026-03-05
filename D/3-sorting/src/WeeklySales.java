// *************************************************************
// WeeklySales.java
//
// Sorts the sales staff in descending order by sales.
// (Optional) Reads salespeople from standard input.
// ************************************************************
import java.util.Scanner;

public class WeeklySales {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("How many salespeople? ");
        int count = scan.nextInt();

        Salesperson[] salesStaff = new Salesperson[count];

        System.out.println(
            "Enter each salesperson as: firstName lastName totalSales"
        );
        for (int i = 0; i < count; i++) {
            String first = scan.next();
            String last = scan.next();
            int sales = scan.nextInt();

            salesStaff[i] = new Salesperson(first, last, sales);
        }

        // insertionSort has been modified to sort in descending order.
        Sorting.insertionSort(salesStaff);

        System.out.println("\nRanking of Sales for the Week\n");

        for (Salesperson s : salesStaff) System.out.println(s);
    }
}

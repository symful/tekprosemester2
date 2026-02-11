## Code
```java
// DataTypes.java
import java.math.BigInteger;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            solve(scanner);
        }

        scanner.close();
    }

    public static void solve(Scanner scanner) {
        final BigInteger n = scanner.nextBigInteger();
        final byte[] byteArray = n.toByteArray();
        final int byteSize = byteArray.length;

        final boolean canBeStoredInsideByte = byteSize <= Byte.BYTES;
        final boolean canBeStoredInsideShort = byteSize <= Short.BYTES;
        final boolean canBeStoredInsideInt = byteSize <= Integer.BYTES;
        final boolean canBeStoredInsideLong = byteSize <= Long.BYTES;
        final boolean cannotBeStoredAnywhere =
            !canBeStoredInsideByte &&
            !canBeStoredInsideShort &&
            !canBeStoredInsideInt &&
            !canBeStoredInsideLong;

        System.out.print(n.toString() + " ");

        if (cannotBeStoredAnywhere) {
            System.out.println("can’t be fitted anywhere");
        } else {
            System.out.println("can be fitted in:");

            if (canBeStoredInsideByte) {
                System.out.println("    * byte");
            }
            if (canBeStoredInsideShort) {
                System.out.println("    * short");
            }
            if (canBeStoredInsideInt) {
                System.out.println("    * int");
            }
            if (canBeStoredInsideLong) {
                System.out.println("    * long");
            }
        }
    }
}

```

## Input
```sh
5
-150
150000
1500000000
213333333333333333333333333333333333
-1000
```

## Output
```sh
-150 can be fitted in:
    * short
    * int
    * long
150000 can be fitted in:
    * int
    * long
1500000000 can be fitted in:
    * int
    * long
213333333333333333333333333333333333 can’t be fitted anywhere
-1000 can be fitted in:
    * short
    * int
    * long
```

## Penjelasan Solusi
Kode menggunakan BigInteger agar dapat menampung nilai yang lebih besar daripada tipe data primitif seperti byte, short, int, dan long. Ini memungkinkan kita untuk mengecek apakah suatu nilai dapat disimpan dalam tipe data tersebut tanpa kehilangan informasi dan tanpa try-catch. Setelah itu, kode mengecek apakah nilai tersebut dapat disimpan dalam tipe data byte, short, int, atau long menggunakan properti BYTES dari setiap class wrapper primitive dan melakukan komparasi terhadap nilai bytes yang dimiliki oleh nilai yang ditampung pada BigInteger.

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

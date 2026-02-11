import java.math.BigInteger;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            solve(scanner);
        }

        scanner.close();
    }

    public static void solve(Scanner scanner) {
        BigInteger n = scanner.nextBigInteger();
        byte[] byteArray = n.toByteArray();
        int byteSize = byteArray.length;

        System.out.println(byteSize);
    }
}

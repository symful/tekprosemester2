/**
 * MASALAH (Kode Awal - DEADLOCK):
 * - Thread 1: kunci acc1 => tunggu => kunci acc2
 * - Thread 2: kunci acc2 => tunggu => kunci acc1
 * -> Keduanya saling menunggu selamanya (deadlock)
 *
 * SOLUSI:
 * Gunakan urutan kunci yang sama untuk semua thread.
 * Kedua thread mengunci acc1 terlebih dahulu, baru acc2.
 */

/**
 * Kelas Account merepresentasikan akun bank dengan saldo awal.
 */
class Account {

    int balance = 150;
}

public class TransferFulus {

    public static void main(String[] args) throws InterruptedException {
        Account acc1 = new Account();
        Account acc2 = new Account();

        System.out.println("=== STATUS AWAL ===");
        System.out.println("Saldo acc1: " + acc1.balance);
        System.out.println("Saldo acc2: " + acc2.balance);
        System.out.println();

        /**
         * Urutan kunci: acc1 terlebih dahulu, baru acc2.
         * Menggunakan urutan yang SAMA dengan Thread 2 untuk mencegah deadlock.
         */
        Thread t1 = new Thread(() -> {
            // Blok synchronized untuk mengunci acc1.
            // Hanya satu thread dapat memasuki blok ini pada satu waktu.
            synchronized (acc1) {
                System.out.println("Thread-1: Telah mengunci acc1");

                // Thread.sleep() mensimulasikan operasi yang memakan waktu.
                // Exception handling diperlukan karena Thread.sleep()
                // dapat melempar InterruptedException.
                try {
                    Thread.sleep(100);
                } catch (Exception e) {}

                // Mengunci acc2 setelah acc1.
                // Urutan kunci yang sama (acc1 -> acc2) mencegah deadlock.
                synchronized (acc2) {
                    System.out.println("Thread-1: Telah mengunci acc2");
                    acc2.balance += acc1.balance;
                    System.out.println(
                        "Thread-1: Penjumlahan selesai, acc2 = " + acc2.balance
                    );
                }
            }
        });

        /**
         * Urutan kunci: acc1 terlebih dahulu, baru acc2.
         * Sama dengan Thread 1 untuk mencegah deadlock.
         */
        Thread t2 = new Thread(() -> {
            synchronized (acc1) {
                System.out.println("Thread-2: Telah mengunci acc1");
                try {
                    Thread.sleep(100);
                } catch (Exception e) {}

                synchronized (acc2) {
                    System.out.println("Thread-2: Telah mengunci acc2");
                    acc1.balance += acc2.balance;
                    System.out.println(
                        "Thread-2: Penjumlahan selesai, acc1 = " + acc1.balance
                    );
                }
            }
        });

        System.out.println("=== MEMULAI THREAD ===\n");

        // Memulai kedua thread secara paralel.
        t1.start();
        t2.start();

        // Method join() memastikan main thread menunggu
        // semua thread selesai sebelum melanjutkan.
        t1.join();
        t2.join();

        System.out.println("\n=== HASIL AKHIR ===");
        System.out.println("Saldo Akhir acc1: " + acc1.balance);
        System.out.println("Saldo Akhir acc2: " + acc2.balance);

        /**
         * Penjelasan Hasil:
         * - acc1 awal = 150, acc2 awal = 150
         * - Thread 1: acc2 = 150 + 150 = 300
         * - Thread 2: acc1 = 150 + 300 = 450
         * - HASIL AKHIR: acc1 = 450, acc2 = 300
         */
    }
}

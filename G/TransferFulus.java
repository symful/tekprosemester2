// Kelas Account merepresentasikan akun bank dengan saldo
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

        // Thread 1: Transfer dari acc1 ke acc2
        // Menggunakan urutan kunci yang sama (selalu acc1 dulu, baru acc2)
        Thread t1 = new Thread(() -> {
            synchronized (acc1) {
                System.out.println("Thread-1: Telah mengunci acc1");
                try { Thread.sleep(100); } catch (Exception e) {}
                synchronized (acc2) {
                    System.out.println("Thread-1: Telah mengunci acc2");
                    acc2.balance += acc1.balance;
                    System.out.println("Thread-1: Penjumlahan selesai, acc2 = " + acc2.balance);
                }
            }
        });

        // Thread 2: Transfer dari acc2 ke acc1
        // Menggunakan urutan kunci yang SAMA dengan Thread 1 untuk mencegah deadlock
        Thread t2 = new Thread(() -> {
            synchronized (acc1) {
                System.out.println("Thread-2: Telah mengunci acc1");
                try { Thread.sleep(100); } catch (Exception e) {}
                synchronized (acc2) {
                    System.out.println("Thread-2: Telah mengunci acc2");
                    acc1.balance += acc2.balance;
                    System.out.println("Thread-2: Penjumlahan selesai, acc1 = " + acc1.balance);
                }
            }
        });

        System.out.println("=== MEMULAI THREAD ===\n");
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("\n=== HASIL AKHIR ===");
        System.out.println("Saldo Akhir acc1: " + acc1.balance);
        System.out.println("Saldo Akhir acc2: " + acc2.balance);
    }
}
/**
 * MASALAH (Kode Awal - RACE CONDITION):
 * - Banyak thread mengakses chickenStock secara bersamaan.
 * - Operasi cek (if chickenStock > 0) dan kurangi (chickenStock--)
 *   tidak bersifat atomik.
 * - Hasil akhir stok bisa salah karena interleaving thread.
 *
 * SOLUSI:
 * Tambahkan keyword synchronized pada method serveCustomer()
 * sehingga hanya satu thread dapat mengeksekusinya pada satu waktu.
 */

/**
 * Kelas Resto menyimpan stok ayam dengan method untuk melayani pelanggan.
 * Method serveCustomer() disynchronized untuk menghindari race condition.
 */
class Resto {

    private int chickenStock = 100;

    /**
     * Method untuk melayani pelanggan yang membeli ayam.
     * Keyword synchronized memastikan hanya satu thread yang dapat
     * mengeksekusi method ini pada satu waktu, sehingga mencegah
     * race condition saat mengakses chickenStock.
     */
    public synchronized void serveCustomer(String cashierName) {
        if (chickenStock > 0) {
            // Thread.sleep() mensimulasikan operasi yang memakan waktu.
            // Exception handling diperlukan karena Thread.sleep()
            // dapat melempar InterruptedException.
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {}

            chickenStock--;
            System.out.println(
                cashierName +
                    " berhasil menjual 1 ayam. Sisa stok: " +
                    chickenStock
            );
        } else {
            System.out.println(cashierName + " gagal: Stok Habis!");
        }
    }

    /**
     * Method untuk mendapatkan sisa stok ayam.
     */
    public int getRemainingStock() {
        return chickenStock;
    }
}

public class RestoAyam {

    public static void main(String[] args) throws InterruptedException {
        Resto ayamJuicyLuicyGallagher = new Resto();

        /**
         * Task untuk setiap kasir. Setiap kasir akan menjual
         * ayam sebanyak 40 kali secara loop.
         */
        Runnable task = () -> {
            for (int i = 0; i < 40; i++) {
                ayamJuicyLuicyGallagher.serveCustomer(
                    Thread.currentThread().getName()
                );
            }
        };

        // Membuat tiga thread kasir.
        Thread kasir1 = new Thread(task, "Kasir-A");
        Thread kasir2 = new Thread(task, "Kasir-B");
        Thread kasir3 = new Thread(task, "Kasir-C");

        // Memulai semua kasir secara paralel.
        kasir1.start();
        kasir2.start();
        kasir3.start();

        // Method join() memastikan main thread menunggu
        // semua kasir selesai sebelum menampilkan hasil akhir.
        kasir1.join();
        kasir2.join();
        kasir3.join();

        System.out.println(
            "--- HASIL AKHIR STOK: " +
                ayamJuicyLuicyGallagher.getRemainingStock() +
                " ---"
        );

        /**
         * Jika tanpa synchronized, hasilnya bisa tidak tepat karena
         * race condition memungkinkan lebih dari 100 ayam terjual.
         */
    }
}

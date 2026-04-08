/**
 * ============================================================
 * DESKRIPSI PROGRAM:
 * ============================================================
 * Program ini mendemonstrasikan pola Divide and Conquer dalam
 * pemrograman paralel. Pekerjaan menjumlahkan angka dari 1
 * sampai n dibagi rata kepada beberapa thread, kemudian
 * hasil parsial dari setiap thread digabungkan untuk
 * menghasilkan hasil akhir.
 * ============================================================
 */
import java.util.ArrayList;
import java.util.List;

public class PenjumlahanParalel {

    /** Jumlah thread yang digunakan untuk pembagian tugas */
    private static final int JUMLAH_THREAD = 4;

    /** Angka akhir untuk penjumlahan (1 sampai ANGKA_AKHIR) */
    private static final int ANGKA_AKHIR = 1000;

    /**
     * Hasil parsial dari setiap thread disimpan di array ini.
     * Menggunakan array karena setiap index diisi oleh satu thread
     * secara berurutan (thread i mengisi index i), sehingga
     * tidak ada race condition pada penulisan array.
     */
    private static long[] hasilParsial = new long[JUMLAH_THREAD];

    /**
     * Total akumulasi hasil. Menggunakan synchronized block
     * karena multiple threads akan mengakses dan mengubah
     * nilai ini secara bersamaan (race condition).
     */
    private static long totalAkhir = 0;

    /**
     * Kelas WorkerThread merepresentasikan setiap thread yang
     * bertanggung jawab untuk menghitung jumlah parsial dari
     * rentang angka tertentu.
     *
     * DIVIDE AND CONQUER PATTERN:
     * - DIVIDE: Setiap thread mendapatkan rentang angka tertentu
     * - CONQUER: Setiap thread menjumlahkan angka dalam rentangnya
     * - COMBINE: Hasil dari setiap thread digabungkan di akhir
     */
    private static class WorkerThread extends Thread {

        /** ID thread (0 sampai JUMLAH_THREAD-1) */
        private final int threadId;

        /** Batas bawah rentang angka (inklusif) */
        private final int batasBawah;

        /** Batas atas rentang angka (inklusif) */
        private final int batasAtas;

        /**
         * Konstruktor untuk membuat worker thread
         */
        public WorkerThread(int id, int bawah, int atas) {
            this.threadId = id;
            this.batasBawah = bawah;
            this.batasAtas = atas;
        }

        @Override
        public void run() {
            long jumlahParsial = 0;

            // Looping untuk menjumlahkan angka dalam rentang
            for (int i = batasBawah; i <= batasAtas; i++) {
                jumlahParsial += i;
            }

            // Simpan hasil parsial ke array (aman karena setiap
            // thread menulis ke index yang berbeda)
            hasilParsial[threadId] = jumlahParsial;

            System.out.println(
                "Thread " + (threadId + 1) + " partial result: " + jumlahParsial
            );

            // MULTIPLE THREADS mengakses variabel totalAkhir secara
            // bersamaan. Tanpa synchronized, akan terjadi race condition
            // yang mana hasil penjumlahan menjadi salah.
            //
            // Dengan synchronized, hanya satu thread yang dapat
            // mengakses block ini pada satu waktu, sehingga
            // operasi penjumlahan menjadi ATOMIC.

            synchronized (PenjumlahanParalel.class) {
                totalAkhir += jumlahParsial;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== PENJUMLAHAN PARALEL ===");
        System.out.println("Jumlah Thread: " + JUMLAH_THREAD);
        System.out.println("Angka Akhir: " + ANGKA_AKHIR);
        System.out.println();

        // Tugas menjumlahkan 1 sampai ANGKA_AKHIR dibagi
        // rata kepada JUMLAH_THREAD thread.
        //
        // Pembagian:
        // - chunkSize = ANGKA_AKHIR / JUMLAH_THREAD = 250
        // - Thread i: mulai = i*chunkSize + 1, akhir = (i+1)*chunkSize

        System.out.println("--- Pembagian Tugas ---");

        int chunkSize = ANGKA_AKHIR / JUMLAH_THREAD;
        List<WorkerThread> threads = new ArrayList<>();

        for (int i = 0; i < JUMLAH_THREAD; i++) {
            // Hitung batas bawah dan atas untuk thread ini
            int batasBawah = (i * chunkSize) + 1;
            int batasAtas = (i + 1) * chunkSize;

            // Thread terakhir mendapatkan sisa jika ada sisa
            if (i == JUMLAH_THREAD - 1) {
                batasAtas = ANGKA_AKHIR;
            }

            System.out.println(
                "Thread " +
                    (i + 1) +
                    ": Menjumlahkan " +
                    batasBawah +
                    " - " +
                    batasAtas
            );

            // Buat dan start thread
            WorkerThread worker = new WorkerThread(i, batasBawah, batasAtas);
            threads.add(worker);
            worker.start();
        }

        System.out.println();
        System.out.println("--- Hasil Parsial ---");

        // Method join() memastikan bahwa main thread menunggu
        // semua worker thread selesai sebelum melanjutkan.
        // Ini adalah pola JOIN/FORK yang standard.

        try {
            for (WorkerThread thread : threads) {
                thread.join(); // Menunggu thread ini selesai
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        }

        // Setelah semua thread selesai, hasil akhir adalah
        // penjumlahan dari semua hasil parsial.

        System.out.println();
        System.out.println("--- HASIL AKHIR ---");
        System.out.println("Total: " + totalAkhir);

        // Formula matematika untuk sum 1 to n:
        // S = n * (n + 1) / 2
        //
        // Untuk n = 1000:
        // S = 1000 * 1001 / 2 = 500500
        //
        // Jika hasil parallel = hasil formula, maka perhitungan
        // paralel berhasil dengan benar.

        long hasilVerifikasi = ((long) ANGKA_AKHIR * (ANGKA_AKHIR + 1)) / 2;

        System.out.println();
        System.out.println("--- VERIFIKASI ---");
        System.out.println("Expected (n*(n+1)/2): " + hasilVerifikasi);

        if (totalAkhir == hasilVerifikasi) {
            System.out.println("Hasil BENAR! Perhitungan paralel berhasil.");
        } else {
            System.out.println("Hasil SALAH! Ada kesalahan dalam perhitungan.");
        }

        /*
         *  Sequential:  O(n)
         *  Parallel:    O(n/numThreads)
         */
    }
}

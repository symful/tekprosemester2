public class Restaurant {
    private String[] nama_makanan;
    private double[] harga_makanan;
    private int[] stok;
    private static byte id = 0;

    public Restaurant() {
        nama_makanan = new String[10];
        harga_makanan = new double[10];
        stok = new int[10];
    }

    public void tambahMenuMakanan(String nama, double harga, int stok) {
        if (stok < 0) {
            System.out.println("Stok tidak boleh negatif!");
            return;
        }
        this.nama_makanan[id] = nama;
        this.harga_makanan[id] = harga;
        this.stok[id] = stok;
        nextId();
    }

    public void tampilMenuMakanan() {
        for (int i = 0; i <= id; i++) {
            if (!isOutOfStock(i)) {
                System.out.println(nama_makanan[i] + "[" + stok[i] + "]" + "\tRp. " + harga_makanan[i]);
            }
        }
    }

    public boolean isOutOfStock(int id) {
        if (stok[id] == 0) {
            return true;
        } else {
            return false;
        }
    }

    private static void nextId() {
        id++;
    }

    public void pesanMenu(String nama, int jumlah) {
        for (int i = 0; i <= id; i++) {
            if (nama.equals(nama_makanan[i])) {
                if (stok[i] >= jumlah) {
                    System.out.println("Pesanan " + nama + " sebanyak " + jumlah + " porsi berhasil dipesan.");
                    stok[i] -= jumlah;
                } else {
                    System.out.println("Stok " + nama + " tidak mencukupi.");
                }
                return;
            }
        }
        System.out.println("Menu " + nama + " tidak ditemukan.");
    }
}

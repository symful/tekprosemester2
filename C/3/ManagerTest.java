public class ManagerTest {

    public static void main(String[] args) {
        // Mendeklarasikan dan mengalokasikan array untuk 3 objek Employee
        Employee[] staff = new Employee[4];

        // Mengisi array dengan kombinasi Employee dan Manager (Polimorfisme)
        staff[0] = new Employee("Antonio Rossi", 2000000, 1, 10, 1989);
        staff[1] = new Manager("Maria Bianchi", 2500000, 1, 12, 1991);
        staff[2] = new Employee("Isabel Vidal", 3000000, 1, 11, 1993);
        staff[3] = new Manager("Giovanni Brown", 2200000, 15, 5, 1995);

        // Menaikkan gaji semua staf sebesar 5%
        System.out.println("=== Menaikkan Gaji 5% ===");
        for (int i = 0; i < staff.length; i++) {
            staff[i].raiseSalary(5);
        }

        // Mencetak data sebelum sorting
        System.out.println(
            "\n=== Sebelum Sorting (berdasarkan urutan inisialisasi) ==="
        );
        for (int i = 0; i < staff.length; i++) {
            System.out.print("[" + i + "] ");
            staff[i].print();
        }

        // Mengurutkan array menggunakan shell_sort dari Sortable
        // Polimorfisme memungkinkan array Employee[] diperlakukan sebagai Sortable[]
        // karena Employee adalah subclass dari Sortable
        Sortable.shell_sort(staff);

        // Mencetak data setelah sorting
        System.out.println("\n=== Setelah Sorting (ascending by salary) ===");
        for (int i = 0; i < staff.length; i++) {
            System.out.print("[" + i + "] ");
            staff[i].print();
        }

        // Demonstrasi bahwa method compare bekerja untuk Manager juga
        System.out.println("\n=== Demonstrasi Method compare pada Manager ===");
        Manager m1 = (Manager) staff[1]; // staff[1] sekarang adalah Manager dengan gaji terendah kedua
        Manager m2 = new Manager("Test Manager", 2800000, 1, 1, 2000);

        // Menampilkan informasi Manager
        System.out.println("Manager 1: " + m1.getSalary());
        System.out.println("Manager 2: " + m2.getSalary());

        int comparison = m1.compare(m2);
        System.out.println("Hasil perbandingan m1.compare(m2): " + comparison);
        if (comparison < 0) {
            System.out.println(
                "Manager 1 memiliki gaji lebih kecil dari Manager 2"
            );
        } else if (comparison > 0) {
            System.out.println(
                "Manager 1 memiliki gaji lebih besar dari Manager 2"
            );
        } else {
            System.out.println("Manager 1 memiliki gaji sama dengan Manager 2");
        }
    }
}

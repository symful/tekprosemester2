public class EmployeeTest {

    public static void main(String[] args) {
        // Mendeklarasikan dan mengalokasikan array untuk 3 objek Employee
        Employee[] staff = new Employee[3];

        // Inisialisasi data karyawan
        staff[0] = new Employee("Antonio Rossi", 2000000, 1, 10, 1989);
        staff[1] = new Employee("Maria Bianchi", 2500000, 1, 12, 1991);
        staff[2] = new Employee("Isabel Vidal", 3000000, 1, 11, 1993);

        // Menaikkan gaji setiap staf sebesar 5%
        for (int i = 0; i < 3; i++) {
            staff[i].raiseSalary(5);
        }

        // Mencetak data sebelum sorting
        System.out.println("=== Sebelum Sorting ===");
        for (int i = 0; i < 3; i++) {
            staff[i].print();
        }

        // Memanggil method compare secara langsung (opsional - demonstrasi)
        System.out.println("\n=== Demonstrasi Method compare ===");
        int comparisonResult = staff[0].compare(staff[1]);
        System.out.println(
            "Perbandingan " +
                staff[0].getSalary() +
                " dengan " +
                staff[1].getSalary() +
                ": " +
                comparisonResult
        );

        // Mengurutkan array menggunakan shell_sort dari Sortable
        Sortable.shell_sort(staff);

        // Mencetak data setelah sorting
        System.out.println("\n=== Setelah Sorting (ascending by salary) ===");
        for (int i = 0; i < 3; i++) {
            staff[i].print();
        }
    }
}

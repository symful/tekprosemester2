## Pertanyaan
1. Analisis Langkah Demi Langkah: Jelaskan urutan eksekusi pada baris boolean result. Mana yang dijalankan lebih dulu antara ++a dan perkalian *?
2. Short-Circuit Logic: Jika bagian pertama (++a * 2 > b) bernilai false, apakah bagian kedua (b++ % 3 == 1) akan tetap dieksekusi oleh Java? Jelaskan dampaknya pada nilai akhir variabel b.
3. Output: Berapakah nilai akhir dari result, a, dan b?

## Code
```java
// OperatorChallenge.java
class OperatorChallenge {

    public static void main(String[] args) {
        int a = 5;
        int b = 10;

        boolean result = (++a * 2 > b) && (b++ % 3 == 1);

        System.out.println("Hasil Boolean: " + result);
        System.out.println("Nilai a: " + a);
        System.out.println("Nilai b: " + b);
    }
}

```

## Output
```sh
Hasil Boolean: true
Nilai a: 6
Nilai b: 11
```

## Jawaban
1. Urutan eksekusi pada baris boolean result adalah sebagai berikut:
   - Pertama, operator ++a akan dijalankan, sehingga nilai a menjadi 6.
   - Selanjutnya, perkalian * akan dijalankan, sehingga hasilnya menjadi 12.
   - Kemudian, operator > akan dijalankan, sehingga hasilnya menjadi true.
   - Terakhir, operator && akan dijalankan, sehingga hasilnya menjadi true.

2. Short-Circuit Logic: Jika bagian pertama (++a * 2 > b) bernilai false, maka bagian kedua (b++ % 3 == 1) tidak akan dieksekusi oleh Java. Hal ini karena operator && akan menghentikan eksekusi jika salah satu operand bernilai false. Jadi, jika bagian pertama bernilai false, maka bagian kedua tidak akan dieksekusi dan nilai akhir variabel b tidak akan berubah.

3. Output: Berapakah nilai akhir dari result, a, dan b?
   - Nilai akhir dari result adalah true.
   - Nilai akhir dari a adalah 6.
   - Nilai akhir dari b adalah 11.

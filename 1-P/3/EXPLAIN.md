## Pertanyaan
Math Class berisi bermacam-macam fungsi matematika seperti pada contoh diatas pada penggunaan round(x), terdapat beberapa pertanyaan yang perlu untuk dijelaskan:
1. Pada kasus berikut jelaskan nilai nx setelah digunakan Math.round(x);
2. Kenapa dibutuhkan cast (int) dalam penggunaan Math.round(x) ?

## Output
```sh
x = 92.98
nx = 93
```

## Jawaban
1. Nilai `nx` setelah digunakan `Math.round(x)` adalah `93` karena `Math.round(x)` akan mengembalikan nilai `double` yang dibulatkan ke bilangan terdekat. Jadi, karena `x = 92.98`, maka `Math.round(x)` akan mengembalikan nilai `93` (berbentuk `long`). Namun, karena tipe data nx adalah `int`, maka nilainya akan berubah menjadi `93` (berbentuk `int`) karena casting eksplisit.
2. Dibutuhkan cast `(int)` dalam penggunaan `Math.round(x)` karena tipe data `Math.round(x)` adalah `long`, sedangkan tipe data `nx` adalah `int`. Jika tidak dilakukan cast, maka akan terjadi error karena tidak dapat mengisi nilai `long` ke dalam variabel `int`.

## Pertanyaan
Program berikut melakukan convert tipe data yang berukuran besar ke kecil (long -> int -> short) dan (double -> float -> byte).
1. Jelaskan output nilai dari variable b.
2. Jelaskan apa yang berubah dari variable d menjadi variable b setelah dilakukan cast ?

## Output
```sh
10
```

## Jawaban
1. Output dari variable `b` adalah `10` karena hasil dari `methodOne((long) f)` adalah `10`, dan `byte` dapat menyimpan nilai antara `-128` hingga `127`, jadi nilai `10` tidak akan berubah.
2. Setelah dilakukan cast, variable `d` menjadi variable `b` karena `byte` hanya dapat menyimpan nilai antara `-128` hingga `127`, jadi nilai `10` tidak akan berubah.

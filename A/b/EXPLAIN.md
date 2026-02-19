## Pertanyaan
Dari 2 contoh baris program diatas, jawablah pertanyaan dibawah ini:
1. Bagaimana output dari masing masing class Constants dan Constants2?
2. Apa perbedaan penggunaan final double dengan public static final double?

## Code
```java
// Constants.java
public class Constants {

    public static void main(String[] args) {
        final double CM_PER_INCH = 2.54;
        double paperWidth = 8.5;
        double paperHeight = 11;
        System.out.println(
            "Paper size in centimeters: " +
                paperWidth * CM_PER_INCH +
                " by " +
                paperHeight * CM_PER_INCH
        );
    }
}
```

```java
// Constants2.java
public class Constants2 {

    public static final double CM_PER_INCH = 2.54;

    public static void main(String[] args) {
        final double CM_PER_INCH = 2.54;
        double paperWidth = 8.5;
        double paperHeight = 11;
        System.out.println(
            "Paper size in centimeters: " +
                paperWidth * CM_PER_INCH +
                " by " +
                paperHeight * CM_PER_INCH
        );
    }
}
```

## Output
```sh
Paper size in centimeters: 21.59 by 27.94
```

## Jawaban
1. Output dari class Constants dan class Constants2 adalah sama, yaitu `Paper size in centimeters: 21.59 by 27.94`.
2. Penggunaan `final double` dan `public static final double` memiliki perbedaan dalam penggunaan dan aksesibilitas. `final double` adalah variabel yang nilainya tidak dapat diubah setelah deklarasi, sedangkan `public static final double` adalah variabel yang nilainya tidak dapat diubah setelah deklarasi dan dapat diakses dari luar kelas.

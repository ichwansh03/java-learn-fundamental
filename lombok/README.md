## Java Lombok Notes

* Project Lombok adalah library yang dapat men-generated code pada Java seperti method setter-getter, toString, dll. Lihat [Project Lombok](https://projectlombok.org/).
* `@Singular` digunakan untuk membuat object item pada field yg tipe datanya Collections.
* Jika ingin melakukan validasi null pointer, tambahkan anotasi `@NonNull`.
* Anotasi `@Value` digunakan untuk mengubah field menjadi immutable/final.
* Anotasi `@Cleanup` digunakan untuk menutup proses seperti koneksi ke DB.
* Anotasi `@SneakyThrows` bekerja sebagai pengganti try-catch dan throwable.

## Related Article
[Implementasi Library Lombok untuk Efisiensi Kode di Java](https://ichwansholihin.medium.com/implementasi-library-lombok-untuk-efisiensi-kode-di-java-b33afa8984e7)

## Java Lombok Notes

* Project Lombok adalah library yang dapat men-generated code pada Java seperti method setter-getter, toString, dll. Lihat ![Project Lombok](https://projectlombok.org/).
* `@Singular` digunakan untuk membuat object item pada field yg tipe datanya Collections.
* Jika ingin melakukan validasi null pointer, tambahkan anotasi `@NonNull`.
* Anotasi `@Value` digunakan untuk mengubah field menjadi immutable/final.
  
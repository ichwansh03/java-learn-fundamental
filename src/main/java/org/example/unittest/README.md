## Java Unit Test Notes

* Unit test harus mengcover semua skenario pengujian
* `@BeforeEach` diexecute sebelum unit test dijalankan, `@AfterEach` diexecute sesudah unit test dijalankan. Jika ingin semua dieksekusi, gunakan `@BeforeAll` dan `@AfterAll`, namun hanya static function saja yg dapat menggunakan annotation tersebut. 
* Jika ingin membatalkan unit test, gunakan `Assumptions`
* Jika ingin menjalankan test pada `@Tag` tertentu, gunakan perintah `mvn test -Dgroups=nametag1,nametag2`
* Setiap membuat unit-test, object akan membuat object baru ketika dipanggil dan dijalankan secara independen (tidak bergantung dengan method lain). Jika ingin menambahkan ketergantungan antar object, gunakan `@TestInstance`. Jika menggunakan lifecycle `@TestInstance`, ketika menggunakan annotation `@BeforeAll` atau `@AfterAll` kita tidak perlu menggunakan method static.
* Untuk menjalankan inner class di test, gunakan annotation `@Nested`
* Untuk contoh implementasi dependency injection di unit test, lihat dokumentasi `ParamterResolver`. Dan jika ingin menerapkan dependency injection class custom, gunakan annotation `@ExtendWith` atau `@Extensions`. Jika tidak ingin menggunakan annotation `@Extensions`, buat parent class dan turunkan ke child class, namun di parent tetap gunakan annotation `@Extensions`.
* Jika ingin mengulang test, gunakan annotation `@RepeatedTest`
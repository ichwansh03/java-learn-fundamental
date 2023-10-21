## Java Validation Notes

* Implementasi bean validation : [Hibernate Validation](https://hibernate.org/validator)
* `Validator` adalah object yang berat, jadi cukup implementasi sekali saja lalu gunakan berkali-kali.
* Anotasi `@Valid` perlu ditambahkan ketika ingin memvalidasi sebuah objek di dalam objek. Contoh di class `Student`.
* Anotasi `@GroupSequence` digunakan untuk memvalidasi constraint secara berurutan, namun ketika terdapat salah satu constraint yg error, maka constraint yg lain tidak akan dieksekusi, jadi lebih aman.
* By default, contract annotation constraint di Bean Validation memiliki method `message()`, `groups()` dan `payload()`

## Related Article
[Membuat Validasi Nilai Menggunakan Hibernate Validator di Java](https://ichwansholihin.medium.com/membuat-validasi-nilai-menggunakan-hibernate-validator-di-java-87b2f39e1b5e)

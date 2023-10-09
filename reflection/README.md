## Java Reflection Notes

* Reflection digunakan untuk memanipulasi class/field/method bahkan ketika runtime. Hal ini berguna ketika mengembangkan aplikasi GUI contohnya untuk memodifikasi field tanpa mengubah objek aslinya atau ketika menggunakan spring/hibernate untuk mengakses hidden class ketika kompilasi.
* Reflection sangat cocok digunakan ketika membuat annotation untuk memvalidasi value di spring contohnya. Lihat class `ValidatorTest`.
* Class `Proxy` dapat digunakan untuk membuat object tanpa harus membuat implementasi/class contract dari sebuah interface.
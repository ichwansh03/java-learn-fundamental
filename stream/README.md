## Java Stream Notes

* Stream berkaitan dengan Array dan Collection atau istilah saat ini dikenal dengan reactive programming (RxJava).
* Value stream hanya dapat digunakan sekali.
* Jika menggunakan class `Stream.Builder<>` untuk menambahkan data dapat menggunakan method `accept()` dengan return void atau `add()` dengan return value builder itu sendiri.
* Stream membuat data baru walaupun value sebelumnya digunakan oleh stream lain. Jadi valuenya tetap tidak akan berubah.
* Operation di stream terbagi menjadi 2 jenis, yaitu intermediate operations merupakan lazy operation, tidak akan dieksekusi sampai dibutuhkan dan terminal operations merupakan operasi yang mentrigger sebuah stream untuk berjalan.
* Karena stream hanya dapat digunakan untuk tipe data object, maka class stream tidak dapat digunakan di tipe data primitif. Gunakan class `IntStream`, `LongStream` atau `DoubleStream`. Fungsi turunannya sama dengan Stream.
* Untuk mengubah dari Stream ke Collection, gunakan operator `collect(Collectors)`
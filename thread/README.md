## Java Thread Notes

* Concurrency artinya mengerjakan beberapa pekerjaan satu persatu pada satu waktu secara bergantian, sementara parallel artinya mengerjakan beberapa pekerjaan sekaligus secara bersamaan.
* Synchronous: sequential dan bertahap (blocking). Asynchronous: parallel (non-blocking).
* Gunakan interface `Runnable` untuk membuat thread baru dan gunakan `Thread.sleep()` untuk blocking thread secara sementara, namun jika memiliki 2 proses yang di sleep, lebih baik gunakan method `join()` agar proses berjalan synchronous. Jika ingin membatalkan thread gunakan method `interrupt()` atau `interrupted()`.
* Gunakan keyword `synchronized` pada tipe method untuk menandakan bahwa hanya boleh ada satu thread yg running pada method tersebut dan agar terhindar dari race condition, yakni case dimana setiap thread saling mendahului satu sama lain (khusus thread dengan jumlah besar). Lihat class `SynchronizedCounter`
* Deadlock adalah kasus dimana 2 thread saling menunggu satu sama lain. Lihat class `Balance`.
* Method `notify()` hanya untuk mengirim sinyal ke satu thread saja, jika memiliki banyak thread yg menggunakan execute `wait()`, gunakan `notifyAll()`. Lihat method `testThreadCommunication()` di `ThreadTest`.
* Disarankan menggunakan high level API, concurrent di Java 5 dan `ThreadPoolExecutor` ketimbang membuat thread secara manual.
* Jika ingin menghentikan Threadpool, gunakan `shutdown()` jika ada thread yg belum di execute, maka akan di ignore. Atau gunakan `awaitTermination()` untuk menunggu execute thread selesai.
* Jika interface `Runnable` ketika menjalankan thread, interface tersebut tidak mengembalikan data (void). Gunakan interface `Callable<T>` yang mengembalikan data `Future<T>` (Future of T).
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
* Gunakan sub-interface `ScheduledExecutorService` untuk scheduling setiap task seperti delayed job dan periodic job.
* Pada `Lock()` terdapat 2 jenis untuk operasi read dan write. Gunakan interface `ReadWriteLock()`, Namun ini masih low-level. 
* Pada class `ThreadTest`, upgrade penggunaan method ke high level, gunakan `await()`, `signal()` dan `signalAll()`.
* Class `Semaphore` digunakan untuk membatasi thread yang diexecute, contohnya ketika menjalankan query atau request ke API maka dilakukan limitasi agar tidak terlalu banyak request. Lihat class `SynchronizerTest`.
* Class `Exchanger` digunakan untuk penukaran data antar thread, dan dua thread harus memenuhi pertukaran data satu sama lain. Lihat class `SynchronizerTest`.
* Konsep Fork/Join sama seperti algoritma divide and conquer, 1 task akan di pecah menjadi 2 task kecil dan seterusnya, lalu dari task kecil tersebut digabung sehingga menghasilkan 1 task hasil penggabungan. Fork/Join thread mengimplementasikan algoritma work stealing dengan konsep mengambil thread yg sudah selesai mengerjakan task.
* Dalam reactive stream, terdapat Flow API yg support dengan java concurrent [Flow](https://www.reactive-streams.org/). Pada Flow dikenal istilah Publisher yang mengirim data dan Subscriber yang menerima data. Jika ingin mengirim ke subscriber lain dan diterima publisher lain gunakan interface `Processor`.

## Related Article
[Mengenal Class Executors untuk Management Threading serta Implementasinya di Java](https://medium.com/@ichwansholihin/mengenal-class-executors-untuk-management-threading-serta-implementasinya-di-java-3b5e915ead0a)

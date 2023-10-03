## Java Thread Notes

* Concurrency artinya mengerjakan beberapa pekerjaan satu persatu pada satu waktu secara bergantian, sementara parallel artinya mengerjakan beberapa pekerjaan sekaligus secara bersamaan.
* Synchronous: sequential dan bertahap (blocking). Asynchronous: parallel (non-blocking).
* Gunakan interface `Runnable` untuk membuat thread baru dan gunakan `Thread.sleep()` untuk blocking thread secara sementara, namun jika memiliki 2 proses yang di sleep, lebih baik gunakan method `join()` agar proses berjalan synchronous. Jika ingin membatalkan thread gunakan method `interrupt()` atau `interrupted()`.
* Gunakan keyword `synchronized` pada tipe method untuk menandakan bahwa hanya boleh ada satu thread yg running pada method tersebut dan agar terhindar dari race condition (khusus thread dengan jumlah besar).
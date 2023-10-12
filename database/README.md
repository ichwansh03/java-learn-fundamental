## Java Database Notes

* Setiap implementasi method/class/interface dari MySQL driver pasti menghasilkan `SQLException`. Usahakan buat try-catch untuk throw errornya.
* Jika sudah menjalankan connection, diharuskan untuk menutup connection ke DB menggunakan `connection.close()`
* Gunakan konsep connection pool agar tidak buka tutup koneksi dan direpresentasikan dengan interface `javax.sql.DataSource` atau menggunakan library HikariCP.
* Jika ingin melakukan perintah insert, update dan delete gunakan method `executeUpdate(sql)`. Jika perintah select gunakan method `executeQuery(sql)`.
* Jika ingin mengirim perintah sekaligus dalam jumlah banyak, gunakan `executeBatch()` seperti di class `BatchTest`
* Di java, tabel direpresentasikan dengan entity dan setiap entity harus memiliki layer repository.

## Related Article
![How to Keep Away SQL Injection Attack When Call DB User in Java](https://ichwansholihin.medium.com/how-to-keep-away-sql-injection-when-call-db-user-in-java-98255577d8c1)

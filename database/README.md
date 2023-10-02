## Java Database Notes

* Setiap implementasi method/class/interface dari MySQL driver pasti menghasilkan `SQLException`. Usahakan buat try-catch untuk throw errornya.
* Jika sudah menjalankan connection, diharuskan untuk menutup connection ke DB menggunakan `connection.close()`
* Gunakan konsep connection pool agar tidak buka tutup koneksi dan direpresentasikan dengan interface `javax.sql.DataSource` atau menggunakan library HikariCP.
* Jika ingin melakukan perintah insert, update dan delete gunakan method `executeUpdate(sql)`. Jika perintah select gunakan method `executeQuery(sql)`
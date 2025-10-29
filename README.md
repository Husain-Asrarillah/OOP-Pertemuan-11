---

# Laporan Implementasi Java Persistence API (JPA)

## I. Konfigurasi Awal dan Pembuatan Entitas ⚙️

Bagian ini menjelaskan langkah-langkah dalam mengonfigurasi proyek untuk menggunakan *Java Persistence API* (JPA) sebagai lapisan akses data.

### 1. Pembuatan Persistence Unit dan Entitas

Pembuatan kelas Entitas (`TokoKomikJadoel.java`) yang memetakan tabel database dilakukan secara otomatis melalui wizard NetBeans:

* **Pilih Opsi:** Klik kanan pada *package* tujuan → **New** → **Entity Classes from Database**
  <img width="575" height="243" alt="image" src="https://github.com/user-attachments/assets/6e7e8183-37a2-4d07-9ff5-1fa8623d961c" />

* **Koneksi Database:** Pilih koneksi database yang tersedia
  <img width="577" height="404" alt="image" src="https://github.com/user-attachments/assets/20416ef4-c3d7-4eb5-99f9-65b5954ce7a9" />

* **Pemilihan Tabel:** Pindahkan tabel `toko_komik_jadoel` ke kolom *Selected Tables*
  <img width="576" height="451" alt="image" src="https://github.com/user-attachments/assets/6dc12bfc-b6ab-4682-9c33-bb1f7dc7cc03" />

* **Penyelesaian:** Klik **Next* hinnga menemukan **Finish**

### 2. Hasil Otomatisasi

Setelah proses selesai, dihasilkan file dan package penting:

* **Entitas:** Kelas `TokoKomikJadoel.java` (Entity JPA) di dalam package `pertemuankesebelas`
  <img width="382" height="343" alt="image" src="https://github.com/user-attachments/assets/58c157a3-a8ca-4b47-823f-ed68f9b0bbb2" />

* **Konfigurasi:** File `persistence.xml` di folder `META-INF` yang mendefinisikan *Persistence Unit* (misalnya `PertemuanKesebelasPU`)
  <img width="372" height="190" alt="image" src="https://github.com/user-attachments/assets/5356d627-13a1-4219-9f69-02761541a7c7" />

---

## II. Implementasi Logika CRUD (Create, Read, Update, Delete)

Setiap operasi CRUD menggunakan `EntityManager` dan transaksi JPA (`EntityTransaction`).

### a. Insert Data (pada `InsertDialog.java`)

Data baru disimpan menggunakan `em.persist()`.
Karena kolom `id` diatur *auto increment*, pengguna hanya mengisi judul, pengarang, tahun, dan genre.
Proses insert ini otomatis menghasilkan `id` baru dari database tanpa perlu input manual.

### b. Update Data (pada `UpdateDialog.java`)

Proses update menggunakan `em.find()` untuk mengambil entitas berdasarkan `id`, lalu memanggil `em.merge()`.

### c. Delete Data (pada `DeleteDialog.java`)

Data dihapus menggunakan `em.remove()` setelah dicari dengan `em.find()`.

### d. Menampilkan Data ke Tabel (`showTable()`)

Data ditampilkan ke `JTable` dengan mengambil semua entitas menggunakan *NamedQuery* `findAll`.

---

## III. Fungsionalitas Tambahan ➕

### e. Upload Data dari CSV (Batch Insert)

Metode `jButton5ActionPerformed` (button upload) membaca data dari file CSV dan memasukkannya secara *batch*:

### f. Mencetak Laporan (JasperReports)

Fungsi cetak ini menggunakan koneksi **JDBC murni** (java.sql.Connection) yang diinisialisasi secara terpisah (DriverManager.getConnection) dan dikirimkan ke JasperFillManager untuk menghasilkan laporan. Ini adalah satu-satunya fungsionalitas yang tidak menggunakan JPA karena keterbatasan *library* JasperReports.

---

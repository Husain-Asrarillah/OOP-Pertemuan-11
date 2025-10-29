# Laporan Implementasi Java Persistence API (JPA)

## I. Konfigurasi Awal dan Pembuatan Entitas ⚙️

Bagian ini menjelaskan langkah-langkah dalam mengonfigurasi proyek untuk menggunakan *Java Persistence API* (JPA) sebagai lapisan akses data.

### 1. Pembuatan Persistence Unit dan Entitas

Pembuatan kelas Entitas (`TokoKomikJadoel.java`) yang memetakan tabel database dilakukan secara otomatis melalui wizard NetBeans:

- **Pilih Opsi:** Klik kanan pada *package* tujuan → **New** → **Entity Classes from Database**
- **Koneksi Database:** Memilih koneksi database yang tersedia
- **Pemilihan Tabel:** Pindahkan tabel `toko_komik_jadoel` ke kolom *Selected Tables*
- **Penyelesaian:** Klik **Next**, lalu **Finish**

### 2. Hasil Otomatisasi

Setelah proses selesai, dihasilkan file dan package penting:

- **Entitas:** Kelas `TokoKomikJadoel.java` (Entitas JPA) di dalam package `pertemuankesebelas`
- **Konfigurasi:** File `persistence.xml` di folder `META-INF` yang mendefinisikan *Persistence Unit* (misalnya `PertemuanKesebelasPU`)

### 3. Pengelolaan Sumber Daya JPA

Di kelas `DataKomik.java`, objek `EntityManagerFactory` (`emf`) diinisialisasi dan dikelola:

- **Inisialisasi:** `emf` dibuat menggunakan `Persistence.createEntityManagerFactory("NamaUnitPersistensi")`
- **Pelepasan Sumber Daya:** Mekanisme penutup (*WindowListener*) diimplementasikan untuk memastikan `emf` ditutup (`emf.close()`) saat aplikasi berakhir

---

## II. Implementasi Logika CRUD (Create, Read, Update, Delete)

Logika CRUD diimplementasikan menggunakan pola transaksi JPA di dalam *action listener* tombol-tombol.

### a. Insert Data (pada `InsertDialog.java`)

Operasi ini menggunakan `em.persist()` untuk menambahkan objek entitas baru:

1. Membuka **Transaksi JPA**
2. Membuat objek `TokoKomikJadoel` dan mengisi nilainya dari *form* input
3. Memanggil `em.persist(komik)`
4. Melakukan `em.commit()`

### b. Update Data (pada `UpdateDialog.java`)

Operasi ini memerlukan pencarian entitas sebelum dimodifikasi:

1. Menggunakan `em.find(TokoKomikJadoel.class, id)` untuk mengambil entitas yang ada
2. Membuka **Transaksi JPA**
3. Memodifikasi *field* objek entitas tersebut
4. Memanggil `em.merge(komik)` untuk menyinkronkan perubahan ke database
5. Melakukan `em.commit()`

### c. Delete Data (pada `DeleteDialog.java`)

Operasi ini menghapus data berdasarkan kunci utama:

1. Membuka **Transaksi JPA**
2. Menggunakan `em.find(TokoKomikJadoel.class, id)` untuk mengambil entitas yang akan dihapus
3. Memanggil `em.remove(komik)`
4. Melakukan `em.commit()`

### d. Menampilkan Data ke Tabel (Metode `showTable()`)

Metode ini memuat semua data ke dalam `JTable` menggunakan *NamedQuery* JPA:

1. Membuat `EntityManager`
2. Membuat query menggunakan `em.createNamedQuery("TokoKomikJadoel.findAll")` untuk mengambil `List<TokoKomikJadoel>`
3. Melakukan konversi `List<TokoKomikJadoel>` secara *inline* menjadi `DefaultTableModel` (dengan loop manual) untuk mengisi `jTable1`

---

## III. Fungsionalitas Tambahan ➕

### e. Upload Data dari CSV (Batch Insert)

Fungsi ini (`jButton5ActionPerformed`) memungkinkan *batch insert* data dari file CSV secara efisien menggunakan fitur JPA *Batching*:

1. File CSV dibaca baris per baris
2. Setiap baris diubah menjadi objek `TokoKomikJadoel` dan dipanggil `em.persist()`
3. Untuk menghemat memori, `em.flush()` dan `em.clear()` dipanggil setiap kelipatan jumlah *batch* (misalnya 50 data) sebelum `em.commit()` akhir

### f. Mencetak Laporan (JasperReports)

Fungsi cetak ini menggunakan koneksi **JDBC murni** (`java.sql.Connection`) yang diinisialisasi secara terpisah (`DriverManager.getConnection`) dan dikirimkan ke `JasperFillManager` untuk menghasilkan laporan.  
Ini adalah satu-satunya fungsionalitas yang tidak menggunakan JPA karena keterbatasan *library* JasperReports.

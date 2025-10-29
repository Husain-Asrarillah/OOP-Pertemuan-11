---

# Laporan Implementasi Java Persistence API (JPA)

## I. Konfigurasi Awal dan Pembuatan Entitas ⚙️

Bagian ini menjelaskan langkah-langkah dalam mengonfigurasi proyek untuk menggunakan *Java Persistence API* (JPA) sebagai lapisan akses data.

### 1. Pembuatan Persistence Unit dan Entitas

Pembuatan kelas Entitas (`TokoKomikJadoel.java`) yang memetakan tabel database dilakukan secara otomatis melalui wizard NetBeans:

* **Pilih Opsi:** Klik kanan pada *package* tujuan → **New** → **Entity Classes from Database**
* **Koneksi Database:** Pilih koneksi database yang tersedia
* **Pemilihan Tabel:** Pindahkan tabel `toko_komik_jadoel` ke kolom *Selected Tables*
* **Penyelesaian:** Klik **Next**, lalu **Finish**

### 2. Hasil Otomatisasi

Setelah proses selesai, dihasilkan file dan package penting:

* **Entitas:** Kelas `TokoKomikJadoel.java` (Entity JPA) di dalam package `pertemuankesebelas`
* **Konfigurasi:** File `persistence.xml` di folder `META-INF` yang mendefinisikan *Persistence Unit* (misalnya `PertemuanKesebelasPU`)

Kelas entitas menggunakan anotasi JPA berikut:

```java
@Entity
@Table(name = "toko_komik_jadoel")
@NamedQueries({
    @NamedQuery(name = "TokoKomikJadoel.findAll", query = "SELECT t FROM TokoKomikJadoel t"),
    @NamedQuery(name = "TokoKomikJadoel.findById", query = "SELECT t FROM TokoKomikJadoel t WHERE t.id = :id")
})
public class TokoKomikJadoel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "judul")
    private String judul;
    
    @Column(name = "pengarang")
    private String pengarang;
    
    @Column(name = "tahun")
    private Integer tahun;
    
    @Column(name = "genre")
    private String genre;
}
```

Bagian penting di sini adalah:

* **`@GeneratedValue(strategy = GenerationType.IDENTITY)`** → kolom `id` bersifat *auto increment* di database, sehingga pengguna tidak perlu mengisi manual.

### 3. Pengelolaan Sumber Daya JPA

Di kelas `DataKomik.java`, objek `EntityManagerFactory` (`emf`) dikelola secara terpusat:

* **Inisialisasi:**

  ```java
  emf = Persistence.createEntityManagerFactory("PertemuanKesebelasPU");
  ```
* **Penutupan Otomatis:**
  Listener `windowClosing` menutup `emf`:

  ```java
  addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
          emf.close();
      }
  });
  ```

---

## II. Implementasi Logika CRUD (Create, Read, Update, Delete)

Setiap operasi CRUD menggunakan `EntityManager` dan transaksi JPA (`EntityTransaction`).

### a. Insert Data (pada `InsertDialog.java`)

Data baru disimpan menggunakan `em.persist()`.
Karena kolom `id` diatur *auto increment*, pengguna hanya mengisi judul, pengarang, tahun, dan genre.

```java
EntityManager em = emf.createEntityManager();
em.getTransaction().begin();

TokoKomikJadoel komik = new TokoKomikJadoel();
komik.setJudul(txtJudul.getText());
komik.setPengarang(txtPengarang.getText());
komik.setTahun(Integer.parseInt(txtTahun.getText()));
komik.setGenre(txtGenre.getText());

em.persist(komik);
em.getTransaction().commit();
em.close();
```

Proses insert ini otomatis menghasilkan `id` baru dari database tanpa perlu input manual.

### b. Update Data (pada `UpdateDialog.java`)

Proses update menggunakan `em.find()` untuk mengambil entitas berdasarkan `id`, lalu memanggil `em.merge()`.

```java
EntityManager em = emf.createEntityManager();
em.getTransaction().begin();

TokoKomikJadoel komik = em.find(TokoKomikJadoel.class, id);
komik.setJudul(txtJudul.getText());
komik.setPengarang(txtPengarang.getText());
komik.setTahun(Integer.parseInt(txtTahun.getText()));
komik.setGenre(txtGenre.getText());

em.merge(komik);
em.getTransaction().commit();
em.close();
```

### c. Delete Data (pada `DeleteDialog.java`)

Data dihapus menggunakan `em.remove()` setelah dicari dengan `em.find()`.

```java
EntityManager em = emf.createEntityManager();
em.getTransaction().begin();

TokoKomikJadoel komik = em.find(TokoKomikJadoel.class, id);
if (komik != null) {
    em.remove(komik);
}

em.getTransaction().commit();
em.close();
```

### d. Menampilkan Data ke Tabel (`showTable()`)

Data ditampilkan ke `JTable` dengan mengambil semua entitas menggunakan *NamedQuery* `findAll`.

```java
EntityManager em = emf.createEntityManager();
List<TokoKomikJadoel> list = em.createNamedQuery("TokoKomikJadoel.findAll").getResultList();

DefaultTableModel model = new DefaultTableModel(new Object[]{"ID", "Judul", "Pengarang", "Tahun", "Genre"}, 0);
for (TokoKomikJadoel k : list) {
    model.addRow(new Object[]{k.getId(), k.getJudul(), k.getPengarang(), k.getTahun(), k.getGenre()});
}
jTable1.setModel(model);
em.close();
```

---

## III. Fungsionalitas Tambahan ➕

### e. Upload Data dari CSV (Batch Insert)

Metode `jButton5ActionPerformed` membaca data dari file CSV dan memasukkannya secara *batch*:

```java
BufferedReader br = new BufferedReader(new FileReader(file));
EntityManager em = emf.createEntityManager();
em.getTransaction().begin();

int batchSize = 50;
int count = 0;
String line;
while ((line = br.readLine()) != null) {
    String[] data = line.split(",");
    TokoKomikJadoel komik = new TokoKomikJadoel();
    komik.setJudul(data[0]);
    komik.setPengarang(data[1]);
    komik.setTahun(Integer.parseInt(data[2]));
    komik.setGenre(data[3]);
    em.persist(komik);

    if (++count % batchSize == 0) {
        em.flush();
        em.clear();
    }
}

em.getTransaction().commit();
em.close();
br.close();
```

### f. Mencetak Laporan (JasperReports)

Laporan dicetak menggunakan **JDBC murni** karena JasperReports tidak langsung mendukung `EntityManager`.

```java
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbkomik", "root", "");
JasperPrint jp = JasperFillManager.fillReport("reportKomik.jasper", null, conn);
JasperViewer.viewReport(jp, false);
conn.close();
```

---

## IV. Kesimpulan

Implementasi JPA berhasil diterapkan dengan:

* Struktur entitas yang dihasilkan otomatis dari database
* Mekanisme CRUD terintegrasi dengan GUI menggunakan transaksi JPA
* Fitur tambahan seperti batch insert CSV dan pencetakan laporan JasperReports
* Penggunaan `GenerationType.IDENTITY` yang membuat `id` bersifat *auto increment*, menjaga kepraktisan dan integritas data

---

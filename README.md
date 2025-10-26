# Aplikasi Kasir Restoran Sederhana (Java)

Ini adalah proyek aplikasi kasir konsol sederhana yang dibuat dengan bahasa pemrograman Java. Proyek ini dibuat sebagai pemenuhan Tugas Praktik 1 untuk mensimulasikan proses pemesanan, perhitungan biaya, dan pencetakan struk di sebuah restoran.

## Fitur Utama

- **Menampilkan Daftar Menu**: Program menampilkan daftar menu yang telah ditentukan, dikelompokkan berdasarkan kategori (Makanan dan Minuman).
- **Pemesanan Pelanggan**: Pelanggan dapat memasukkan pesanan mereka (maksimal 4 menu) beserta jumlahnya. Pelanggan dapat berhenti memesan kapan saja dengan mengosongkan input.
- **Perhitungan Biaya**: Program menghitung total biaya pesanan.
- **Biaya Tambahan**: Total biaya akan ditambahkan dengan:
  - Pajak 10% dari total biaya.
  - Biaya Pelayanan tetap sebesar Rp 20.000,-.
- **Diskon dan Penawaran Khusus**: Program menerapkan struktur keputusan untuk diskon:
  - **Diskon 10%** diberikan jika total biaya pesanan melebihi Rp 100.000,-.
  - **Penawaran Beli 1 Gratis 1** untuk satu item minuman yang dipesan, jika total biaya pesanan melebihi Rp 50.000,-.
- **Cetak Struk**: Program mencetak struk akhir yang rinci, mencantumkan semua item, jumlah, harga, subtotal, diskon (jika ada), pajak, biaya layanan, dan total akhir.

## Batasan Teknis (Sesuai Soal Tugas)

Sesuai dengan petunjuk pengerjaan, program ini memiliki batasan teknis yang unik:

- **Tidak Menggunakan Perulangan**: Program ini **tidak menggunakan struktur pengulangan** (seperti `for`, `while`, atau `do-while`).
- **Berbasis Struktur Keputusan**: Seluruh alur logika, seperti menampilkan menu dan menerima pesanan, diimplementasikan murni menggunakan **struktur keputusan** (`if`, `else if`, dan _Nested If_).
- **Penggunaan Array**: Data menu restoran dikelola menggunakan `Array`.

## Struktur File

- `Menu.java`: Sebuah kelas POJO (Plain Old Java Object) sederhana yang merepresentasikan satu item menu, berisi atribut `nama`, `harga`, dan `kategori`.
- `Main.java`: Kelas utama yang berisi semua logika program. Ini mencakup inisialisasi menu, method untuk menampilkan menu, menerima pesanan, menghitung total biaya, dan mencetak struk.

## Cara Menjalankan

1.  Pastikan Anda memiliki Java Development Kit (JDK) terinstal di sistem Anda.
2.  Buka terminal atau command prompt.
3.  Navigasi ke direktori tempat Anda menyimpan kedua file `.java`.
4.  Kompilasi (Compile) kedua file tersebut:
    ```bash
    javac Menu.java Main.java
    ```
5.  Jalankan (Run) program:
    ```bash
    java Main
    ```
6.  Program akan berjalan di konsol Anda. Ikuti petunjuk untuk mulai memesan.

## Contoh Skenario Perhitungan

Program ini dirancang untuk menangani tiga skenario utama:

1.  **Pesanan Reguler (Total \< Rp 50.000)**: Pelanggan hanya membayar `Subtotal + Pajak + Biaya Pelayanan`.
2.  **Pesanan Menengah (Total \> Rp 50.000)**: Pelanggan mendapatkan **Promo Beli 1 Gratis 1 Minuman**.
3.  **Pesanan Besar (Total \> Rp 100.000)**: Pelanggan mendapatkan **Promo Beli 1 Gratis 1 Minuman** DAN **Diskon 10%**.

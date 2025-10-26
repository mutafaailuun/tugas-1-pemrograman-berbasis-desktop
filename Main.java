import java.util.Scanner;

public class Main {

    static Menu[] menuRestoran;
    static Menu pesanan1, pesanan2, pesanan3, pesanan4;
    static int qty1, qty2, qty3, qty4;

    /**
     * Method main untuk menjalankan aplikasi.
     */
    public static void main(String[] args) {
        inisialisasiMenu();
        tampilkanMenu();
        terimaPesanan();
        hitungDanCetakStruk(); 
    }

    /**
     * Mengisi data menu ke dalam array
     * Minimal 4 menu per kategori.
     */
    public static void inisialisasiMenu() {
        menuRestoran = new Menu[8]; // Total 8 menu (4 makanan, 4 minuman)

        // Kategori Makanan 
        menuRestoran[0] = new Menu("Nasi Padang", 25000, "Makanan");
        menuRestoran[1] = new Menu("Sate Ayam", 20000, "Makanan");
        menuRestoran[2] = new Menu("Bakso Urat", 18000, "Makanan");
        menuRestoran[3] = new Menu("Gado-Gado", 15000, "Makanan");

        // Kategori Minuman
        menuRestoran[4] = new Menu("Es Teh Manis", 5000, "Minuman");
        menuRestoran[5] = new Menu("Jus Alpukat", 12000, "Minuman");
        menuRestoran[6] = new Menu("Kopi Susu", 10000, "Minuman");
        menuRestoran[7] = new Menu("Air Mineral", 3000, "Minuman");
    }

    /**
     * Menampilkan daftar menu ke layar, dikelompokkan berdasarkan kategori.
     * Tidak menggunakan loop sesuai constraint.
     * 
     */
    public static void tampilkanMenu() {
        System.out.println("========= MENU RESTORAN =========");
        
        // Menampilkan Makanan
        System.out.println("\n--- MAKANAN ---");
        System.out.printf("%-15s - Rp %,d\n", menuRestoran[0].getNama(), menuRestoran[0].getHarga());
        System.out.printf("%-15s - Rp %,d\n", menuRestoran[1].getNama(), menuRestoran[1].getHarga());
        System.out.printf("%-15s - Rp %,d\n", menuRestoran[2].getNama(), menuRestoran[2].getHarga());
        System.out.printf("%-15s - Rp %,d\n", menuRestoran[3].getNama(), menuRestoran[3].getHarga());

        // Menampilkan Minuman
        System.out.println("\n--- MINUMAN ---");
        System.out.printf("%-15s - Rp %,d\n", menuRestoran[4].getNama(), menuRestoran[4].getHarga());
        System.out.printf("%-15s - Rp %,d\n", menuRestoran[5].getNama(), menuRestoran[5].getHarga());
        System.out.printf("%-15s - Rp %,d\n", menuRestoran[6].getNama(), menuRestoran[6].getHarga());
        System.out.printf("%-15s - Rp %,d\n", menuRestoran[7].getNama(), menuRestoran[7].getHarga());
        
        System.out.println("=================================");
    }

    /**
     * Menerima input pesanan dari pelanggan (maksimal 4 item).
     * Berhenti meminta input jika pelanggan mengosongkan '.
     * Menggunakan 'Nested If' untuk menghindari perulangan.
     */
    public static void terimaPesanan() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nSilakan masukkan pesanan Anda (maksimal 4 menu).");
        System.out.println("Gunakan format: Nama Menu = Jumlah (cth: Sate Ayam = 2)");
        System.out.println("Kosongkan input jika selesai memesan.");
        String input;
        String[] parts;
        // Nasi Padang = 4

        // Pesanan 1
        System.out.print("Pesanan 1: ");
        input = scanner.nextLine();
        // Cek jika input tidak kosong
        if (!input.isEmpty()) {
            parts = input.split(" = ");
            if (parts.length == 2) {
                pesanan1 = cariMenu(parts[0]);
                qty1 = Integer.parseInt(parts[1]);
            }

            // Pesanan 2
            // HANYA AKAN DITANYAKAN JIKA PESANAN 1 TIDAK KOSONG'
            System.out.print("Pesanan 2: ");
            input = scanner.nextLine(); // Gunakan lagi variabel 'input'
            if (!input.isEmpty()) {
                parts = input.split(" = ");
                if (parts.length == 2) {
                    pesanan2 = cariMenu(parts[0]);
                    qty2 = Integer.parseInt(parts[1]);
                }

                // Pesanan 3
                // HANYA AKAN DITANYAKAN JIKA PESANAN 2 TIDAK KOSONG
                System.out.print("Pesanan 3: ");
                input = scanner.nextLine();
                if (!input.isEmpty()) {
                    parts = input.split(" = ");
                    if (parts.length == 2) {
                        pesanan3 = cariMenu(parts[0]);
                        qty3 = Integer.parseInt(parts[1]);
                    }

                    // Pesanan 4
                    // HANYA AKAN DITANYAKAN JIKA PESANAN 3 TIDAK KOSONG
                    System.out.print("Pesanan 4: ");
                    input = scanner.nextLine();
                    if (!input.isEmpty()) {
                        parts = input.split(" = ");
                        if (parts.length == 2) {
                            pesanan4 = cariMenu(parts[0]);
                            qty4 = Integer.parseInt(parts[1]);
                        }
                    }
                }   
            }
        }
        System.out.println("\n...Input pesanan selesai...");
    }

    /**
     * Helper method untuk mencari objek Menu dari array berdasarkan nama.
     * Menggunakan struktur keputusan (if-else) karena tidak boleh loop.
     * @param namaMenu Nama menu yang dicari
     * @return Objek Menu jika ditemukan, null jika tidak.
     */
    public static Menu cariMenu(String namaMenu) {
        if (namaMenu.equalsIgnoreCase(menuRestoran[0].getNama())) return menuRestoran[0];
        if (namaMenu.equalsIgnoreCase(menuRestoran[1].getNama())) return menuRestoran[1];
        if (namaMenu.equalsIgnoreCase(menuRestoran[2].getNama())) return menuRestoran[2];
        if (namaMenu.equalsIgnoreCase(menuRestoran[3].getNama())) return menuRestoran[3];
        if (namaMenu.equalsIgnoreCase(menuRestoran[4].getNama())) return menuRestoran[4];
        if (namaMenu.equalsIgnoreCase(menuRestoran[5].getNama())) return menuRestoran[5];
        if (namaMenu.equalsIgnoreCase(menuRestoran[6].getNama())) return menuRestoran[6];
        if (namaMenu.equalsIgnoreCase(menuRestoran[7].getNama())) return menuRestoran[7];
        return null; // Menu tidak ditemukan
    }

    /**
     * Menghitung total biaya dan mencetak struk pesanan.
     * Menggunakan struktur keputusan untuk diskon dan penawaran.
     */
    public static void hitungDanCetakStruk() {
        double subTotal = 0;
        double diskon = 0;
        double biayaPelayanan = 20000;
        boolean dapatBogo = false;
        String namaBogo = "";
        int hargaBogo = 0;

        System.out.println("\n\n========= STRUK PESANAN ANDA ========="); //
        
        // Hitung total per item dan subtotal
        // Menggunakan struktur keputusan 'if' untuk mengecek pesanan yang valid
        if (pesanan1 != null && qty1 > 0) {
            double totalItem = pesanan1.getHarga() * qty1;
            subTotal += totalItem;
            System.out.printf("%-15s %d x Rp %,d = Rp %,.0f\n", pesanan1.getNama(), qty1, pesanan1.getHarga(), totalItem);
        }
        if (pesanan2 != null && qty2 > 0) {
            double totalItem = pesanan2.getHarga() * qty2;
            subTotal += totalItem;
            System.out.printf("%-15s %d x Rp %,d = Rp %,.0f\n", pesanan2.getNama(), qty2, pesanan2.getHarga(), totalItem);
        }
        if (pesanan3 != null && qty3 > 0) {
            double totalItem = pesanan3.getHarga() * qty3;
            subTotal += totalItem;
            System.out.printf("%-15s %d x Rp %,d = Rp %,.0f\n", pesanan3.getNama(), qty3, pesanan3.getHarga(), totalItem);
        }
        if (pesanan4 != null && qty4 > 0) {
            double totalItem = pesanan4.getHarga() * qty4;
            subTotal += totalItem;
            System.out.printf("%-15s %d x Rp %,d = Rp %,.0f\n", pesanan4.getNama(), qty4, pesanan4.getHarga(), totalItem);
        }

        System.out.println("----------------------------------------");
        System.out.printf("Subtotal              : Rp %,.0f\n", subTotal);

        // Struktur Keputusan untuk Diskon dan Penawaran

        // 1. Penawaran Beli 1 Gratis 1 Minuman (jika total > 50.000)
        if (subTotal > 50000) {
            // Cek manual pesanan mana yang minuman (tanpa loop)
            if (pesanan1 != null && pesanan1.getKategori().equals("Minuman")) {
                dapatBogo = true;
                namaBogo = pesanan1.getNama();
                hargaBogo = pesanan1.getHarga();
            } else if (pesanan2 != null && pesanan2.getKategori().equals("Minuman")) {
                dapatBogo = true;
                namaBogo = pesanan2.getNama();
                hargaBogo = pesanan2.getHarga();
            } else if (pesanan3 != null && pesanan3.getKategori().equals("Minuman")) {
                dapatBogo = true;
                namaBogo = pesanan3.getNama();
                hargaBogo = pesanan3.getHarga();
            } else if (pesanan4 != null && pesanan4.getKategori().equals("Minuman")) {
                dapatBogo = true;
                namaBogo = pesanan4.getNama();
                hargaBogo = pesanan4.getHarga();
            }
        }
        
        // 2. Diskon 10% (jika total > 100.000) 
        if (subTotal > 100000) {
            diskon = subTotal * 0.10;
            System.out.printf("Diskon (10%%)            : - Rp %,.0f\n", diskon); 
        }

        // 3. Menampilkan info BOGO jika dapat
        if (dapatBogo) {
            System.out.printf("Promo BOGO (%s)   : - Rp %,d\n", namaBogo, hargaBogo);
        }

        // Perhitungan Pajak dan Biaya Pelayanan
        double pajak = (subTotal - diskon) * 0.10;
        System.out.printf("Pajak (10%%)             : Rp %,.0f\n", pajak);
        System.out.printf("Biaya Pelayanan       : Rp %,.0f\n", biayaPelayanan);

        // Total Keseluruhan
        double grandTotal = subTotal - diskon - (dapatBogo ? hargaBogo : 0) + pajak + biayaPelayanan;
        
        System.out.println("----------------------------------------");
        System.out.printf("TOTAL PEMBAYARAN      : Rp %,.0f\n", grandTotal);
        System.out.println("========================================");
        System.out.println("Terima kasih atas kunjungan Anda!");
    }
}
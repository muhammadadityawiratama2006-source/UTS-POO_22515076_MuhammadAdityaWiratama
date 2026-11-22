import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // Atribut sesuai Class Diagram
    private static Bengkel bengkel;
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        bengkel = new Bengkel("Bengkel Maju Jaya", 10);

        // Data awal (contoh) agar program langsung siap diuji
        bengkel.tambahKendaraan(new Kendaraan("DT 1234 AB", "Toyota Avanza", 2020));
        bengkel.tambahKendaraan(new Kendaraan("DT 5678 CD", "Honda Vario 160", 2022));
        bengkel.tambahMekanik(new Mekanik("MK-001", "Budi Santoso", "Mesin & Tune Up"));
        bengkel.tambahMekanik(new Mekanik("MK-002", "Andi Pratama", "Kelistrikan & Rem"));

        int pilihan = -1;
        while (pilihan != 0) {
            tampilkanMenu();
            System.out.print("Pilih menu (0-8): ");
            if (scanner.hasNextInt()) {
                pilihan = scanner.nextInt();
                scanner.nextLine(); // membersihkan newline
            } else {
                System.out.println("Input tidak valid! Masukkan angka 0-8.");
                scanner.nextLine();
                continue;
            }

            System.out.println();
            switch (pilihan) {
                case 1:
                    menuTambahKendaraan();
                    break;
                case 2:
                    menuTambahMekanik();
                    break;
                case 3:
                    menuDaftarkanServis();
                    break;
                case 4:
                    bengkel.getAntreanServis().tampilkanAntrean();
                    break;
                case 5:
                    menuProsesServis();
                    break;
                case 6:
                    menuSelesaikanServis();
                    break;
                case 7:
                    System.out.print("Masukkan kata kunci pencarian (plat/nama/kode servis): ");
                    String kataKunci = scanner.nextLine();
                    bengkel.cariData(kataKunci);
                    break;
                case 8:
                    bengkel.tampilkanRingkasan();
                    break;
                case 0:
                    System.out.println("Terima kasih telah menggunakan sistem " + bengkel.getNamaBengkel() + ".");
                    break;
                default:
                    System.out.println("Pilihan menu tidak tersedia.");
            }
            System.out.println();
        }

        scanner.close();
    }

    // Method sesuai Class Diagram
    public static void tampilkanMenu() {
        System.out.println("==========================================");
        System.out.println("SISTEM MANAJEMEN " + bengkel.getNamaBengkel().toUpperCase());
        System.out.println("==========================================");
        System.out.println("1. Tambah Data Kendaraan");
        System.out.println("2. Tambah Data Mekanik");
        System.out.println("3. Daftarkan Servis ke Antrean");
        System.out.println("4. Lihat Antrean Servis");
        System.out.println("5. Proses Servis Berikutnya");
        System.out.println("6. Selesaikan Servis");
        System.out.println("7. Cari Data");
        System.out.println("8. Tampilkan Ringkasan Bengkel");
        System.out.println("0. Keluar");
        System.out.println("==========================================");
    }

    private static void menuTambahKendaraan() {
        System.out.print("Masukkan Plat Nomor     : ");
        String plat = scanner.nextLine();
        System.out.print("Masukkan Merk & Tipe    : ");
        String merk = scanner.nextLine();
        System.out.print("Masukkan Tahun Produksi : ");
        int tahun = scanner.nextInt();
        scanner.nextLine();

        bengkel.tambahKendaraan(new Kendaraan(plat, merk, tahun));
        System.out.println("Kendaraan berhasil ditambahkan!");
    }

    private static void menuTambahMekanik() {
        System.out.print("Masukkan ID Mekanik   : ");
        String id = scanner.nextLine();
        System.out.print("Masukkan Nama Mekanik : ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Spesialisasi : ");
        String spesialis = scanner.nextLine();

        bengkel.tambahMekanik(new Mekanik(id, nama, spesialis));
        System.out.println("Mekanik berhasil ditambahkan!");
    }

    private static void menuDaftarkanServis() {
        ArrayList<Kendaraan> listKendaraan = bengkel.getDaftarKendaraan();
        ArrayList<Mekanik> listMekanik = bengkel.getDaftarMekanik();

        if (listKendaraan.isEmpty() || listMekanik.isEmpty()) {
            System.out.println("Data kendaraan atau mekanik masih kosong!");
            return;
        }

        System.out.print("Masukkan Kode Servis (contoh: SRV-001): ");
        String kode = scanner.nextLine();

        System.out.println("\nPilih Kendaraan:");
        for (int i = 0; i < listKendaraan.size(); i++) {
            Kendaraan k = listKendaraan.get(i);
            System.out.println((i + 1) + ". " + k.getMerkTipe() + " (" + k.getPlatNomor() + ")");
        }
        System.out.print("Nomor kendaraan: ");
        int idxKendaraan = scanner.nextInt() - 1;
        scanner.nextLine();

        if (idxKendaraan < 0 || idxKendaraan >= listKendaraan.size()) {
            System.out.println("Nomor kendaraan tidak valid.");
            return;
        }

        System.out.println("\nPilih Mekanik:");
        for (int i = 0; i < listMekanik.size(); i++) {
            Mekanik m = listMekanik.get(i);
            String status = m.isSedangBertugas() ? "Sedang Bertugas" : "Tersedia";
            System.out.println((i + 1) + ". " + m.getNamaMekanik() + " - " + m.getSpesialisasi() + " [" + status + "]");
        }
        System.out.print("Nomor mekanik: ");
        int idxMekanik = scanner.nextInt() - 1;
        scanner.nextLine();

        if (idxMekanik < 0 || idxMekanik >= listMekanik.size()) {
            System.out.println("Nomor mekanik tidak valid.");
            return;
        }

        System.out.print("Masukkan Biaya Jasa (Rp)        : ");
        double biayaJasa = scanner.nextDouble();
        System.out.print("Masukkan Biaya Suku Cadang (Rp) : ");
        double biayaSukuCadang = scanner.nextDouble();
        scanner.nextLine();

        Servis servisBaru = new Servis(
            kode,
            listKendaraan.get(idxKendaraan),
            listMekanik.get(idxMekanik),
            biayaJasa,
            biayaSukuCadang
        );

        if (bengkel.daftarkanServis(servisBaru)) {
            System.out.println("Servis berhasil didaftarkan ke dalam antrean!");
        } else {
            System.out.println("Gagal mendaftarkan servis! Antrean sudah penuh.");
        }
    }

    private static void menuProsesServis() {
        Servis diproses = bengkel.prosesServisBerikutnya();
        if (diproses == null) {
            System.out.println("Tidak ada servis di dalam antrean.");
        } else {
            System.out.println("Memproses servis terdepan:");
            diproses.tampilkanDetailServis();
        }
    }

    private static void menuSelesaikanServis() {
        System.out.print("Masukkan Kode Servis yang sudah selesai: ");
        String kode = scanner.nextLine();
        if (bengkel.selesaikanServis(kode)) {
            System.out.println("Servis dengan kode " + kode + " telah ditandai SELESAI.");
        } else {
            System.out.println("Kode servis tidak ditemukan atau sudah selesai sebelumnya.");
        }
    }
}

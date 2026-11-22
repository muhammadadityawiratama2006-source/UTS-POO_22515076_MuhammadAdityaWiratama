import java.util.ArrayList;

public class Bengkel {
    // Atribut sesuai Class Diagram
    private String namaBengkel;
    private ArrayList<Kendaraan> daftarKendaraan;
    private ArrayList<Mekanik> daftarMekanik;
    private ArrayList<Servis> riwayatServis;
    private AntreanServisQueue antreanServis;

    // Constructor default
    public Bengkel() {
        this.namaBengkel = "Bengkel Utama";
        this.daftarKendaraan = new ArrayList<>();
        this.daftarMekanik = new ArrayList<>();
        this.riwayatServis = new ArrayList<>();
        this.antreanServis = new AntreanServisQueue(10);
    }

    // Constructor berparameter
    public Bengkel(String namaBengkel, int kapasitasAntrean) {
        this.namaBengkel = namaBengkel;
        this.daftarKendaraan = new ArrayList<>();
        this.daftarMekanik = new ArrayList<>();
        this.riwayatServis = new ArrayList<>();
        this.antreanServis = new AntreanServisQueue(kapasitasAntrean);
    }

    // Method sesuai Class Diagram
    public void tambahKendaraan(Kendaraan k) {
        if (k != null) {
            daftarKendaraan.add(k);
        }
    }

    public void tambahMekanik(Mekanik m) {
        if (m != null) {
            daftarMekanik.add(m);
        }
    }

    public boolean daftarkanServis(Servis s) {
        if (s == null || antreanServis.isFull()) {
            return false;
        }
        boolean berhasilMasuk = antreanServis.enqueue(s);
        if (berhasilMasuk) {
            riwayatServis.add(s);
        }
        return berhasilMasuk;
    }

    public Servis prosesServisBerikutnya() {
        Servis berikutnya = antreanServis.dequeue();
        if (berikutnya != null) {
            berikutnya.prosesServis();
        }
        return berikutnya;
    }

    public boolean selesaikanServis(String kodeServis) {
        for (Servis s : riwayatServis) {
            if (s.getKodeServis().equalsIgnoreCase(kodeServis) && !s.getStatusServis().equalsIgnoreCase("Selesai")) {
                s.selesaikanServis();
                return true;
            }
        }
        return false;
    }

    public void cariData(String kataKunci) {
        String key = kataKunci.toLowerCase();
        boolean ditemukan = false;

        System.out.println("=== Hasil Pencarian: \"" + kataKunci + "\" ===");

        for (Kendaraan k : daftarKendaraan) {
            if (k.getPlatNomor().toLowerCase().contains(key) || k.getMerkTipe().toLowerCase().contains(key)) {
                System.out.println("[Kendaraan]");
                k.tampilkanInfo();
                System.out.println("---------------------------");
                ditemukan = true;
            }
        }

        for (Mekanik m : daftarMekanik) {
            if (m.getIdMekanik().toLowerCase().contains(key) || m.getNamaMekanik().toLowerCase().contains(key)
                    || m.getSpesialisasi().toLowerCase().contains(key)) {
                System.out.println("[Mekanik]");
                m.tampilkanInfo();
                System.out.println("---------------------------");
                ditemukan = true;
            }
        }

        for (Servis s : riwayatServis) {
            if (s.getKodeServis().toLowerCase().contains(key) || s.getStatusServis().toLowerCase().contains(key)) {
                System.out.println("[Servis]");
                s.tampilkanDetailServis();
                System.out.println("---------------------------");
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Data dengan kata kunci \"" + kataKunci + "\" tidak ditemukan.");
        }
    }

    public void tampilkanRingkasan() {
        double totalPendapatan = 0.0;
        int jumlahSelesai = 0;

        for (Servis s : riwayatServis) {
            if (s.getStatusServis().equalsIgnoreCase("Selesai")) {
                totalPendapatan += s.hitungTotalBiaya();
                jumlahSelesai++;
            }
        }

        System.out.println("==========================================");
        System.out.println("RINGKASAN DATA - " + namaBengkel.toUpperCase());
        System.out.println("==========================================");
        System.out.println("Total Kendaraan Terdaftar : " + daftarKendaraan.size());
        System.out.println("Total Mekanik             : " + daftarMekanik.size());
        System.out.println("Servis dalam Antrean      : " + antreanServis.size());
        System.out.println("Total Riwayat Servis      : " + riwayatServis.size());
        System.out.println("Servis Selesai            : " + jumlahSelesai);
        System.out.println("Total Pendapatan Selesai  : Rp " + totalPendapatan);
        System.out.println("==========================================");
    }

    // Getter pendukung untuk Main
    public String getNamaBengkel() {
        return namaBengkel;
    }

    public ArrayList<Kendaraan> getDaftarKendaraan() {
        return daftarKendaraan;
    }

    public ArrayList<Mekanik> getDaftarMekanik() {
        return daftarMekanik;
    }

    public ArrayList<Servis> getRiwayatServis() {
        return riwayatServis;
    }

    public AntreanServisQueue getAntreanServis() {
        return antreanServis;
    }
}

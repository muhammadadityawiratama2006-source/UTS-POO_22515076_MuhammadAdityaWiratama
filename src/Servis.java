public class Servis {
    // Atribut (Encapsulation)
    private String kodeServis;
    private Kendaraan kendaraan;
    private Mekanik mekanik;
    private double biayaJasa;
    private double biayaSukuCadang;
    private String statusServis;

    // Constructor default
    public Servis() {
        this.kodeServis = "SRV-000";
        this.kendaraan = null;
        this.mekanik = null;
        this.biayaJasa = 0.0;
        this.biayaSukuCadang = 0.0;
        this.statusServis = "Menunggu";
    }

    // Constructor berparameter
    public Servis(String kodeServis, Kendaraan kendaraan, Mekanik mekanik, double biayaJasa, double biayaSukuCadang) {
        this.kodeServis = kodeServis;
        this.kendaraan = kendaraan;
        this.mekanik = mekanik;
        this.biayaJasa = biayaJasa;
        this.biayaSukuCadang = biayaSukuCadang;
        this.statusServis = "Menunggu";
    }

    // Method sesuai Class Diagram
    public double hitungTotalBiaya() {
        return biayaJasa + biayaSukuCadang;
    }

    public void prosesServis() {
        this.statusServis = "Sedang Diproses";
        if (kendaraan != null) {
            kendaraan.ubahStatusServis(true);
        }
        if (mekanik != null) {
            mekanik.tugaskanServis();
        }
    }

    public void selesaikanServis() {
        this.statusServis = "Selesai";
        if (kendaraan != null) {
            kendaraan.ubahStatusServis(false);
        }
        if (mekanik != null) {
            mekanik.selesaikanTugas();
        }
    }

    public void tampilkanDetailServis() {
        System.out.println("Kode Servis      : " + kodeServis);
        if (kendaraan != null) {
            System.out.println("Kendaraan        : " + kendaraan.getMerkTipe() + " (" + kendaraan.getPlatNomor() + ")");
        }
        if (mekanik != null) {
            System.out.println("Mekanik          : " + mekanik.getNamaMekanik() + " [" + mekanik.getSpesialisasi() + "]");
        }
        System.out.println("Biaya Jasa       : Rp " + biayaJasa);
        System.out.println("Biaya Suku Cadang: Rp " + biayaSukuCadang);
        System.out.println("Total Biaya      : Rp " + hitungTotalBiaya());
        System.out.println("Status Servis    : " + statusServis);
    }

    // Getter
    public String getKodeServis() {
        return kodeServis;
    }

    public Kendaraan getKendaraan() {
        return kendaraan;
    }

    public Mekanik getMekanik() {
        return mekanik;
    }

    public double getBiayaJasa() {
        return biayaJasa;
    }

    public double getBiayaSukuCadang() {
        return biayaSukuCadang;
    }

    public String getStatusServis() {
        return statusServis;
    }
}

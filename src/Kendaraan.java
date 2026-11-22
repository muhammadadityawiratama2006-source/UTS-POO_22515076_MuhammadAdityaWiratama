public class Kendaraan {
    // Atribut (Encapsulation)
    private String platNomor;
    private String merkTipe;
    private int tahunProduksi;
    private boolean sedangDiservis;

    // Constructor default
    public Kendaraan() {
        this.platNomor = "-";
        this.merkTipe = "Tidak Diketahui";
        this.tahunProduksi = 2000;
        this.sedangDiservis = false;
    }

    // Constructor berparameter
    public Kendaraan(String platNomor, String merkTipe, int tahunProduksi) {
        this.platNomor = platNomor;
        this.merkTipe = merkTipe;
        this.tahunProduksi = tahunProduksi;
        this.sedangDiservis = false;
    }

    // Method sesuai Class Diagram
    public void tampilkanInfo() {
        String status = sedangDiservis ? "Sedang Diservis" : "Siap / Selesai Servis";
        System.out.println("Plat Nomor     : " + platNomor);
        System.out.println("Merk & Tipe    : " + merkTipe);
        System.out.println("Tahun Produksi : " + tahunProduksi);
        System.out.println("Status         : " + status);
    }

    public void ubahStatusServis(boolean status) {
        this.sedangDiservis = status;
    }

    public boolean isSiapServis() {
        return !this.sedangDiservis;
    }

    // Getter
    public String getPlatNomor() {
        return platNomor;
    }

    public String getMerkTipe() {
        return merkTipe;
    }

    public int getTahunProduksi() {
        return tahunProduksi;
    }

    public boolean isSedangDiservis() {
        return sedangDiservis;
    }
}

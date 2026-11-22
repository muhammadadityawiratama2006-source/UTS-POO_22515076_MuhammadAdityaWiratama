public class Mekanik {
    // Atribut (Encapsulation)
    private String idMekanik;
    private String namaMekanik;
    private String spesialisasi;
    private boolean sedangBertugas;

    // Constructor default
    public Mekanik() {
        this.idMekanik = "MK-000";
        this.namaMekanik = "Belum Ditentukan";
        this.spesialisasi = "Umum";
        this.sedangBertugas = false;
    }

    // Constructor berparameter
    public Mekanik(String idMekanik, String namaMekanik, String spesialisasi) {
        this.idMekanik = idMekanik;
        this.namaMekanik = namaMekanik;
        this.spesialisasi = spesialisasi;
        this.sedangBertugas = false;
    }

    // Method sesuai Class Diagram
    public void tampilkanInfo() {
        String status = sedangBertugas ? "Sedang Bertugas" : "Tersedia";
        System.out.println("ID Mekanik   : " + idMekanik);
        System.out.println("Nama Mekanik : " + namaMekanik);
        System.out.println("Spesialisasi : " + spesialisasi);
        System.out.println("Status       : " + status);
    }

    public void tugaskanServis() {
        this.sedangBertugas = true;
    }

    public void selesaikanTugas() {
        this.sedangBertugas = false;
    }

    // Getter
    public String getIdMekanik() {
        return idMekanik;
    }

    public String getNamaMekanik() {
        return namaMekanik;
    }

    public String getSpesialisasi() {
        return spesialisasi;
    }

    public boolean isSedangBertugas() {
        return sedangBertugas;
    }
}

public class AntreanServisQueue {
    // Atribut sesuai Class Diagram (Struktur Data Circular Queue)
    private Servis[] elemen;
    private int front;
    private int rear;
    private int jumlah;
    private int kapasitas;

    // Constructor
    public AntreanServisQueue(int kapasitas) {
        this.kapasitas = kapasitas;
        this.elemen = new Servis[kapasitas];
        this.front = 0;
        this.rear = -1;
        this.jumlah = 0;
    }

    // Menambahkan servis ke antrean (Enqueue)
    public boolean enqueue(Servis data) {
        if (isFull()) {
            return false;
        }
        rear = (rear + 1) % kapasitas;
        elemen[rear] = data;
        jumlah++;
        return true;
    }

    // Mengambil servis terdepan dari antrean (Dequeue)
    public Servis dequeue() {
        if (isEmpty()) {
            return null;
        }
        Servis temp = elemen[front];
        elemen[front] = null;
        front = (front + 1) % kapasitas;
        jumlah--;
        return temp;
    }

    // Melihat servis terdepan tanpa menghapusnya
    public Servis front() {
        if (isEmpty()) {
            return null;
        }
        return elemen[front];
    }

    public boolean isEmpty() {
        return jumlah == 0;
    }

    public boolean isFull() {
        return jumlah == kapasitas;
    }

    public int size() {
        return jumlah;
    }

    public void tampilkanAntrean() {
        if (isEmpty()) {
            System.out.println("Antrean servis saat ini kosong.");
            return;
        }
        System.out.println("=== Daftar Antrean Servis (" + jumlah + "/" + kapasitas + ") ===");
        for (int i = 0; i < jumlah; i++) {
            int index = (front + i) % kapasitas;
            Servis s = elemen[index];
            System.out.print((i + 1) + ". [" + s.getKodeServis() + "] ");
            if (s.getKendaraan() != null) {
                System.out.print(s.getKendaraan().getMerkTipe() + " (" + s.getKendaraan().getPlatNomor() + ")");
            }
            System.out.println(" - Status: " + s.getStatusServis());
        }
    }
}

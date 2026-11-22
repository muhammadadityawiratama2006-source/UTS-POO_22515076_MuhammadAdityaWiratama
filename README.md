# Sistem Manajemen Bengkel (UTS Pemrograman Berorientasi Objek)

Proyek aplikasi konsol berbasis Java yang menerapkan konsep Pemrograman Berorientasi Objek (Encapsulation, Composition/Aggregation, dan Struktur Data Queue) untuk mengelola operasional bengkel kendaraan.

## Identitas Mahasiswa
* **Nama:** Muhammad Aditya Wiratama
* **NIM:** 22515076
* **Mata Kuliah:** Pemrograman Berorientasi Objek (POO)

---

## Class Diagram UML
![Class Diagram Bengkel](Diagram%20Tanpa%20Judul.drawio.png)

---

## Struktur Class (`src/`)
1. **`Kendaraan.java`** — Merepresentasikan data kendaraan pelanggan (plat nomor, merk/tipe, tahun produksi, dan status servis).
2. **`Mekanik.java`** — Merepresentasikan data teknisi/mekanik bengkel beserta spesialisasi dan status tugasnya.
3. **`Servis.java`** — Menghubungkan objek `Kendaraan` dan `Mekanik`, menghitung total biaya (jasa + suku cadang), serta mengatur status pengerjaan servis.
4. **`AntreanServisQueue.java`** — Implementasi struktur data *Circular Queue* berbasis array untuk mengatur urutan antrean servis (FIFO).
5. **`Bengkel.java`** — Class pengelola utama yang menyimpan daftar kendaraan, daftar mekanik, riwayat servis, antrean servis, fitur pencarian, serta ringkasan pendapatan.
6. **`Main.java`** — Titik masuk utama program (*entry point*) dengan menu interaktif berbasis konsol.

---

## Cara Menjalankan Program
Pastikan **Java Development Kit (JDK)** sudah terpasang di komputer Anda, lalu jalankan perintah berikut melalui terminal/CMD di folder utama repositori:

```bash
javac src/*.java
java -cp src Main

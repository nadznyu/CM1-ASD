public class Buku {
    String kodeBuku;
    String judul;
    int tahunTerbit;

    Buku(String kode, String judul, int tahun) {
        this.kodeBuku = kode;
        this.judul = judul;
        this.tahunTerbit = tahun;
    }

    void tampilBuku() {
        System.out.println("Kode    : " + kodeBuku);
        System.out.println("Judul   : " + judul);
        System.out.println("Tahun   : " + tahunTerbit);
        System.out.println("----------------------------------");

    }
}
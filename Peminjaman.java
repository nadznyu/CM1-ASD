public class Peminjaman {
    Mahasiswa mhs;
    Buku buku;
    int lamaPinjam;
    int batasPinjam = 5;
    int terlambat;
    int denda;

    Peminjaman(Mahasiswa mhs, Buku buku, int lamaPinjam) {
        this.mhs = mhs;
        this.buku = buku;
        this.lamaPinjam = lamaPinjam;
        hitungDenda();
    }

    void hitungDenda() {
        if (lamaPinjam > batasPinjam) {
            terlambat = lamaPinjam - batasPinjam;
            denda = terlambat * 2000;
        } else {
            terlambat = 0;
            denda = 0;
        }
    }

    void tampilPeminjaman() {
        System.out.println("Nama       : " + mhs.nama);
        System.out.println("Judul Buku : " + buku.judul);
        System.out.println("Lama       : " + lamaPinjam);
        System.out.println("Terlambat  : " + terlambat);
        System.out.println("Denda      : " + denda);
        System.out.println("----------------------------------");
    }
}

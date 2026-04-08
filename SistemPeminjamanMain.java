import java.util.Scanner;

public class SistemPeminjamanMain {

    static Peminjaman[] insertionSort(Peminjaman[] data) {
        Peminjaman[] sorted = new Peminjaman[data.length];
        for (int i = 0; i < data.length; i++)
            sorted[i] = data[i];

        for (int i = 1; i < sorted.length; i++) {
            Peminjaman key = sorted[i];
            int j = i - 1;
            while (j >= 0 && sorted[j].denda < key.denda) {
                sorted[j + 1] = sorted[j];
                j--;
            }
            sorted[j + 1] = key;
        }
        return sorted;
    }

    static void binarySeacrh(Peminjaman[] data, String nimCari) {
        Peminjaman[] sorted = new Peminjaman[data.length];
        for (int i = 0; i < data.length; i++) {
            sorted[i] = data[i];
        }
        for (int i = 1; i < sorted.length; i++) {
            Peminjaman key = sorted[i];
            int j = i - 1;
            while (j >= 0 && sorted[j].mhs.nim.compareTo(key.mhs.nim) > 0) {
                sorted[j + 1] = sorted[j];
                j--;
            }
            sorted[j + 1] = key;
        }

        int bawah = 0;
        int atas = sorted.length - 1;
        int found = -1;

        while (bawah <= atas) {
            int tengah = (bawah + atas) / 2;
            int cmp = sorted[tengah].mhs.nim.compareTo(nimCari);
            if (cmp == 0) {
                found = tengah;
                break;
            } else if (cmp < 0) {
                bawah = tengah + 1;
            } else {
                atas = tengah - 1;
            }
        }

        if (found == -1) {
            System.out.println("Data peminjaman buku dengan NIM " + nimCari + " tidak ditemukan.");
        } else {
            System.out.println("Hasil pencarian NIM : " + nimCari);

            int idx = found;
            while (idx > 0 && sorted[idx - 1].mhs.nim.equals(nimCari)) {
                idx--;
            }

            boolean adaHasil = false;
            for (int i = idx; i < sorted.length; i++) {
                if (sorted[i].mhs.nim.equals(nimCari)) {
                    sorted[i].tampilPeminjaman();
                    adaHasil = true;
                } else if (adaHasil) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Mahasiswa[] mahasiswas = {
                new Mahasiswa("22001", "Andi", "Teknik Informatika"),
                new Mahasiswa("22002", "Budi", "Teknik Informatika"),
                new Mahasiswa("22003", "Citra", "Sistem Informasi Bisnis")
        };

        Buku[] bukus = {
                new Buku("B001", "Algoritma", 2020),
                new Buku("B002", "Basis Data", 2019),
                new Buku("B003", "Pemrograman", 2021),
                new Buku("B004", "Fisika", 2024)
        };

        Peminjaman[] peminjamans = {
                new Peminjaman(mahasiswas[0], bukus[0], 7),
                new Peminjaman(mahasiswas[1], bukus[1], 3),
                new Peminjaman(mahasiswas[2], bukus[2], 10),
                new Peminjaman(mahasiswas[2], bukus[3], 6),
                new Peminjaman(mahasiswas[0], bukus[1], 4)
        };

        int pilih = -1;
        while (pilih != 0) {
            System.out.println("\n=== SISTEM PEMINJAMAN BUKU RUANG BACA JTI ===");
            System.out.println("1. Tampilkan Mahasiswa");
            System.out.println("2. Tampilkan Buku");
            System.out.println("3. Tampilkan Peminjaman");
            System.out.println("4. Urutkan Berdasarkan Denda");
            System.out.println("5. Cari Berdasarkan NIM");
            System.out.println("0. Keluar");
            System.out.print("Pilih : ");
            pilih = sc.nextInt();

            switch (pilih) {
                case 1:
                    System.out.println("\n=== DAFTAR MAHASISWA ===");
                    for (Mahasiswa m : mahasiswas)
                        m.tampilMahasiswa();
                    break;
                case 2:
                    System.out.println("\n=== DAFTAR BUKU ===");
                    for (Buku b : bukus)
                        b.tampilBuku();
                    break;
                case 3:
                    System.out.println("\n=== DATA PEMINJAMAN ===");
                    for (Peminjaman p : peminjamans)
                        p.tampilPeminjaman();
                    break;
                case 4:
                    System.out.println("\nSetelah diurutkan (Denda Terbanyak): ");
                    Peminjaman[] sorted = insertionSort(peminjamans);
                    for (Peminjaman p : sorted)
                        p.tampilPeminjaman();
                    break;
                case 5:
                    System.out.print("Masukkan NIM : ");
                    sc.nextLine();
                    String nim = sc.nextLine();
                    binarySeacrh(peminjamans, nim);
                    break;
                case 0:
                    System.out.println("Program telah selesai!");
                    break;
                default:
                    System.out.println("Pilihan tidak ada di menu!");
            }
        }
        sc.close();
    }

}

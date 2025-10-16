package soal3;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class Soal3Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();

        int pilihan;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa berdasarkan NIM");
            System.out.println("3. Cari Mahasiswa berdasarkan NIM");
            System.out.println("4. Tampilkan Daftar Mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");

            try {
                pilihan = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                pilihan = -1;
            }


            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Nama Mahasiswa: ");
                    String nama = scanner.nextLine();
                    String nim;
                    while (true) {
                        System.out.print("Masukkan NIM Mahasiswa (harus unik): ");
                        nim = scanner.nextLine();
                        boolean isUnique = true;
                        for (Mahasiswa mhs : daftarMahasiswa) {
                            if (mhs.getNim().equals(nim)) {
                                isUnique = false;
                                break;
                            }
                        }
                        if (isUnique) {
                            break;
                        } else {
                            System.out.println("NIM sudah terdaftar. Silakan masukkan NIM yang lain.");
                        }
                    }
                    daftarMahasiswa.add(new Mahasiswa(nama, nim));
                    System.out.println("Mahasiswa " + nama + " ditambahkan.");
                    break;

                case 2:
                    System.out.print("Masukkan NIM Mahasiswa yang akan dihapus: ");
                    String nimHapus = scanner.nextLine();
                    boolean ditemukan = false;
                    Iterator<Mahasiswa> iterator = daftarMahasiswa.iterator();
                    while (iterator.hasNext()) {
                        Mahasiswa mhs = iterator.next();
                        if (mhs.getNim().equals(nimHapus)) {
                            iterator.remove();
                            ditemukan = true;
                            System.out.println("Mahasiswa dengan NIM " + nimHapus + " dihapus.");
                            break;
                        }
                    }
                    if (!ditemukan) {
                        System.out.println("Mahasiswa dengan NIM " + nimHapus + " tidak ditemukan.");
                    }
                    break;

                case 3:
                    System.out.print("Masukkan NIM Mahasiswa yang akan dicari: ");
                    String nimCari = scanner.nextLine();
                    boolean ketemu = false;
                    for (Mahasiswa mhs : daftarMahasiswa) {
                        if (mhs.getNim().equals(nimCari)) {
                            System.out.println("Data Mahasiswa ditemukan:");
                            System.out.println("NIM: " + mhs.getNim() + ", Nama: " + mhs.getNama());
                            ketemu = true;
                            break;
                        }
                    }
                    if (!ketemu) {
                        System.out.println("Mahasiswa dengan NIM " + nimCari + " tidak ditemukan.");
                    }
                    break;

                case 4:
                    if (daftarMahasiswa.isEmpty()) {
                        System.out.println("Daftar Mahasiswa kosong.");
                    } else {
                        System.out.println("Daftar Mahasiswa:");
                        for (Mahasiswa mhs : daftarMahasiswa) {
                            System.out.println("NIM: " + mhs.getNim() + ", Nama: " + mhs.getNama());
                        }
                    }
                    break;

                case 0:
                    System.out.println("Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        } while (pilihan != 0);

        scanner.close();
    }
}
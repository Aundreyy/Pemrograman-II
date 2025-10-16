package soal2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Soal2Main {

    //method untuk memeriksa tahun kabisat
    private static boolean isTahunKabisat(int tahun) {
        return (tahun % 4 == 0 && tahun % 100 != 0) || (tahun % 400 == 0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Negara> negaraList = new LinkedList<>();
        HashMap<Integer, String> bulanMap = new HashMap<>();
        
        // mengisi HashMap untuk nama bulan
        String[] namaBulanArray = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
        for (int i = 0; i < namaBulanArray.length; i++) {
            bulanMap.put(i + 1, namaBulanArray[i]);
        }

        //validasi Jumlah Negara
        int jumlahNegara = 0;
        while (true) {
            System.out.print("Masukkan jumlah negara: ");
            try {
                jumlahNegara = Integer.parseInt(scanner.nextLine());
                if (jumlahNegara > 0) {
                    break; // Input valid, keluar dari loop
                } else {
                    System.out.println("Jumlah negara harus lebih dari 0. Silakan coba lagi.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Harap masukkan sebuah angka.");
            }
        }
        
        System.out.println();

        //Loop untuk Mengumpulkan Info Negara
        for (int i = 0; i < jumlahNegara; i++) {
            System.out.println("--- Masukkan data Negara ke-" + (i + 1) + " ---");
            System.out.print("Masukkan Nama Negara: ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan Jenis Kepemimpinan: ");
            String jenisKepemimpinan = scanner.nextLine();
            System.out.print("Masukkan Nama Pemimpin: ");
            String namaPemimpin = scanner.nextLine();

            int tanggal = 0, bulan = 0, tahun = 0;

            if (!jenisKepemimpinan.equalsIgnoreCase("monarki")) {
                //Validasi Input Tanggal, Bulan, dan Tahun
                while (true) {
                    try {
                        System.out.print("Masukkan Tanggal Kemerdekaan: ");
                        tanggal = Integer.parseInt(scanner.nextLine());
                        System.out.print("Masukkan Bulan Kemerdekaan: ");
                        bulan = Integer.parseInt(scanner.nextLine());
                        System.out.print("Masukkan Tahun Kemerdekaan: ");
                        tahun = Integer.parseInt(scanner.nextLine());

                        // Cek logika tanggal
                        if (tahun > 0 && bulan >= 1 && bulan <= 12) {
                            int maksTanggal = 31;
                            if (bulan == 2) { // Februari
                                maksTanggal = isTahunKabisat(tahun) ? 29 : 28;
                            } else if (bulan == 4 || bulan == 6 || bulan == 9 || bulan == 11) {
                                maksTanggal = 30;
                            }

                            if (tanggal >= 1 && tanggal <= maksTanggal) {
                                break; // Semua data tanggal valid, keluar dari loop
                            } else {
                                System.out.println("Tanggal tidak valid untuk bulan " + namaBulanArray[bulan-1] + ". Maksimal tanggal: " + maksTanggal);
                            }
                        } else {
                             System.out.println("Bulan atau Tahun tidak valid. Pastikan bulan (1-12) dan tahun positif.");
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Input tanggal/bulan/tahun harus berupa angka. Silakan coba lagi.");
                    }
                }
            }
            
            negaraList.add(new Negara(nama, jenisKepemimpinan, namaPemimpin, tanggal, bulan, tahun));
            System.out.println();
        }
        
        // Menampilkan output
        System.out.println("--- Hasil ---");
        for (Negara negara : negaraList) {
            System.out.println("Negara " + negara.getNama() + " mempunyai " + negara.getJenisKepemimpinan() + " bernama " + negara.getNamaPemimpin());
            
            if (!negara.getJenisKepemimpinan().equalsIgnoreCase("monarki")) {
                String namaBulan = bulanMap.get(negara.getBulanKemerdekaan());
                System.out.println("Deklarasi Kemerdekaan pada Tanggal " + negara.getTanggalKemerdekaan() + " " + namaBulan + " " + negara.getTahunKemerdekaan());
            }
        }
        scanner.close();
    }
}
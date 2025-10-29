package soal2;

import java.util.Scanner;
public class Soal2Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Pilih jenis hewan yang ingin diinputkan: ");
        System.out.println("1 = Kucing");
        System.out.println("2 = Anjing");
        System.out.print("Masukkan pilihan: ");
        int choice = input.nextInt();
        input.nextLine();

        if (choice == 1) {
            System.out.print("Nama hewan peliharaan: ");
            String nama = input.nextLine();
            System.out.print("Ras: ");
            String ras = input.nextLine();
            System.out.print("Warna Bulu: ");
            String warna_bulu = input.nextLine();

            Kucing kucing = new Kucing(nama, ras, warna_bulu);
            kucing.TampilkanKucing();
        }
        else if (choice == 2) {
            System.out.print("Nama hewan peliharaan: ");
            String nama = input.nextLine();
            System.out.print("Ras: ");
            String ras = input.nextLine();
            System.out.print("Warna Bulu: ");
            String warna_bulu = input.nextLine();
            System.out.print("Kemampuan : ");
            String inputkemampuan = input.nextLine();
            String[] kemampuan = inputkemampuan.split(",");

            Anjing anjing = new Anjing(nama, ras, warna_bulu, kemampuan);
            anjing.TampilkanAnjing();
        }
        else {
            System.out.println("ERROR : Pilihan tidak valid");
        }
        input.close();
    }
}
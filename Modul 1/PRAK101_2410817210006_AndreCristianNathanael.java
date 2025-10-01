package Modul_1;

import java.util.Scanner;
public class PRAK101_2410817210006_AndreCristianNathanael {
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Masukkan Nama Lengkap: ");
		String nama = input.nextLine();
		
		System.out.print("Masukkan Tempat lahir: ");
		String tempatlahir = input.nextLine();
		
		System.out.print("Masukkan Tanggal Lahir: ");
		int tanggal = input.nextInt();
		while(tanggal < 1 || tanggal > 31) {
		System.out.print("Tanggal tidak valid, masukkan dengan benar (1-31): ");
		tanggal = input.nextInt();
		}
		
		System.out.print("Masukkan Bulan Lahir: ");
		int bulan = input.nextInt();
		while(bulan < 1 || bulan > 12) {
			System.out.print("Bulan tidak valid, silahkan masukkan dengan benar (1-12): ");
			bulan = input.nextInt();
		}
		
		System.out.print("Masukkan Tahun Lahir: ");
		int tahunlahir = input.nextInt();
		
		System.out.print("Masukkan Tinggi Badan: ");
		int tinggibadan = input.nextInt();
		
		System.out.print("Masukkan Berat Badan: ");
		double beratbadan = input.nextDouble();
		
		String[] nama_bulan = {" ","Januari","Februari","Maret","April","Mei",
				"Juni","Juli","Agustus","September","Oktober","November",
				"Desember"
		};
		
		System.out.println("\nNama Lengkap " + nama + ", Lahir di " + tempatlahir
				+ " pada Tanggal " + tanggal + " " + nama_bulan[bulan] + " " + tahunlahir
				+ "\nTinggi Badan: " + tinggibadan + " cm dan Berat Badan "
				+ beratbadan + " kilogram");
		input.close();
	}
}
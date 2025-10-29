package soal1;

import java.util.Scanner;
public class Soal1Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Nama Hewan Peliharaan: ");
		String nama = input.nextLine();
		System.out.println("Ras: ");
		String ras = input.nextLine();
		input.close();
		
		HewanPeliharaan Hewan = new HewanPeliharaan(nama, ras);
		Hewan.Tampilkan();
	}
}
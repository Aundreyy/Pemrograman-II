package Modul_1;

import java.util.Scanner;
public class PRAK105_2410817210006_AndreCristianNathanael {
	public static final double phi =3.14;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		double r, t;
		
		do {
			System.out.print("Masukkan jari-jari: ");
			r = input.nextDouble();
			if (r <= 0) {
				System.out.println("Jari-jari harus lebih dari 0, silahkan masukkan lagi.");
			}
		} while (r <= 0);
		
		do {
			System.out.print("Masukkan Tinggi: ");
			t = input.nextDouble();
			if (t <= 0) {
				System.out.println("Tinggi harus lebih dari 0, silahkan masukkan lagi.");
			}
		} while (t <= 0);
		
		double volume = phi * r * r * t;
		
		System.out.printf("Volume tabung dengan jari-jari %.1f cm\n",r);
		System.out.printf("dan tinggi %.1f cm adalah %.3f m3\n", t, volume);
		
		input.close();
	}

}
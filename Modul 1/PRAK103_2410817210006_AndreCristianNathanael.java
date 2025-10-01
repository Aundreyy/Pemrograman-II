package Modul_1;

import java.util.Scanner;

public class PRAK103_2410817210006_AndreCristianNathanael {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt();
		int awal = input.nextInt();
		
		int i = 0;
		int angka = awal;
		
		do {
			if (angka % 2 != 0) {
				System.out.print(angka);
				i++;
				if (i < N) {
					System.out.print(", ");
				}
			}
			angka++;
		} while (i < N);
		
		input.close();
	}

}
package soal1;

import java.util.Scanner;
public class Soal1Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Masukkan Jumlah Dadu: ");
		int jumlahdadu = input.nextInt();
		
		if(jumlahdadu <= 0) {
			System.out.println("Error: Jumlah dadu harus lebih dari 0.");
		} else {
			Dadu.mulaipermainan(jumlahdadu);
		}
		input.close();
	}

}
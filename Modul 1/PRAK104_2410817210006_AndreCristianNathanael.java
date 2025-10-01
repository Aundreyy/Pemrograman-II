package Modul_1;

import java.util.Scanner;
public class PRAK104_2410817210006_AndreCristianNathanael {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Tangan Abu: ");
		String[] abu = input.nextLine().trim().split("\\s+");
		
		System.out.print("Tangan Bagas: ");
		String[] bagas = input.nextLine().trim().split("\\s+");
		
		int score_abu = 0, score_bagas = 0;
		
		for (int i = 0; i < 3; i++) {
			String a = abu[i];
			String b = bagas[i];
			
			if (a.equals(b)) {
				continue;
			}
			
			if ((a.equals("B") && b.equals("G")) ||
					(a.equals("G") && b.equals("K")) ||
					(a.equals("K") && b.equals("B"))) {
				score_abu++;
			} else {
				score_bagas++;
			}
			
		}
		
		if (score_abu > score_bagas) {
			System.out.println("Abu");
		} else if (score_bagas > score_abu) {
			System.out.println("Bagas");
		} else {
			System.out.println("Seri");
		}
		
		input.close();
		
	}

}
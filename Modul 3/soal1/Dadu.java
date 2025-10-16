package soal1;

import java.util.Random;
import java.util.LinkedList;
public class Dadu {
	private int nilai;
	public Dadu() {
		acakNilai();
	}
	private void acakNilai() {
		this.nilai = new Random().nextInt(6) + 1;
	}
	
	public int getNilai() {
		return nilai;
	}
	public void setNilai(int nilai) {
		this.nilai = nilai;
	}
	
	public static void mulaipermainan(int jumlahdadu) {
		LinkedList<Dadu> semuadadu = new LinkedList<>();
		
		for(int i = 0; i < jumlahdadu;i++) {
			semuadadu.add(new Dadu());
		}
		
		int totalnilai = 0;
		System.out.println("");
		
		for(int i = 0; i < semuadadu.size(); i++) {
			Dadu dadu = semuadadu.get(i);
			int nilaidadu = dadu.getNilai();
			System.out.println("Dadu ke-" + (i + 1) + " bernilai " + nilaidadu);
			totalnilai += nilaidadu;
		}
		System.out.println("Total nilai dadu keseluruhan " + totalnilai);
	}
}
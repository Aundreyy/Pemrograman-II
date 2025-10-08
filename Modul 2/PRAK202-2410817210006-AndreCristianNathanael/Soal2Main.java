package modul_2;

public class Soal2Main {

	public static void main(String[] args) {
		Kopi kopi = new Kopi();
		
		kopi.NamaKopi = "Espresso";
		kopi.Ukuran = "Medium";
		kopi.Harga = 25000;
		
		kopi.Tampilkan();
		kopi.setPembeli("Alice");
		System.out.println("Pembeli Kopi: " + kopi.getPembeli());
		System.out.println("Pajak Kopi: Rp." + kopi.getPajak());
	}

}
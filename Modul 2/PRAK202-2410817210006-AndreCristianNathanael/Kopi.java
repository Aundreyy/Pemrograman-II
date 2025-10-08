package modul_2;

public class Kopi {
	String NamaKopi;
	String Ukuran;
	double Harga;
	String Pembeli;
	
	void Tampilkan() {
			System.out.println("Nama Kopi: " + this.NamaKopi);
			System.out.println("Ukuran: " + this.Ukuran);
			System.out.println("Harga: " + this.Harga);
	}
	
	void setPembeli(String Pembeli) {
		this.Pembeli = Pembeli;
	}
	
	String getPembeli() {
		return this.Pembeli;
	}
	
	double getPajak() {
		return this.Harga * 0.11;
	}
}
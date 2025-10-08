package modul_2;

import java.util.Locale;
public class Buah {
	String NamaBuah;
	double Berat;
	double Harga;
	double JumlahBeli;
	
	public Buah(String NamaBuah, double Berat, double Harga, double JumlahBeli) {
		this.NamaBuah = NamaBuah;
		this.Berat = Berat;
		this.Harga = Harga;
		this.JumlahBeli = JumlahBeli;
	}
	
	public void Tampilkan() {
		double Hargaperkg = this.Harga / this.Berat;
		double Hargasebelumdiskon = this.JumlahBeli * Hargaperkg;
		int Kelipatandiskon = (int) (this.JumlahBeli / 4);
		double Totaldiskon = Kelipatandiskon * (this.Harga * 0.08);
		double Hargasetelahdiskon = Hargasebelumdiskon - Totaldiskon;
		
		System.out.println("Nama Buah: " + this.NamaBuah);
		System.out.println("Berat: " + this.Berat);
		System.out.println("Harga: " + this.Harga);
		System.out.println("Jumlah Beli: " + this.JumlahBeli + " kg");
		System.out.printf(Locale.US,"Harga Sebelum Diskon: Rp%.2f\n",Hargasebelumdiskon);
		System.out.printf(Locale.US,"Total Diskon: Rp%.2f\n",Totaldiskon);
		System.out.printf(Locale.US,"Harga Setelah Diskon: Rp%.2f\n\n",Hargasetelahdiskon);
		
	}
}
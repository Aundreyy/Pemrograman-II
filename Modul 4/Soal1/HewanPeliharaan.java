package soal1;

public class HewanPeliharaan {
	private String nama;
	private String ras;
	
	public HewanPeliharaan(String nama, String ras) {
		this.nama = nama;
		this.ras = ras;
	}
	public String getNama() {
		return nama;
	}
	public String getRas() {
		return ras;
	}
	public void Tampilkan() {
		System.out.println("Detail Hewan Peliharaan: ");
		System.out.println("Nama hewan peliharaanku adalah : " + getNama());
		System.out.println("Dengan ras : " + getRas());
	}
}
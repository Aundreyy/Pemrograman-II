package soal2;

public class HewanPeliharaan2 {
	private String nama, ras;

    public HewanPeliharaan2(String nama, String ras) {
        this.nama = nama;
        this.ras = ras;
    }
    public String getNama() {
        return nama;
    }
    public String getRas() {
        return ras;
    }
    public void Tampilkan(){
        System.out.println("Detail Hewan Peliharaan: ");
        System.out.println("Nama hewan peliharaanku adalah : " + getNama());
        System.out.println("Dengan ras : " + getRas());
    }
}
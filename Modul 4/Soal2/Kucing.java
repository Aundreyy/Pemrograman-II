package soal2;

public class Kucing extends HewanPeliharaan2{
    private String warnabulu;

    public Kucing(String nama, String ras, String warna_bulu) {
        super(nama, ras);
        this.warnabulu = warna_bulu;
    }
    public String getWarnabulu() {
        return warnabulu;
    }

    public void TampilkanKucing(){
        super.Tampilkan();
        System.out.println("Memiliki warna bulu : " + getWarnabulu());
    }
}
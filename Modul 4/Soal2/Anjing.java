package soal2;

public class Anjing extends HewanPeliharaan2{
    private String warnabulu;
    private String[] kemampuan;

    public Anjing(String nama, String ras, String warna_bulu, String[] kemampuan){
        super(nama, ras);
        this.warnabulu = warna_bulu;
        this.kemampuan = kemampuan;
    }
    public String getWarnabulu() {
        return warnabulu;
    }
    public String[] getKemampuan() {
        return kemampuan;
    }
    public void TampilkanAnjing(){
        super.Tampilkan();
        System.out.println("Memiliki warna bulu : " + getWarnabulu());
        System.out.print("Memiliki kemampuan : ");
        if (getKemampuan()!=null){
            for(int i=0;i<getKemampuan().length;i++){
                System.out.print(getKemampuan()[i]);
            }
        }
    }
}
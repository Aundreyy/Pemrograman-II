package modul_2;

//public class Employee {
//Nama class tidak boleh berbeda dengan nama file
public class Pegawai {
	public String nama;
	//public char asal;
	//baris ini akan menyebabkan error karena tipe data asal adalah char, dimana hanya bisa menampung satu karakter
	public String asal;
	public String jabatan;
	public int umur;
	
	public String getNama() {
		return nama;
	}
	
	public String getAsal() {
		return asal;
	}
	
	//public void setJabatan() {
	//baris ini akan meneybabkan error karena setJabatan tidak memiliki parameter untuk menerima input sehingga variabel j tidak terdefinisi
	public void setJabatan(String j) {
		this.jabatan = j;
	}
}
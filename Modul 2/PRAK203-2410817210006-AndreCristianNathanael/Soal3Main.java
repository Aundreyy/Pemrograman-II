package modul_2;

public class Soal3Main {

	public static void main(String[] args) {
		Pegawai p1 = new Pegawai();
		//p1.nama = "Roi"
		//baris ini akan menyebabkan error karena tidak ada titik koma pada akhir baris
		p1.nama = "Roi";
		p1.asal = "Kingdom of Orvel";
		//p1.setJabatan("Assasin");
		//baris ini akan error jika sebelumnya pada file Pegawai.java metode setJabatan tidak diberi parameter
		p1.setJabatan("Assasin");
		p1.umur = 17;
		//menambahakan instansiasi umur agar sesuai dengan output karena variabel umur belum diberi nilai
		
		System.out.println("Nama: " + p1.getNama());
		//"Nama Pegawai: " diubah agar sesuai dengan output soal yaitu "Nama: "
		System.out.println("Asal: " + p1.getAsal());
		System.out.println("Jabatan: " + p1.jabatan);
		System.out.println("Umur: " + p1.umur + " tahun");
		//menambahkan tahun pada akhir baris agar sesuai dengan output
	}

}
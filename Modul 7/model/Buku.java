package model;

import javafx.beans.property.*;

public class Buku {
    private IntegerProperty bukuId;
    private StringProperty judul;
    private StringProperty penulis;
    private DoubleProperty harga;
    private IntegerProperty stok;

    public Buku(int id, String judul, String penulis, double harga, int stok) {
        this.bukuId = new SimpleIntegerProperty(id);
        this.judul = new SimpleStringProperty(judul);
        this.penulis = new SimpleStringProperty(penulis);
        this.harga = new SimpleDoubleProperty(harga);
        this.stok = new SimpleIntegerProperty(stok);
    }

    public Buku(String judul, String penulis, double harga, int stok) {
        this(0, judul, penulis, harga, stok);
    }

    public IntegerProperty bukuIdProperty() {
    		return bukuId;
    	}
    public int getBukuId() {
    		return bukuId.get();
    	}

    public StringProperty judulProperty() {
    		return judul;
    	}
    public String getJudul() {
    		return judul.get();
    	}

    public StringProperty penulisProperty() {
    		return penulis;
    	}
    public String getPenulis() {
    		return penulis.get();
    	}

    public DoubleProperty hargaProperty() {
    		return harga;
    	}
    public double getHarga() {
    		return harga.get();
    	}

    public IntegerProperty stokProperty() {
    		return stok;
    	}
    
    public int getStok() {
    		return stok.get();
    	}

    @Override
    public String toString() {
        return getJudul(); // Agar muncul Judul di ComboBox
    }
}
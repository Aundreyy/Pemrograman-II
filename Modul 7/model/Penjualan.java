package model;

import javafx.beans.property.*;

public class Penjualan {
    private IntegerProperty penjualanId;
    private IntegerProperty jumlah;
    private DoubleProperty totalHarga;
    private StringProperty tanggal;
    private IntegerProperty pelangganId;
    private IntegerProperty bukuId;

    public Penjualan(int id, int jumlah, double total, String tgl, int pId, int bId) {
        this.penjualanId = new SimpleIntegerProperty(id);
        this.jumlah = new SimpleIntegerProperty(jumlah);
        this.totalHarga = new SimpleDoubleProperty(total);
        this.tanggal = new SimpleStringProperty(tgl);
        this.pelangganId = new SimpleIntegerProperty(pId);
        this.bukuId = new SimpleIntegerProperty(bId);
    }

    public Penjualan(int jumlah, double total, String tgl, int pId, int bId) {
        this(0, jumlah, total, tgl, pId, bId);
    }

    public IntegerProperty penjualanIdProperty() {
    		return penjualanId;
    	}
    
    public int getPenjualanId() {
    		return penjualanId.get();
    	}
    
    public IntegerProperty jumlahProperty() {
    		return jumlah;
    	}
    
    public DoubleProperty totalHargaProperty() {
    		return totalHarga;
    	}
    
    public StringProperty tanggalProperty() {
    		return tanggal;
    	}
    
    public IntegerProperty pelangganIdProperty() {
    		return pelangganId;
    	}
    
    public IntegerProperty bukuIdProperty() {
    		return bukuId;
    	}
}
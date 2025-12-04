package model;

import javafx.beans.property.*;

public class Pelanggan {
    private IntegerProperty pelangganId;
    private StringProperty nama;
    private StringProperty email;
    private StringProperty telepon;

    public Pelanggan(int id, String nama, String email, String telepon) {
        this.pelangganId = new SimpleIntegerProperty(id);
        this.nama = new SimpleStringProperty(nama);
        this.email = new SimpleStringProperty(email);
        this.telepon = new SimpleStringProperty(telepon);
    }
    
    // Konstruktor tanpa ID (untuk insert)
    public Pelanggan(String nama, String email, String telepon) {
        this(0, nama, email, telepon);
    }

    public IntegerProperty pelangganIdProperty() {
    		return pelangganId;
    	}
    
    public int getPelangganId() {
    		return pelangganId.get();
    }

    public StringProperty namaProperty() {
    		return nama;
    	}
    
    public String getNama() {
    		return nama.get();
    	}

    public StringProperty emailProperty() {
    		return email;
    	}
    
    public String getEmail() {
    		return email.get();
    	}

    public StringProperty teleponProperty() {
    		return telepon;
    	}
    
    public String getTelepon() {
    		return telepon.get();
    	}

    @Override
    public String toString() {
        return getNama(); // Agar muncul Nama di ComboBox
    }
}
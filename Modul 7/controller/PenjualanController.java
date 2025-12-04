package controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.*;
import service.*;

public class PenjualanController {
    @FXML private ComboBox<Pelanggan> cbPelanggan;
    @FXML private ComboBox<Buku> cbBuku;
    @FXML private TextField txtJumlah;
    @FXML private DatePicker dpTanggal;
    @FXML private TableView<Penjualan> table;
    
    // Kolom tetap bertipe Integer (ID), tapi tampilannya nanti kita ubah jadi String (Nama)
    @FXML private TableColumn<Penjualan, Integer> colPelanggan, colBuku, colJumlah;
    @FXML private TableColumn<Penjualan, Double> colTotal;
    @FXML private TableColumn<Penjualan, String> colTanggal;

    private PenjualanService sJual = new PenjualanService();
    private PelangganService sPel = new PelangganService();
    private BukuService sBuk = new BukuService();

    @FXML public void initialize() {
        // 1. Setup Data Model (ID tetap diambil dari database)
        colPelanggan.setCellValueFactory(c -> 
        c.getValue().pelangganIdProperty().asObject());
        colBuku.setCellValueFactory(c -> 
        c.getValue().bukuIdProperty().asObject());
        colJumlah.setCellValueFactory(c -> 
        c.getValue().jumlahProperty().asObject());
        colTotal.setCellValueFactory(c -> 
        c.getValue().totalHargaProperty().asObject());
        colTanggal.setCellValueFactory(c -> 
        c.getValue().tanggalProperty());

        // 2. Custom Rendering: Mengubah ID menjadi Nama Pelanggan
        colPelanggan.setCellFactory(column -> 
        new TableCell<Penjualan, Integer>() {
            @Override
            protected void updateItem(Integer id, boolean empty) {
                super.updateItem(id, empty);
                if (empty || id == null) {
                    setText(null);
                } else {
                    // Cari nama pelanggan berdasarkan ID
                    setText(getNamaPelanggan(id));
                }
            }
        });

        // 3. Custom Rendering: Mengubah ID menjadi Judul Buku (Agar seragam)
        colBuku.setCellFactory(column -> 
        new TableCell<Penjualan, Integer>() {
            @Override
            protected void updateItem(Integer id, boolean empty) {
                super.updateItem(id, empty);
                if (empty || id == null) {
                    setText(null);
                } else {
                    // Cari judul buku berdasarkan ID
                    setText(getJudulBuku(id));
                }
            }
        });

        load();
    }

    private void load() {
        try {
            // PENTING: Load Data ComboBox DULUAN agar fungsi pencarian nama bisa bekerja
            cbPelanggan.setItems(FXCollections.
            		observableArrayList(sPel.getAll()));
            cbBuku.setItems(FXCollections.
            		observableArrayList(sBuk.getAll()));
            
            // Baru load data tabel
            table.setItems(FXCollections.
            		observableArrayList(sJual.getAll()));
        } catch (Exception e) { e.printStackTrace();
        }
    }

    // --- Helper Methods untuk mencari Nama berdasarkan ID ---
    
    private String getNamaPelanggan(int id) {
        // Loop data di ComboBox untuk mencocokkan ID
        if (cbPelanggan.getItems() != null) {
            for (Pelanggan p : cbPelanggan.getItems()) {
                if (p.getPelangganId() == id) return p.getNama();
            }
        }
        return "ID: " + id; // Fallback jika nama tidak ditemukan
    }

    private String getJudulBuku(int id) {
        if (cbBuku.getItems() != null) {
            for (Buku b : cbBuku.getItems()) {
                if (b.getBukuId() == id) return b.getJudul();
            }
        }
        return "ID: " + id;
    }

    // --- Fitur Add & Delete ---

    @FXML private void add() {
        try {
            Pelanggan p = cbPelanggan.getValue();
            Buku b = cbBuku.getValue();
            
            // Validasi sederhana
            if (p == null || b == null || txtJumlah.getText()
            		.isEmpty() || dpTanggal.getValue() == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Mohon lengkapi semua data!");
                alert.show();
                return;
            }

            int jml = Integer.parseInt(txtJumlah.getText());
            double total = b.getHarga() * jml;
            String tgl = dpTanggal.getValue().toString();
            
            sJual.add(new Penjualan(jml, total, tgl, 
            		p.getPelangganId(), b.getBukuId()));
            load(); // Reload tabel agar data baru muncul
            
            txtJumlah.clear(); // Bersihkan form
        } catch (NumberFormatException e) {
            new Alert(Alert.AlertType.ERROR, 
            		"Jumlah harus angka!").show();
        } catch (Exception e) { e.printStackTrace(); 
        }
    }

    @FXML private void delete() {
        Penjualan p = table.getSelectionModel().
        		getSelectedItem();
        if(p != null) { 
            try { sJual.delete(p.getPenjualanId()); load(); 
            } 
            catch(Exception e) { e.printStackTrace();
            } 
        }
    }
}
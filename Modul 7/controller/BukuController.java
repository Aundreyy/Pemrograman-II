package controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Buku;
import service.BukuService;

public class BukuController {
    @FXML private TextField txtJudul, txtPenulis, txtHarga, txtStok;
    @FXML private TableView<Buku> table;
    @FXML private TableColumn<Buku, String> colJudul, colPenulis;
    @FXML private TableColumn<Buku, Double> colHarga;
    @FXML private TableColumn<Buku, Integer> colStok;
    
    private BukuService service = new BukuService();
    private int selectedId = 0;

    @FXML public void initialize() {
        colJudul.setCellValueFactory(c -> 
        c.getValue().judulProperty());
        colPenulis.setCellValueFactory(c -> 
        c.getValue().penulisProperty());
        colHarga.setCellValueFactory(c -> 
        c.getValue().hargaProperty().asObject());
        colStok.setCellValueFactory(c -> 
        c.getValue().stokProperty().asObject());

        table.getSelectionModel().
        selectedItemProperty().addListener((o, old, n) -> {
            if (n != null) {
                txtJudul.setText(n.getJudul());
                txtPenulis.setText(n.getPenulis());
                txtHarga.setText(String.valueOf(n.getHarga()));
                txtStok.setText(String.valueOf(n.getStok()));
                selectedId = n.getBukuId();
            }
        });
        load();
    }
    
    private void load() { 
        try { 
            table.setItems(FXCollections.
            		observableArrayList(service.getAll())); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
    }
    
    // --- METODE VALIDASI INPUT ---
    private boolean isInputValid() {
        String penulis = txtPenulis.getText();
        String harga = txtHarga.getText();
        String stok = txtStok.getText();

        // 1. Validasi Penulis: Hanya Huruf, Spasi, dan Tanda Petik
        if (!penulis.matches("^[a-zA-Z\\s']+$")) {
            showAlert("Format Penulis Tidak Valid", "Nama Penulis hanya boleh berisi huruf.");
            return false;
        }

        // 2. Validasi Harga: Harus Angka (Bisa Desimal)
        if (!harga.matches("^\\d+(\\.\\d+)?$")) {
            showAlert("Format Harga Tidak Valid", "Harga harus berupa angka yang valid.");
            return false;
        }

        // 3. Validasi Stok: Harus Angka Bulat
        if (!stok.matches("^\\d+$")) {
            showAlert("Format Stok Tidak Valid", "Stok harus berupa angka bulat.");
            return false;
        }

        return true;
    }

    // --- FITUR CRUD ---

    @FXML private void add() {
        // Cek validasi sebelum proses simpan
        if (isInputValid()) {
            try { 
                service.add(new Buku(txtJudul.getText(), txtPenulis.getText(), Double.parseDouble(txtHarga.getText()), Integer.parseInt(txtStok.getText()))); 
                load(); 
                clear(); 
                
                new Alert(Alert.AlertType.INFORMATION, "Buku berhasil ditambahkan!").show();
            } catch (Exception e) { 
                e.printStackTrace(); 
            }
        }
    }
    
    @FXML private void update() {
        // Cek seleksi data dan validasi input
        if (selectedId > 0 && isInputValid()) {
            try { 
                service.update(new Buku(selectedId, txtJudul.getText(), txtPenulis.getText(), Double.parseDouble(txtHarga.getText()), Integer.parseInt(txtStok.getText()))); 
                load(); 
                clear(); 
                
                new Alert(Alert.AlertType.INFORMATION, "Buku berhasil diperbarui!").show();
            } catch (Exception e) { 
                e.printStackTrace(); 
            }
        } else if (selectedId == 0) {
            showAlert("Peringatan", "Pilih buku yang ingin diedit terlebih dahulu.");
        }
    }
    
    @FXML private void delete() { 
        if (selectedId > 0) {
            try { 
                service.delete(selectedId); 
                load(); 
                clear(); 
                
                new Alert(Alert.AlertType.INFORMATION, "Buku berhasil dihapus!").show();
            } catch (Exception e) { 
                e.printStackTrace(); 
            } 
        } else {
            showAlert("Peringatan", "Pilih buku yang ingin dihapus.");
        }
    }
    
    private void clear() { 
        txtJudul.clear(); 
        txtPenulis.clear(); 
        txtHarga.clear(); 
        txtStok.clear(); 
        selectedId = 0; 
        table.getSelectionModel().clearSelection();
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
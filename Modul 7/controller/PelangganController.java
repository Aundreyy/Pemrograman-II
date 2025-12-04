package controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Pelanggan;
import service.PelangganService;

public class PelangganController {
    @FXML private TextField txtNama, txtEmail, txtTelepon;
    @FXML private TableView<Pelanggan> table;
    @FXML private TableColumn<Pelanggan, String> colNama, colEmail, colTelepon;
    @FXML private TableColumn<Pelanggan, Integer> colId;
    
    private PelangganService service = new PelangganService();
    private int selectedId = 0;

    @FXML public void initialize() {
        // Setup kolom tabel
        colId.setCellValueFactory(c -> 
        c.getValue().pelangganIdProperty().asObject());
        colNama.setCellValueFactory(c -> 
        c.getValue().namaProperty());
        colEmail.setCellValueFactory(c -> 
        c.getValue().emailProperty());
        colTelepon.setCellValueFactory(c -> 
        c.getValue().teleponProperty());
        
        // Listener untuk mengambil data saat baris tabel diklik
        table.getSelectionModel().
        selectedItemProperty().addListener((o, old, n) -> {
            if (n != null) {
                txtNama.setText(n.getNama()); 
                txtEmail.setText(n.getEmail()); 
                txtTelepon.setText(n.getTelepon());
                selectedId = n.getPelangganId();
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
        String nama = txtNama.getText();
        String telepon = txtTelepon.getText();

        // Validasi Nama: Hanya boleh huruf, spasi, dan tanda petik satu (')
        if (!nama.matches("^[a-zA-Z\\s']+$")) {
            showAlert("Format Nama Tidak Valid", "Nama hanya boleh berisi huruf. Angka dan simbol tidak diperbolehkan.");
            return false;
        }

        // Validasi Telepon: Hanya boleh angka
        if (!telepon.matches("^\\d+$")) {
            showAlert("Format Telepon Tidak Valid", "Nomor telepon harus berupa angka.");
            return false;
        }

        return true;
    }

    // --- FITUR CRUD ---

    @FXML private void add() {
        // Cek validasi sebelum menyimpan
        if (isInputValid()) {
            try { 
                service.add(new Pelanggan(txtNama.
                		getText(), txtEmail.getText(), txtTelepon.getText())); 
                load(); 
                clear(); 
                
                // Tampilkan pesan sukses
                new Alert(Alert.AlertType.INFORMATION, "Data berhasil ditambahkan!").show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    @FXML private void update() {
        // Cek apakah ada data yang dipilih DAN input valid
        if (selectedId > 0 && isInputValid()) {
            try { 
                service.update(new Pelanggan(selectedId, txtNama.getText(), txtEmail.getText(), txtTelepon.getText())); 
                load(); 
                clear();
                
                new Alert(Alert.AlertType.INFORMATION, "Data berhasil diperbarui!").show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (selectedId == 0) {
            showAlert("Peringatan", "Silakan pilih data yang ingin diedit terlebih dahulu.");
        }
    }
    
    @FXML private void delete() {
        if (selectedId > 0) {
            try { 
                service.delete(selectedId); 
                load(); 
                clear(); 
                
                new Alert(Alert.AlertType.INFORMATION, "Data berhasil dihapus!").show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            showAlert("Peringatan", "Silakan pilih data yang ingin dihapus.");
        }
    }
    
    private void clear() {
        txtNama.clear(); 
        txtEmail.clear(); 
        txtTelepon.clear(); 
        selectedId = 0;
        table.getSelectionModel().clearSelection();
    }

    // Helper untuk menampilkan alert
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
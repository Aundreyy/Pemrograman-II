package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import java.io.IOException;

public class DashboardController {
    @FXML private BorderPane mainPane;
    private void load(String file) {
        try { mainPane.setCenter(FXMLLoader.load(getClass()
.getResource("/views/" + file + ".fxml"))); }
        catch (IOException e) { e.printStackTrace(); }
    }
    @FXML private void showPelanggan() {
    		load("PelangganView");
    	}
    
    @FXML private void showBuku() {
    		load("BukuView");
    	}
    
    @FXML private void showPenjualan() {
    		load("PenjualanView");
    	}
}
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import model.Mahasiswa;
public class MahasiswaController implements Initializable {
	
	@FXML
	private TableView<Mahasiswa> tableView;
	
	@FXML
	private TableColumn<Mahasiswa, String> nimColumn;
	
	@FXML
	private TableColumn<Mahasiswa, String> namaColumn;
	
	@FXML
	private ObservableList<Mahasiswa> dataMahasiswa = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		dataMahasiswa.add(new Mahasiswa(1, "Luthfi", "2410817310006")); // 
        dataMahasiswa.add(new Mahasiswa(2, "Amel", "2410817320010")); // 
        dataMahasiswa.add(new Mahasiswa(3, "Ilham", "2410817310017")); // 
        dataMahasiswa.add(new Mahasiswa(4, "Dhea", "2410817220023")); // 
        dataMahasiswa.add(new Mahasiswa(5, "Tata", "2410817120013"));
        dataMahasiswa.add(new Mahasiswa(6, "Guntur", "2410817310003"));
        dataMahasiswa.add(new Mahasiswa(7, "Daka", "2410817210029"));
        dataMahasiswa.add(new Mahasiswa(8, "Rachel", "2410817220030"));
        dataMahasiswa.add(new Mahasiswa(9, "Aan", "2410817310008"));
        dataMahasiswa.add(new Mahasiswa(10, "Andre", "2410817210006"));
        
        nimColumn.setCellValueFactory(new PropertyValueFactory<>("nim"));
        namaColumn.setCellValueFactory(new PropertyValueFactory<>("nama"));
        
        tableView.setItems(dataMahasiswa);
	}	
}
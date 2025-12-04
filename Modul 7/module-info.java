module Modul_7 {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	
	requires java.sql;
	
	opens controller to javafx.fxml;
	
	opens application to javafx.graphics, javafx.fxml;
	
	opens model to javafx.base;
}

module Modul_6 {
	requires transitive javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	
	opens model to javafx.base, javafx.fxml;
	opens controller to javafx.fxml;
	
	opens application to javafx.graphics, javafx.fxml;
	exports application;
}
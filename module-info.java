module stick.hero2 {
    requires javafx.controls;
    requires javafx.fxml;

    opens application to javafx.fxml;

    exports application;
}
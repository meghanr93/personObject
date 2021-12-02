module ryan {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    opens ryan.personobject to javafx.fxml;
    exports ryan.personobject;
}
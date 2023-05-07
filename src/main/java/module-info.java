module com.example.contactsappmodification {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens com.example.contactsappmodification to javafx.fxml;
    exports com.example.contactsappmodification;
}
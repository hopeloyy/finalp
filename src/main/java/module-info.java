module com.example.finalp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.finalp to javafx.fxml;
    exports com.example.finalp;
}
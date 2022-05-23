module com.example.kotlinjavfafxcube1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;

    requires org.controlsfx.controls;

    opens com.example.kotlinjavfafxcube1 to javafx.fxml;
    exports com.example.kotlinjavfafxcube1;
}
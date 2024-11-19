module org.javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens org.javafx to javafx.fxml;
    opens org.javafx.controller to javafx.fxml;
    exports org.javafx;
    exports org.javafx.controller;
}

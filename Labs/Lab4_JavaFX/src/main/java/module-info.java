module com.gmail.aamelis.lab4_javafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.gmail.aamelis.lab4_javafx to javafx.fxml;
    exports com.gmail.aamelis.lab4_javafx;
}
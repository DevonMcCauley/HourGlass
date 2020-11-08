module org.devon {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.media;

    opens org.devon.controller to javafx.fxml;
    exports org.devon.application;
}
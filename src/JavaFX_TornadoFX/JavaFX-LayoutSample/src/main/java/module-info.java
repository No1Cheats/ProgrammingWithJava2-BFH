module ch.bfh {
    requires javafx.controls;
    requires javafx.fxml;

    opens layoutSample to javafx.fxml;
    exports layoutSample;
}
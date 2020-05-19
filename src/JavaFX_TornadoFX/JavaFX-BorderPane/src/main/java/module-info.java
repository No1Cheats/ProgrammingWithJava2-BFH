module ch.bfh {
    requires javafx.controls;
    requires javafx.fxml;

    opens ch.bfh to javafx.fxml;
    exports ch.bfh;
}
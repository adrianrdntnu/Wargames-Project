module Wargames.Project {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    opens no.ntnu.iir.wargames to javafx.fxml;
    exports no.ntnu.iir.wargames;
}
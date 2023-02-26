module cz.uhk.pro3.javafx_cookieclicker {
    requires javafx.controls;
    requires javafx.fxml;


    opens cz.uhk.pro3.javafx_cookieclicker to javafx.fxml;
    exports cz.uhk.pro3.javafx_cookieclicker;
}
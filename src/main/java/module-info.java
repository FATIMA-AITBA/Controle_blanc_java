module com.fatima.control_blanc {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.fatima.control_blanc to javafx.fxml;
    exports com.fatima.control_blanc;
    exports com.fatima.control_blanc.DAO;
    opens com.fatima.control_blanc.DAO to javafx.fxml;

    exports com.fatima.control_blanc.Controller;
    opens com.fatima.control_blanc.Controller to javafx.fxml;

}
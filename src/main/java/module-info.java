module com.devteam.management_of_noncommunicable_diseases {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.devteam.management_of_noncommunicable_diseases to javafx.fxml;
    exports com.devteam.management_of_noncommunicable_diseases;
}
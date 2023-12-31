package com.devteam.management_of_noncommunicable_diseases.Controller;

import com.devteam.management_of_noncommunicable_diseases.Dao.DepartmentDao;
import com.devteam.management_of_noncommunicable_diseases.Interface.InfoBox;
import com.devteam.management_of_noncommunicable_diseases.Interface.ShowAlert;
import com.devteam.management_of_noncommunicable_diseases.Model.Department;
import com.devteam.management_of_noncommunicable_diseases.Interface.ComboBoxData;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Window;

public class DepartmentController implements InfoBox, ShowAlert,ComboBoxData {
    @FXML
    private Button btnAddDepartment;

    @FXML
    private TextField departmentName;

    @FXML
    private TextArea departmentDescription;

    @FXML
    private DatePicker departmentDeleted_at;

    Window owner;

    Department department = new Department();

    DepartmentDao departmentDAO = new DepartmentDao();


   /* protected void setBtnAddDepartment() throws SQLException {
        department.setName(departmentName.getText());
        department.setDescription(departmentDescription.getText());
        department.setDeletedAt(departmentDeleted_at.getValue().atStartOfDay());

        departmentDAO.addDepartment(owner);
    }*/
}

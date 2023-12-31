package com.devteam.management_of_noncommunicable_diseases.Controller;

import com.devteam.management_of_noncommunicable_diseases.Dao.PeopleDao;
import com.devteam.management_of_noncommunicable_diseases.Model.People;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Window;
import javafx.scene.control.ChoiceBox;

import java.sql.*;
import java.time.LocalDate;

public class PeopleController {

    @FXML
    private Button checkIdNumber;

    @FXML
    private TextField id_number;

    @FXML
    private TextField first_name;

    @FXML
    private TextField last_name;

    @FXML
    private DatePicker date_of_birth;

    @FXML
    private TextField gender;

    @FXML
    private TextField address;

    @FXML
    private TextField phone_number;

    @FXML
    private TextField email;

    @FXML
    private TextField note;

    @FXML
    private ChoiceBox<String> genderChoiceBox;

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Window owner;
    People people = new People();
    PeopleDao peopleDao = new PeopleDao();

protected void getPeopleDetails () {
    String IdNumber = id_number.getText();
    String FirstName = first_name.getText();
    String LastName = last_name.getText();
    LocalDate DOB = date_of_birth.getValue();
    String Gender = gender.getText();
    String Address = address.getText();
    String PhoneNumber = phone_number.getText();
    String Email = email.getText();
    String Note = note.getText();
    People people = new People(IdNumber, FirstName, LastName, DOB, Gender, Address, PhoneNumber, Email, Note);
}

    protected void addNewPeople(ActionEvent event) throws SQLException {
        getPeopleDetails();
        people.add();
    }

    protected void updatePeople() throws SQLException {
        getPeopleDetails();
        people.update();
    }

    protected void deletePeople() throws SQLException {

    }
}

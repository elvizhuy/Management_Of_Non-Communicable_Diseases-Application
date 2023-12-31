package com.devteam.management_of_noncommunicable_diseases.Model;

import com.devteam.management_of_noncommunicable_diseases.Dao.DepartmentDao;
import javafx.stage.Window;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class Department {
    int id;
    String name;
    String description;
    LocalDateTime deletedAt;
    DepartmentDao departmentDao = new DepartmentDao();
    Window owner;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Department() {

    }

    public Department(int id, String name, String description, LocalDateTime deletedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.deletedAt = deletedAt;
    }

    public void add () throws SQLException {
        departmentDao.addDepartment(owner,this.name,this.description);
    }
}

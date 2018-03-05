package ui2.queries;

import database.DatabaseConnector;
import database.queries.departments.SelectDepartmentsWithManager;
import database.queries.employee.SelectEmployeesFromDepartmentQuery;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SelectDepartmentsWithManagerPanel extends QueryPanel {

    JTextField managerNameField;

    public SelectDepartmentsWithManagerPanel(JTable targetTable) {
        super(targetTable);

        managerNameField = addTextField("Manager");
        addExecuteButton();

        makeCompactGrid(2);
    }

    @Override
    protected void execute() {
        targetTable.setModel(DatabaseConnector.executeQuery(new SelectDepartmentsWithManager(managerNameField.getText().trim())));
    }
}

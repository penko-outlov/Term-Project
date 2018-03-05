package ui2.queries.employees;

import database.DatabaseConnector;
import database.queries.departments.SelectDepartmentsWithManager;
import database.queries.employee.SelectEmployeesFromDepartmentQuery;
import database.queries.special.SelectTasksForDepartmentWithStatus;
import ui2.queries.QueryPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SelectEmployeesFromDepartmentPanel extends QueryPanel {

    private JTextField departmentNameField;

    public SelectEmployeesFromDepartmentPanel(JTable targetTable) {
        super(targetTable);

        departmentNameField = addTextField("Department");
        addExecuteButton();

        makeCompactGrid(2);
    }

    @Override
    protected void execute() {
        targetTable.setModel(DatabaseConnector.executeQuery(new SelectEmployeesFromDepartmentQuery(departmentNameField.getText().trim())));
    }
}

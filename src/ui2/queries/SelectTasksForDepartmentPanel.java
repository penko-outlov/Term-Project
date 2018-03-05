package ui2.queries;

import database.DatabaseConnector;
import database.queries.employee.SelectEmployeesFromDepartmentQuery;
import database.queries.special.SelectDepartmentTasksBefore;
import database.queries.tasks.SelectTasksForDepartment;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class SelectTasksForDepartmentPanel extends QueryPanel {

    private JTextField departmentNameField;


    public SelectTasksForDepartmentPanel(JTable targetTable) {
        super(targetTable);

        departmentNameField = addTextField("Department");
        addExecuteButton();

        makeCompactGrid(2);
    }

    @Override
    protected void execute() {
        targetTable.setModel(DatabaseConnector.executeQuery(new SelectTasksForDepartment(departmentNameField.getText().trim())));
    }
}

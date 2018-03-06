package ui2.queries.departments;

import database.DatabaseConnector;
import database.queries.departments.SelectDepartmentsWithManager;
import database.queries.employee.SelectEmployeesFromDepartmentQuery;
import ui2.queries.DepartmentQueryPanel;
import ui2.queries.QueryPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SelectDepartmentsWithManagerPanel extends DepartmentQueryPanel {

    JTextField managerNameField;
    JComboBox managerDropdown;

    public SelectDepartmentsWithManagerPanel(JTable targetTable) {
        super(targetTable);

        managerDropdown = addDropdownFromTable("Manager", DatabaseConnector.getEmployeeModel(), 1, 2);
        addExecuteButton();

        makeCompactGrid(2);
    }

    @Override
    protected void execute() {
        targetTable.setModel(DatabaseConnector.executeQuery(new SelectDepartmentsWithManager(managerDropdown.getSelectedIndex() + 1)));
    }
}

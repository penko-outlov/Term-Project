package ui2.queries.employees;

import database.DatabaseConnector;
import database.queries.employee.SelectEmployeesFromDepartmentQuery;
import ui2.queries.QueryPanel;

import javax.swing.*;

public class SelectEmployeesFromDepartmentPanel extends QueryPanel {

    private JComboBox departmentDropdown;

    public SelectEmployeesFromDepartmentPanel(JTable targetTable) {
        super(targetTable);

        departmentDropdown = addDropdownFromTable("Department", DatabaseConnector.getDepartmentModel(), 1);
        addExecuteButton();

        makeCompactGrid(2);
    }

    @Override
    protected void execute() {
        targetTable.setModel(DatabaseConnector.executeQuery(new SelectEmployeesFromDepartmentQuery(departmentDropdown.getSelectedIndex() + 1)));
    }
}

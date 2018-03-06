package ui2.queries.departments;

import database.DatabaseConnector;
import database.queries.departments.InsertDepartmentQuery;
import ui2.queries.DepartmentQueryPanel;
import ui2.queries.QueryPanel;

import javax.swing.*;
import java.awt.*;

public class InsertDepartmentPanel extends DepartmentQueryPanel {

    private JTextField departmentNameField;
    private JComboBox employeeDropdown;

    private JLabel messageLabel;


    public InsertDepartmentPanel(JTable targetTable) {
        super(targetTable);

        departmentNameField = addTextField("Name");
        employeeDropdown = addDropdownFromTable("Manager", DatabaseConnector.getEmployeeModel(), 1, 2);

        addExecuteButton("Insert");

        messageLabel = addLabel("");
        messageLabel.setForeground(Color.red);

        makeCompactGrid(4);
    }

    @Override
    protected void execute() {
        if(departmentNameField.getText().length() == 0) {
            messageLabel.setText("Name must be longer!");
            return;
        }

        DatabaseConnector.executeQuery(new InsertDepartmentQuery(departmentNameField.getText().trim(), employeeDropdown.getSelectedIndex() + 1));
        targetTable.setModel(DatabaseConnector.getDepartmentModel());
    }

}

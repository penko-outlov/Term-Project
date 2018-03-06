package ui2.queries.employees;

import database.DatabaseConnector;
import database.queries.employee.UpdateEmployeeQuery;
import ui2.queries.EmployeeQueryPanel;
import ui2.queries.QueryPanel;

import javax.swing.*;
import java.awt.*;

public class UpdateEmployeePanel extends EmployeeQueryPanel {

    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField egnField;
    private JTextField emailField;
    private JComboBox departmentDropdown;
    private JTextField telephoneField;

    public UpdateEmployeePanel(JTable targetTable) {
        super(targetTable);

        firstNameField = addTextField("First Name");
        lastNameField = addTextField("Last Name");
        egnField = addTextField("EGN");
        emailField = addTextField("Email");
        departmentDropdown = addDropdownFromTable("Department", DatabaseConnector.getDepartmentModel(), 2);
        telephoneField = addTextField("Telephone");

        addExecuteButton("Update");

        makeCompactGrid(7);
    }

    @Override
    protected void execute() {
        int row = targetTable.getSelectedRow();
        if(row == -1) {
            return;
        }
        int employeeId = (int) targetTable.getValueAt(row, 0);

        String firstName = firstNameField.getText().trim();
        if(firstName.length() == 0) { firstName = null; }

        String lastName = lastNameField.getText().trim();
        if(lastName.length() == 0) { lastName = null; }

        String egn = egnField.getText().trim();
        if(egn.length() == 0 || egn.length() != 10) { egn = null; }

        String email = emailField.getText().trim();
        if(email.length() == 0) { email = null; }

        int departmentId = departmentDropdown.getSelectedIndex() + 1;

        String phone = telephoneField.getText().trim();
        if(phone.length() == 0) { phone = null; }

        DatabaseConnector.executeQuery(new UpdateEmployeeQuery(employeeId, firstName, lastName, egn, email, departmentId, phone));
        targetTable.setModel(DatabaseConnector.getEmployeeModel());
    }


}


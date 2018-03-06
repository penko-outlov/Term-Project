package ui2.queries.employees;

import database.DatabaseConnector;
import database.TableModel;
import database.queries.employee.InsertEmployeeQuery;
import org.h2.engine.Database;
import ui2.queries.EmployeeQueryPanel;
import ui2.queries.QueryPanel;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class InsertEmployeePanel extends EmployeeQueryPanel {

    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField egnField;
    private JTextField emailField;
    private JComboBox departmentDropdown;
    private JLabel messageLabel;

    public InsertEmployeePanel(JTable targetTable) {
        super(targetTable);


        firstNameField = addTextField("First Name");
        lastNameField = addTextField("Last Name");
        egnField = addTextField("EGN");
        emailField = addTextField("Email");
        departmentDropdown = addDropdownFromTable("Department", DatabaseConnector.getDepartmentModel(), 2);

        addExecuteButton("Insert");

        messageLabel = addLabel("");
        messageLabel.setForeground(Color.red);

        makeCompactGrid(7);
    }

    @Override
    protected void execute() {
        if(firstNameField.getText().length() == 0 || lastNameField.getText().length() == 0) {
            messageLabel.setText("Name must be longer!");
            return;
        }

        if(egnField.getText().length() != 10) {
            messageLabel.setText("Please enter a valid EGN");
            return;
        }

        DatabaseConnector.executeQuery(new InsertEmployeeQuery(firstNameField.getText().trim(),
                lastNameField.getText().trim(),
                egnField.getText().trim(),
                emailField.getText().trim(),
                departmentDropdown.getSelectedIndex() + 1));

        targetTable.setModel(DatabaseConnector.getEmployeeModel());
    }
}

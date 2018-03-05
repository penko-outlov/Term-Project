package ui2.queries.departments;

import database.DatabaseConnector;
import database.queries.departments.InsertDepartmentQuery;
import database.queries.departments.UpdateDepartmentQuery;
import ui2.queries.QueryPanel;

import javax.swing.*;
import java.awt.*;

public class UpdateDepartmentPanel extends QueryPanel {

    private JTextField nameField;
    private JComboBox managerDropdown;

    public UpdateDepartmentPanel(JTable targetTable) {
        super(targetTable);

        addLabel("Select a department to update");
        nameField = addTextField("Name");
        managerDropdown = addDropdownFromTable("Manager", DatabaseConnector.getEmployeeModel(), 1, 2);

        addExecuteButton("Update");

        makeCompactGrid(4);
    }

    @Override
    protected void execute() {
        int row = targetTable.getSelectedRow();
        if(row == -1) {
            return;
        }
        int departmentId = (int) targetTable.getValueAt(row, 0);

        String newName = nameField.getText();
        if(newName.trim().length() == 0) {
            newName = null;
        }


        DatabaseConnector.executeQuery(new UpdateDepartmentQuery(departmentId, newName, managerDropdown.getSelectedIndex() + 1));
        targetTable.setModel(DatabaseConnector.getDepartmentModel());
    }

}

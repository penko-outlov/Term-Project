package ui2.queries;

import database.DatabaseConnector;

import javax.swing.*;

public abstract class EmployeeQueryPanel extends QueryPanel {

    public EmployeeQueryPanel(JTable targetTable) {
        super(targetTable);
    }

    @Override
    public void onSelected() {
        targetTable.setModel(DatabaseConnector.getEmployeeModel());
    }
}

package ui2.queries;

import database.DatabaseConnector;

import javax.swing.*;

public abstract class DepartmentQueryPanel extends QueryPanel {

    public DepartmentQueryPanel(JTable targetTable) {
        super(targetTable);
    }

    @Override
    public void onSelected() {
        targetTable.setModel(DatabaseConnector.getDepartmentModel());
    }
}

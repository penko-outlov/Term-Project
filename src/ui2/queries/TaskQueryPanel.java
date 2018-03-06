package ui2.queries;

import database.DatabaseConnector;

import javax.swing.*;

public abstract class TaskQueryPanel extends QueryPanel {

    public TaskQueryPanel(JTable targetTable) {
        super(targetTable);
    }


    @Override
    public void onSelected() {
        targetTable.setModel(DatabaseConnector.getTaskModel());
    }
}

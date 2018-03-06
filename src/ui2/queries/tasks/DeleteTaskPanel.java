package ui2.queries.tasks;

import database.DatabaseConnector;
import database.queries.employee.DeleteEmployeeQuery;
import database.queries.tasks.DeleteTaskQuery;
import ui2.queries.QueryPanel;
import ui2.queries.TaskQueryPanel;

import javax.swing.*;

public class DeleteTaskPanel extends TaskQueryPanel {

    public DeleteTaskPanel(JTable targetTable) {
        super(targetTable);

        addLabel("Select an entry with the mouse to delete it");
        addExecuteButton("Delete");

        makeCompactGrid(2);
    }

    @Override
    protected void execute() {
        int row = targetTable.getSelectedRow();
        if(row == -1) {
            return;
        }

        int taskId = (int) targetTable.getValueAt(row, 0);
        DatabaseConnector.executeQuery(new DeleteTaskQuery(taskId));
        targetTable.setModel(DatabaseConnector.getTaskModel());
    }

}

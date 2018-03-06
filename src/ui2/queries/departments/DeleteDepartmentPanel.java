package ui2.queries.departments;

import database.DatabaseConnector;
import database.queries.departments.DeleteDepartmentQuery;
import database.queries.tasks.DeleteTaskQuery;
import ui2.queries.DepartmentQueryPanel;
import ui2.queries.QueryPanel;

import javax.swing.*;

public class DeleteDepartmentPanel extends DepartmentQueryPanel {
    public DeleteDepartmentPanel(JTable targetTable) {
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
        DatabaseConnector.executeQuery(new DeleteDepartmentQuery(taskId));
        targetTable.setModel(DatabaseConnector.getDepartmentModel());
    }
}

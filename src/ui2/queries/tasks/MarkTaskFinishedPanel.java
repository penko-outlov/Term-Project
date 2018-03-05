package ui2.queries.tasks;

import database.DatabaseConnector;
import database.queries.tasks.DeleteTaskQuery;
import database.queries.tasks.MarkTaskFinishedQuery;
import database.queries.tasks.SelectTasksForDepartment;
import org.h2.engine.Database;
import ui2.queries.QueryPanel;

import javax.swing.*;

public class MarkTaskFinishedPanel extends QueryPanel {

    public MarkTaskFinishedPanel(JTable targetTable) {
        super(targetTable);

        addLabel("Select a task to mark as finished");
        addExecuteButton("Mark Finished");

        makeCompactGrid(2);
    }

    @Override
    protected void execute() {
        int row = targetTable.getSelectedRow();
        if(row == -1) {
            return;
        }

        int taskId = (int) targetTable.getValueAt(row, 0);
        DatabaseConnector.executeQuery(new MarkTaskFinishedQuery(taskId));

        targetTable.setModel(DatabaseConnector.getTaskModel());
    }
}

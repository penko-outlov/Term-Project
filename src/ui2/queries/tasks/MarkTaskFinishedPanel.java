package ui2.queries.tasks;

import database.DatabaseConnector;
import database.objects.Status;
import database.queries.tasks.MarkTaskFinishedQuery;
import database.queries.tasks.SelectTasksWithStatusQuery;
import ui2.queries.TaskQueryPanel;

import javax.swing.*;

public class MarkTaskFinishedPanel extends TaskQueryPanel {

    public MarkTaskFinishedPanel(JTable targetTable) {
        super(targetTable);

        addLabel("Select a task to mark as finished");
        addExecuteButton("Mark Finished");

        makeCompactGrid(2);
    }

    @Override
    public void onSelected() {
        targetTable.setModel(DatabaseConnector.executeQuery(new SelectTasksWithStatusQuery(Status.TAKEN)));
    }

    @Override
    protected void execute() {
        int row = targetTable.getSelectedRow();
        if(row == -1) {
            return;
        }

        int taskId = (int) targetTable.getValueAt(row, 0);
        DatabaseConnector.executeQuery(new MarkTaskFinishedQuery(taskId));

        targetTable.setModel(DatabaseConnector.executeQuery(new SelectTasksWithStatusQuery(Status.TAKEN)));
    }
}

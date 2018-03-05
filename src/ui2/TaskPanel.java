package ui2;

import database.DatabaseConnector;
import ui2.queries.tasks.*;

public class TaskPanel extends TablePanel {

    public TaskPanel() {
        super(DatabaseConnector.getTaskModel());
    }

    @Override
    protected void addQueriesToSidePanel() {
        sidePanel.addQueryPanel(new InsertTaskPanel(table), "Insert");
        sidePanel.addQueryPanel(new TakeTaskPanel(table), "Take task");
        sidePanel.addQueryPanel(new SelectDepartmentTasksBeforePanel(table), "Select department tasks before");
        sidePanel.addQueryPanel(new MarkTaskFinishedPanel(table), "Mark Finished");
        sidePanel.addQueryPanel(new SelectTasksForDepartmentPanel(table), "Select for department");
        sidePanel.addQueryPanel(new SelectTasksForDepartmentWithStatusPanel(table), "Select for department with status");
        sidePanel.addQueryPanel(new DeleteTaskPanel(table), "Delete");
    }
}

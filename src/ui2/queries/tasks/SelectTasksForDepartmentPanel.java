package ui2.queries.tasks;

import database.DatabaseConnector;
import database.queries.tasks.SelectTasksForDepartmentQuery;
import ui2.queries.TaskQueryPanel;

import javax.swing.*;

public class SelectTasksForDepartmentPanel extends TaskQueryPanel {

    private JTextField departmentNameField;


    public SelectTasksForDepartmentPanel(JTable targetTable) {
        super(targetTable);

        departmentNameField = addTextField("Department");
        addExecuteButton();

        makeCompactGrid(2);
    }

    @Override
    protected void execute() {
        targetTable.setModel(DatabaseConnector.executeQuery(new SelectTasksForDepartmentQuery(departmentNameField.getText().trim())));
    }
}

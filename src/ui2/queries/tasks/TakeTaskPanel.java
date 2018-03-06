package ui2.queries.tasks;

import database.DatabaseConnector;
import database.objects.Status;
import database.queries.tasks.MarkTaskFinishedQuery;
import database.queries.tasks.SelectTasksWithStatusQuery;
import database.queries.tasks.TakeTaskQuery;
import ui2.queries.QueryPanel;
import ui2.queries.TaskQueryPanel;

import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;

public class TakeTaskPanel extends TaskQueryPanel {

    private JFormattedTextField hourField;
    private JComboBox employeeDropdown;

    private JLabel messageField;

    public TakeTaskPanel(JTable targetTable) {
        super(targetTable);

        addLabel("Select a task to take");
        addHourField();
        employeeDropdown = addDropdownFromTable("Employee", DatabaseConnector.getEmployeeModel(), 1,2);
        addExecuteButton("Take");

        messageField = addLabel("");
        messageField.setForeground(Color.red);

        makeCompactGrid(5);
    }

    @Override
    public void onSelected() {
        targetTable.setModel(DatabaseConnector.executeQuery(new SelectTasksWithStatusQuery(Status.OPEN)));
    }

    private void addHourField() {
        add(new JLabel("Hours estimate"));

        NumberFormat format = NumberFormat.getIntegerInstance();
        hourField = new JFormattedTextField(format);
        hourField.setValue(1);
        add(hourField);
    }


    @Override
    protected void execute() {

        int hours = ((Number)hourField.getValue()).intValue();

        if(hours < 0) {
            messageField.setText("Invalid hours!");
            return;
        }

        int row = targetTable.getSelectedRow();
        if(row == -1) {
            return;
        }

        int taskId = (int) targetTable.getValueAt(row, 0);

        DatabaseConnector.executeQuery(new TakeTaskQuery(taskId, employeeDropdown.getSelectedIndex() + 1, hours));

        targetTable.setModel(DatabaseConnector.executeQuery(new SelectTasksWithStatusQuery(Status.OPEN)));
    }
}

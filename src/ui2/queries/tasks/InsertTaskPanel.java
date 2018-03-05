package ui2.queries.tasks;

import database.DatabaseConnector;
import database.queries.special.SelectDepartmentTasksBefore;
import database.queries.tasks.InsertTaskQuery;
import ui2.queries.QueryPanel;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class InsertTaskPanel extends QueryPanel {

    private JTextField nameField;
    private JTextArea descriptionArea;
    private JComboBox departmentDropdown;
    private JComboBox requesterDropdown;
    private JFormattedTextField deadlineField;

    private JLabel messageLabel;

    public InsertTaskPanel(JTable targetTable) {
        super(targetTable);

        nameField = addTextField("Name");
        addDescriptionArea();
        departmentDropdown = addDropdownFromTable("Department", DatabaseConnector.getDepartmentModel(), 1);
        requesterDropdown = addDropdownFromTable("Requester", DatabaseConnector.getEmployeeModel(), 1, 2);
        deadlineField = addDateField("Date");

        addExecuteButton("Insert");

        messageLabel = addLabel("");

        makeCompactGrid(6);
    }

    private void addDescriptionArea() {
        add(new JLabel("Description"));

        descriptionArea = new JTextArea();
        add(descriptionArea);
    }

    @Override
    protected void execute() {
        if(nameField.getText().length() == 0) {
            messageLabel.setText("Invalid length for task name!");
            return;
        }

        Date date = (Date) deadlineField.getValue();

        LocalDateTime convertedDeadline = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        DatabaseConnector.executeQuery(new InsertTaskQuery(
                nameField.getText().trim(),
                descriptionArea.getText(),
                departmentDropdown.getSelectedIndex() + 1,
                requesterDropdown.getSelectedIndex() + 1,
                convertedDeadline));

        targetTable.setModel(DatabaseConnector.getTaskModel());
    }
}

package ui2.queries.tasks;

import database.DatabaseConnector;
import database.queries.employee.SelectEmployeesFromDepartmentQuery;
import database.queries.special.SelectDepartmentTasksBefore;
import ui2.queries.QueryPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class SelectDepartmentTasksBeforePanel extends QueryPanel implements ActionListener {

    private JTextField departmentNameField;
    private JFormattedTextField dateTextField;

    public SelectDepartmentTasksBeforePanel(JTable targetTable) {
        super(targetTable);

        departmentNameField = addTextField("Department");
        dateTextField = addDateField("Date");
        addExecuteButton();

        makeCompactGrid(3);
    }

    @Override
    protected void execute() {
        Date date = (Date) dateTextField.getValue();

        LocalDateTime convertedDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        targetTable.setModel(DatabaseConnector.executeQuery(new SelectDepartmentTasksBefore(departmentNameField.getText().trim(), convertedDate)));
    }
}

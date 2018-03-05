package ui2.queries.tasks;

import database.DatabaseConnector;
import database.TableModel;
import database.queries.special.SelectTasksForDepartmentWithStatus;
import database.queries.tasks.SelectTasksForDepartment;
import ui2.queries.QueryPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class SelectTasksForDepartmentWithStatusPanel extends QueryPanel {

    JTextField departmentNameField;
    JComboBox statusDropdown;

    public SelectTasksForDepartmentWithStatusPanel(JTable targetTable) {
        super(targetTable);

        departmentNameField = addTextField("Department");
        addStatusComboBox();
        addExecuteButton();

        makeCompactGrid(3);
    }

    private void addStatusComboBox() {
        JLabel label = new JLabel("Status");
        this.add(label);

        TableModel statusTable = DatabaseConnector.getStatusModel();
        List<String> statusTypes = new ArrayList<>();
        for(int i = 0; i < statusTable.getRowCount(); i++) {
            statusTypes.add((String) statusTable.getValueAt(i, 1));
        }

        statusDropdown = new JComboBox(statusTypes.toArray());
        statusDropdown.setSelectedIndex(0);
        statusDropdown.addActionListener(this);

        this.add(statusDropdown);
    }

    @Override
    protected void execute() {
        targetTable.setModel(DatabaseConnector.executeQuery(new SelectTasksForDepartmentWithStatus(departmentNameField.getText().trim(), statusDropdown.getSelectedIndex() + 1)));
    }
}

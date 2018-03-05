package ui2.queries.employees;

import database.DatabaseConnector;
import database.queries.employee.DeleteEmployeeQuery;
import ui2.queries.QueryPanel;

import javax.swing.*;

public class DeleteEmployeePanel extends QueryPanel {

    public DeleteEmployeePanel(JTable targetTable) {
        super(targetTable);

        addInstructionsLabel();
        addExecuteButton("Delete");

        makeCompactGrid(2);
    }

    private void addInstructionsLabel() {
        this.add(new JPanel());
        this.add(new JLabel("Select an entry with the mouse to delete it."));
    }

    @Override
    protected void execute() {
        int row = targetTable.getSelectedRow();
        if(row == -1) {
            return;
        }

        int employeeId = (int) targetTable.getValueAt(row, 0);
        DatabaseConnector.executeQuery(new DeleteEmployeeQuery(employeeId));
        targetTable.setModel(DatabaseConnector.getEmployeeModel());
    }
}

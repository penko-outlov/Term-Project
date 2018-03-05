package visual;

import database.DatabaseConnector;
import database.TableModel;
import database.queries.employee.DeleteEmployeeQuery;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class EmployeePanel extends TablePanel {
    public EmployeePanel(TableModel tableModel) {
        super(tableModel);
        makeSidePanel();
    }

    @Override
    protected void makeSidePanel() {
        sidePanel.add(info);
        sidePanel.add(controls);
        execute.addActionListener((e) -> {
            if (currentTable.getSelectedRow() == -1 && currentTable.getSelectedColumn() == -1) {
                JOptionPane.showMessageDialog(this, "Please select a row, column or cell from the table.");
                return;
            }

            String action = (String) controls.getSelectedItem();
            switch (action) {
                case "Insert":
                    break;
                case "Delete":
                    int row = currentTable.getSelectedRow();
                    int employeeId = (int) currentTable.getValueAt(row, 0);
                    DatabaseConnector.executeQuery(new DeleteEmployeeQuery(employeeId));
                    break;
                case "Update":
                    break;
                case "Select":
                    break;
            }
            currentTable.clearSelection();
        });
        sidePanel.add(execute);
        add(sidePanel);
    }
}

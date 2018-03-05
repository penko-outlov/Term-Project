package visual;

import database.DatabaseConnector;
import database.TableModel;
import database.queries.employee.DeleteEmployeeQuery;
import ui2.queries.QueryPanel;
import ui2.queries.departments.InsertDepartmentPanel;
import ui2.queries.employees.DeleteEmployeePanel;
import ui2.queries.employees.InsertEmployeePanel;
import ui2.queries.employees.SelectEmployeesFromDepartmentPanel;

import javax.swing.*;
import java.awt.CardLayout;
import java.awt.GridLayout;

public class EmployeePanel extends TablePanel {
    public EmployeePanel(TableModel tableModel) {
        super(tableModel);
    }

    @Override
    protected void makeSidePanel() {
        QueryPanel testPanel = new InsertDepartmentPanel(currentTable);
        queryView.add(testPanel);

        sidePanel.add(queryView);

        controlPanel.add(info);
        controls.addItemListener((evt) -> {
            CardLayout layout = (CardLayout) queryView.getLayout();
            layout.show(queryView, (String) evt.getItem());
        });
        controlPanel.add(controls);
        sidePanel.add(controlPanel);

        add(sidePanel);
    }
}

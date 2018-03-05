package ui2;

import database.DatabaseConnector;
import ui2.queries.employees.DeleteEmployeePanel;
import ui2.queries.employees.InsertEmployeePanel;
import ui2.queries.employees.SelectEmployeesFromDepartmentPanel;
import ui2.queries.employees.UpdateEmployeePanel;

public class EmployeePanel extends TablePanel {

    public EmployeePanel() {
        super(DatabaseConnector.getEmployeeModel());
    }

    @Override
    protected void addQueriesToSidePanel() {
        sidePanel.addQueryPanel(new InsertEmployeePanel(table), "Insert");
        sidePanel.addQueryPanel(new UpdateEmployeePanel(table), "Update");
        sidePanel.addQueryPanel(new DeleteEmployeePanel(table), "Delete");
        sidePanel.addQueryPanel(new SelectEmployeesFromDepartmentPanel(table), "Select From Department");
    }
}

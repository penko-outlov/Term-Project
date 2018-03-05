package ui2;

import database.DatabaseConnector;
import ui2.queries.departments.DeleteDepartmentPanel;
import ui2.queries.departments.InsertDepartmentPanel;
import ui2.queries.departments.SelectDepartmentsWithManagerPanel;
import ui2.queries.departments.UpdateDepartmentPanel;
import ui2.queries.employees.DeleteEmployeePanel;
import ui2.queries.employees.InsertEmployeePanel;
import ui2.queries.employees.SelectEmployeesFromDepartmentPanel;

public class DepartmentPanel extends TablePanel {

    public DepartmentPanel() {
        super(DatabaseConnector.getDepartmentModel());
    }

    @Override
    protected void addQueriesToSidePanel() {
        sidePanel.addQueryPanel(new InsertDepartmentPanel(table), "Insert");
        sidePanel.addQueryPanel(new UpdateDepartmentPanel(table), "Update");
        sidePanel.addQueryPanel(new SelectDepartmentsWithManagerPanel(table), "Select with Manager");
        sidePanel.addQueryPanel(new DeleteDepartmentPanel(table), "Delete");
    }
}

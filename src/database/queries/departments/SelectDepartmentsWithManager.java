package database.queries.departments;

import database.queries.Query;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SelectDepartmentsWithManager extends Query {

    private String managerName = null;

    private Integer managerId = null;

    private static final String NAME_QUERY_TEXT = "SELECT dep.department_id, dep.name " +
            "FROM departments dep " +
            "WHERE (SELECT CONCAT(first_name,' ',last_name) FROM employees emp WHERE emp.employee_id = dep.manager_id) = ?";

    private static final String ID_QUERY_TEXT = "SELECT dep.department_id, dep.name " +
            "FROM departments dep " +
            "WHERE dep.manager_id = ?";



    public SelectDepartmentsWithManager(String managerName) {
        this.managerName = managerName;
    }


    public SelectDepartmentsWithManager(Integer managerId) {
        this.managerId = managerId;
    }

    @Override
    protected String getQueryText() {
        if(managerName != null) {
            return NAME_QUERY_TEXT;
        }
        return ID_QUERY_TEXT;
    }

    @Override
    protected void setStatementValues(PreparedStatement statement) throws SQLException {
        if(managerName != null) {
            statement.setString(1, managerName);
        }
        else {
            statement.setInt(1, managerId.intValue());
        }
    }
}

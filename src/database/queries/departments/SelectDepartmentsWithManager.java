package database.queries.departments;

import database.queries.Query;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SelectDepartmentsWithManager extends Query {

    private String managerName;

    private static final String QUERY_TEXT = "SELECT dep.department_id, dep.name " +
            "FROM departments dep " +
            "WHERE (SELECT CONCAT(first_name,' ',last_name) FROM employees emp WHERE emp.employee_id = dep.manager_id) = ?";

    public SelectDepartmentsWithManager(String managerName) {
        this.managerName = managerName;
    }

    @Override
    protected String getQueryText() {
        return QUERY_TEXT;
    }

    @Override
    protected void setStatementValues(PreparedStatement statement) throws SQLException {
        statement.setString(1, managerName);
    }
}

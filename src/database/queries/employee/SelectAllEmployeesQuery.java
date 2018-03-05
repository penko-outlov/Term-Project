package database.queries.employee;

import database.queries.Query;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SelectAllEmployeesQuery extends Query {

    private static final String QUERY_TEXT =
            "SELECT employee_id, first_name, last_name, egn, email, departments.name as Department, telephone " +
                    "FROM employees " +
                    "LEFT JOIN departments ON employees.department_id = departments.department_id";

    @Override
    protected String getQueryText() {
        return QUERY_TEXT;
    }

    @Override
    protected void setStatementValues(PreparedStatement statement) throws SQLException { }
}

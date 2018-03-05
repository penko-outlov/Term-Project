package database.queries.departments;

import database.queries.Query;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SelectAllDepartmentsQuery extends Query {

    private static final String QUERY_TEXT =
            "SELECT departments.department_id, departments.name, STRING.CONCAT(employees.first_name, ' ', employees.last_name) as Manager " +
                    "FROM departments " +
                    "LEFT JOIN employees ON departments.manager_id = employees.employee_id";

    @Override
    protected String getQueryText() {
        return QUERY_TEXT;
    }

    @Override
    protected void setStatementValues(PreparedStatement statement) throws SQLException { }
}

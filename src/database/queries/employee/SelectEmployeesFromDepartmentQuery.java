package database.queries.employee;

import database.queries.Query;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SelectEmployeesFromDepartmentQuery extends Query {

    private String departmentName;

    private static final String QUERY_TEXT = "SELECT * " +
                                             "FROM EMPLOYEES E " +
                                             "WHERE (SELECT NAME FROM DEPARTMENTS WHERE DEPARTMENT_ID = E.DEPARTMENT_ID) = ?";

    public SelectEmployeesFromDepartmentQuery(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    protected String getQueryText() {
        return QUERY_TEXT;
    }

    @Override
    protected void setStatementValues(PreparedStatement statement) throws SQLException {
        statement.setString(1, departmentName);
    }
}

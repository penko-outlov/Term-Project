package database.queries.employee;

import database.queries.Query;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SelectEmployeesFromDepartmentQuery extends Query {

    private String departmentName = null;
    private Integer departmentId = null;

    private static final String NAME_QUERY_TEXT = "SELECT * " +
                                             "FROM EMPLOYEES E " +
                                             "WHERE (SELECT NAME FROM DEPARTMENTS WHERE DEPARTMENT_ID = E.DEPARTMENT_ID) = ?";

    private static final String ID_QUERY_TEXT = "SELECT STRING.CONCAT(first_name, ' ', last_name) as Name, egn, email, telephone " +
            "FROM EMPLOYEES E " +
            "WHERE E.DEPARTMENT_ID = ?";

    public SelectEmployeesFromDepartmentQuery(String departmentName) {
        this.departmentName = departmentName;
    }

    public SelectEmployeesFromDepartmentQuery(Integer departmentId) { this.departmentId = departmentId; }

    @Override
    protected String getQueryText() {
        if(departmentName != null) { return NAME_QUERY_TEXT; }
        return ID_QUERY_TEXT;
    }

    @Override
    protected void setStatementValues(PreparedStatement statement) throws SQLException {
        if(departmentName != null) {
            statement.setString(1, departmentName);
        }
        else {
            statement.setInt(1, departmentId.intValue());
        }
    }
}

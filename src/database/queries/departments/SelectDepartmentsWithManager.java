package database.queries.departments;

import database.queries.Query;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SelectDepartmentsWithManager extends Query {

    private String managerName;

    private static final String QUERY_TEXT = "SELECT * " +
            "FROM DEPARTMENTS D " +
            "WHERE (SELECT CONCAT(FIRST_NAME,' ',LAST_NAME) FROM EMPLOYEES E WHERE E.EMPLOYEE_ID = D.MANAGER_ID) = ?";

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

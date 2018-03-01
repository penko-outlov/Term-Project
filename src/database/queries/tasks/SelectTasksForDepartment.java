package database.queries.tasks;

import database.queries.Query;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SelectTasksForDepartment extends Query {

    private String departmentName;

    private static final String QUERY_TEXT = "SELECT * " +
            "FROM TASKS T " +
            "WHERE (SELECT NAME FROM DEPARTMENTS D WHERE T.DEPARTMENT_ID = D.DEPARTMENT_ID) = ?";


    public SelectTasksForDepartment(String departmentName) {
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

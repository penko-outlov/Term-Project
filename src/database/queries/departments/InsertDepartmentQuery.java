package database.queries.departments;

import database.queries.Query;
import utility.StringUtility;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDepartmentQuery extends Query {

    private static final String QUERY = "INSERT INTO DEPARTMENTS (NAME, MANAGER_ID) " +
                                        "VALUES " + StringUtility.createQuestionMarkParenthesizedList(2);

    private String name;
    private int managerId;

    public InsertDepartmentQuery(String name, int managerId) {
        this.name = name;
        this.managerId = managerId;
    }

    @Override
    protected String getQueryText() {
        return QUERY;
    }

    @Override
    protected void setStatementValues(PreparedStatement statement) throws SQLException {
        statement.setString(1, name);
        statement.setInt(2, managerId);
    }
}

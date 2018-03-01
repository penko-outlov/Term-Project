package database.queries.special;

import database.TableModel;
import database.TaskTableModel;
import database.queries.Query;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SelectTasksForDepartmentWithStatus extends Query {

    private static final String QUERY_TEXT = "SELECT * FROM TASKS T " +
                                             "JOIN DEPARTMENTS D ON T.DEPARTMENT_ID = D.DEPARTMENT_ID " +
                                             "WHERE D.NAME = ? AND T.STATUS = ?";

    private String departmentName;
    private int statusId;

    public SelectTasksForDepartmentWithStatus(String departmentName, int statusId) {
        this.departmentName = departmentName;
        this.statusId = statusId;
    }

    @Override
    protected String getQueryText() {
        return QUERY_TEXT;
    }

    @Override
    protected void setStatementValues(PreparedStatement statement) throws SQLException {
        statement.setString(1, departmentName);
        statement.setInt(2, statusId);
    }

    @Override
    protected TableModel createTableModel() {
        return new TaskTableModel();
    }
}

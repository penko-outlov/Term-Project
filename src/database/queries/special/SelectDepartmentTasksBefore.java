package database.queries.special;

import database.TableModel;
import database.TaskTableModel;
import database.queries.Query;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

//Returns all tasks from the specified department whose deadlines are before the specified date
public class SelectDepartmentTasksBefore extends Query {

    private static final String QUERY_TEXT = "SELECT * FROM " +
            "TASKS T JOIN DEPARTMENTS D ON T.DEPARTMENT_ID = D.DEPARTMENT_iD " +
            "WHERE D.NAME = ? AND (DEADLINE_DATE < ? OR DEADLINE_DATE IS NULL)";

    private String departmentName;
    private LocalDateTime beforeDate;

    public SelectDepartmentTasksBefore(String departmentName, LocalDateTime beforeDate) {
        this.departmentName = departmentName;
        this.beforeDate = beforeDate;
    }

    @Override
    protected String getQueryText() {
        return QUERY_TEXT;
    }

    @Override
    protected void setStatementValues(PreparedStatement statement) throws SQLException {
        statement.setString(1, departmentName);
        statement.setDate(2,  java.sql.Date.valueOf(beforeDate.toLocalDate()));
    }

    @Override
    protected TableModel createTableModel() {
        return new TaskTableModel();
    }
}

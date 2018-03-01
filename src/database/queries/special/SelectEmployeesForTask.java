package database.queries.special;

import database.TableModel;
import database.TaskTableModel;
import database.queries.Query;

import java.sql.PreparedStatement;
import java.sql.SQLException;

//Select what employees can handle a task based on the department that task is meant for
public class SelectEmployeesForTask extends Query {

    private String taskName;
    private static final String QUERY_TEXT = "SELECT E.FIRST_NAME, E.LAST_NAME FROM EMPLOYEES E " +
                                             "JOIN DEPARTMENTS D ON E.DEPARTMENT_ID = D.DEPARTMENT_ID " +
                                             "JOIN TASKS T ON D.DEPARTMENT_ID = T.DEPARTMENT_ID " +
                                             "WHERE T.NAME = ? " +
                                             "GROUP BY FIRST_NAME, E.LAST_NAME";

    public SelectEmployeesForTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    protected String getQueryText() {
        return QUERY_TEXT;
    }

    @Override
    protected void setStatementValues(PreparedStatement statement) throws SQLException {
        statement.setString(1, taskName);
    }

    @Override
    protected TableModel createTableModel() {
        return new TaskTableModel();
    }
}

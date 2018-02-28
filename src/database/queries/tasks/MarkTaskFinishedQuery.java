package database.queries.tasks;

import database.queries.Query;
import database.objects.Status;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MarkTaskFinishedQuery extends Query {

    private int taskId;

    private static final String QUERY = "UPDATE TASKS " +
                                        "SET DATE_COMPLETED = ?, STATUS = ?" +
                                        "WHERE TASK_ID = ?";

    public MarkTaskFinishedQuery(int taskId) {
        this.taskId = taskId;
    }

    @Override
    protected String getQueryText() {
        return QUERY;
    }

    @Override
    protected void setStatementValues(PreparedStatement statement) throws SQLException {
        statement.setDate(1, java.sql.Date.valueOf(LocalDateTime.now().toLocalDate()));
        statement.setInt(2, Status.COMPLETED);

        statement.setInt(3, taskId);
    }
}

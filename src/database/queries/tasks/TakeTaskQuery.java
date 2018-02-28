package database.queries.tasks;

import database.queries.Query;
import database.objects.Status;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class TakeTaskQuery extends Query {

    private int taskId;
    private int takerId;
    private int timeEstimateHours;

    private static final String QUERY = "UPDATE TASKS " +
                                        "SET TAKER_ID = ?, DATE_TAKEN = ?, TIME_ESTIMATE_HOURS = ?, STATUS = ?" +
                                        "WHERE TASK_ID = ?";

    public TakeTaskQuery(int taskId, int takerId, int timeEstimateHours) {
        this.taskId = taskId;
        this.takerId = takerId;
        this.timeEstimateHours = timeEstimateHours;
    }

    @Override
    protected String getQueryText() {
        return QUERY;
    }

    @Override
    protected void setStatementValues(PreparedStatement statement) throws SQLException {
        statement.setInt(1, takerId);
        statement.setDate(2, java.sql.Date.valueOf(LocalDateTime.now().toLocalDate()));
        statement.setInt(3, timeEstimateHours);
        statement.setInt(4, Status.TAKEN);

        statement.setInt(5, taskId);
    }
}

package database.queries.insert;

import database.objects.Task;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class InsertTaskQuery extends InsertQuery {

    Task task;

    public InsertTaskQuery(Task task) {
        super(Task.TABLE_NAME, Task.COLUMN_NAMES);
        this.task = task;
    }

    public InsertTaskQuery(String name, String description, int statusId, int departmentId, int requesterId, int takerId, LocalDateTime requestDate, LocalDateTime dateTaken, int timeEstimateHours, LocalDateTime dateCompleted) {
        super(Task.TABLE_NAME, Task.COLUMN_NAMES);
        this.task = new Task(name, description, statusId, departmentId, requesterId, takerId, requestDate, dateTaken, timeEstimateHours, dateCompleted);
    }

    @Override
    protected void setStatementValues(PreparedStatement statement) throws SQLException {
        statement.setString(1, task.getName());
        statement.setString(2, task.getDescription());
        statement.setInt(3, task.getStatusId());
        statement.setInt(4, task.getDepartmentId());
        statement.setInt(5, task.getRequesterId());
        statement.setInt(6, task.getTakerId());
        statement.setDate(7, java.sql.Date.valueOf(task.getRequestDate().toLocalDate()));
        statement.setDate(8, java.sql.Date.valueOf(task.getDateTaken().toLocalDate()));
        statement.setInt(9, task.getTimeEstimateHours());
        statement.setDate(10, java.sql.Date.valueOf(task.getDateCompleted().toLocalDate()));
    }
}

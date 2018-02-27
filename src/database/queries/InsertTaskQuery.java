package database.queries;

import database.objects.Task;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTaskQuery extends InsertQuery {

    Task task;

    public InsertTaskQuery(Task task) {
        super(Task.TABLE_NAME, Task.COLUMN_NAMES);
        this.task = task;
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

package database.objects;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class Task extends TableEntry {

    public static final String ID_COLUMN_NAME = "TASK_ID";
    public static final String TABLE_NAME = "tasks";
    public static final String STATUS_TABLE_NAME = "status";
    public static final String[] COLUMN_NAMES = { "NAME", "DESCRIPTION", "STATUS", "DEPARTMENT_ID", "REQUESTED_ID", "TAKER_ID", "REQUEST_DATE", "DATE_TAKEN", "TIME_ESTIMATED_HOURS", "DATE_COMPLETED"};
    private static final String INSERT_QUERY = TableEntry.generateInsertQuery(TABLE_NAME, COLUMN_NAMES);
    private static final String UPDATE_QUERY = TableEntry.generateUpdateQuery(TABLE_NAME, ID_COLUMN_NAME, COLUMN_NAMES);

    private String name;
    private String description;
    private int statusId;
    private int departmentId;
    private int requesterId;
    private int takerId;
    private LocalDateTime requestDate;
    private LocalDateTime dateTaken;
    private int timeEstimateHours;
    private LocalDateTime dateCompleted;


    public Task(String name, String description, int statusId, int departmentId, int requesterId, int takerId, LocalDateTime requestDate, LocalDateTime dateTaken, int timeEstimateHours, LocalDateTime dateCompleted) {
        this.name = name;
        this.description = description;
        this.statusId = statusId;
        this.departmentId = departmentId;
        this.requesterId = requesterId;
        this.takerId = takerId;
        this.requestDate = requestDate;
        this.dateTaken = dateTaken;
        this.timeEstimateHours = timeEstimateHours;
        this.dateCompleted = dateCompleted;
    }

    @Override
    protected String getInsertQuery() {
        return INSERT_QUERY;
    }

    @Override
    protected String getUpdateQuery() {
        return UPDATE_QUERY;
    }

    @Override
    protected int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    protected void setStatementValues(PreparedStatement statement) throws SQLException {
        statement.setString(1, name);
        statement.setString(2, description);
        statement.setInt(3, statusId);
        statement.setInt(4, departmentId);
        statement.setInt(5, requesterId);
        statement.setInt(6, takerId);
        statement.setDate(7, java.sql.Date.valueOf(requestDate.toLocalDate()));
        statement.setDate(8, java.sql.Date.valueOf(dateTaken.toLocalDate()));
        statement.setInt(9, timeEstimateHours);
        statement.setDate(10, java.sql.Date.valueOf(dateCompleted.toLocalDate()));
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getStatusId() {
        return statusId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public int getRequesterId() {
        return requesterId;
    }

    public int getTakerId() {
        return takerId;
    }

    public LocalDateTime getRequestDate() {
        return requestDate;
    }

    public LocalDateTime getDateTaken() {
        return dateTaken;
    }

    public int getTimeEstimateHours() {
        return timeEstimateHours;
    }

    public LocalDateTime getDateCompleted() {
        return dateCompleted;
    }
}




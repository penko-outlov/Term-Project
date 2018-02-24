package database.objects;

import utility.StringUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class Task extends TableEntry {

    public static final String TABLE_NAME = "tasks";

    private String name;
    private String description;
    private int statusId;
    private int departmentId;   //Maybe switch to reference?
    private int requesterId;
    private int takerId;
    private LocalDateTime requestDate;
    private LocalDateTime dateTaken;
    private int timeEstimateHours;
    private LocalDateTime dateCompleted;

    private static final String COLUMN_NAMES = "(NAME, DESCRIPTION, STATUS, DEPARTMENT_ID, REQUESTED_ID, TAKER_ID, REQUEST_DATE, DATE_TAKEN, TIME_ESTIMATED_HOURS, DATE_COMPLETED)";

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
    public PreparedStatement generateInsertStatement(Connection databaseConnection, String schemaName) {
        String query = "INSERT INTO " + schemaName + "." + TABLE_NAME + " " + COLUMN_NAMES + " VALUES " + StringUtility.CreateQueryParenthesizedList(10);

        PreparedStatement statement = null;
        try {
            statement = databaseConnection.prepareStatement(query);
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
        } catch (SQLException e) {
            System.out.println("Failed to generate prepared statement!");
            e.printStackTrace();
        }
        return  statement;
    }
}




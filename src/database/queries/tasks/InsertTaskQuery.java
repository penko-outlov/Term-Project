package database.queries.tasks;

import database.queries.Query;
import database.objects.Status;
import utility.StringUtility;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class InsertTaskQuery extends Query {


    String name;
    String description;
    int departmentId;
    int requesterId;

    private static final String QUERY = "INSERT INTO TASKS (NAME, DESCRIPTION, DEPARTMENT_ID, REQUESTER_ID, STATUS, REQUEST_DATE) " +
                                        "VALUES " + StringUtility.createQuestionMarkParenthesizedList(6);

    public InsertTaskQuery(String name, String description, int departmentId, int requesterId) {
        this.name = name;
        this.description = description;
        this.departmentId = departmentId;
        this.requesterId = requesterId;
    }

    @Override
    protected String getQueryText() {
        return QUERY;
    }

    @Override
    protected void setStatementValues(PreparedStatement statement) throws SQLException {
        statement.setString(1, name);
        statement.setString(2, description);
        statement.setInt(3, departmentId);
        statement.setInt(4, requesterId);
        statement.setInt(5, Status.OPEN);
        statement.setDate(6, java.sql.Date.valueOf(LocalDateTime.now().toLocalDate()));
    }
}

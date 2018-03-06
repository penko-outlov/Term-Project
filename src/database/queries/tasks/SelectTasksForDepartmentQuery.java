package database.queries.tasks;

import database.queries.Query;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SelectTasksForDepartmentQuery extends Query {

    private String departmentName;

    private static final String QUERY_TEXT = "SELECT t.task_id, t.name, STRING.CONCAT(req.first_name, ' ', req.last_name) as Requester, t.request_date, status.name as Status, t.deadline_date as Deadline," +
            "STRING.CONCAT(taker.first_name, ' ', taker.last_name) as Taker, t.date_taken, t.time_estimate_hours, t.date_completed " +
            "FROM tasks t " +
            "LEFT JOIN status ON status.status_id = t.status " +
            "LEFT JOIN employees req ON req.employee_id = t.requester_id " +
            "LEFT JOIN employees taker ON taker.employee_id = t.taker_id " +
            "WHERE (SELECT name FROM departments dep WHERE t.department_id = dep.department_id) = ?";


    public SelectTasksForDepartmentQuery(String departmentName) {
        this.departmentName = departmentName;
    }


    @Override
    protected String getQueryText() {
        return QUERY_TEXT;
    }

    @Override
    protected void setStatementValues(PreparedStatement statement) throws SQLException {
        statement.setString(1, departmentName);
    }
}

package database.queries.tasks;

import database.queries.Query;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SelectAllTasksQuery extends Query {

    private static final String QUERY_TEXT =
            "SELECT tasks.name, STRING.CONCAT(requester.first_name, ' ', requester.last_name) as Requester, tasks.request_date, departments.name as Department , status.name as Status, " +
                    "STRING.CONCAT(taker.first_name, ' ', taker.first_name) as Taker, tasks.date_taken, tasks.time_estimate_hours, tasks.date_completed " +
            "FROM tasks " +
            "LEFT JOIN status ON status.status_id = tasks.status " +
            "LEFT JOIN departments ON departments.department_id = tasks.department_id " +
            "LEFT JOIN employees requester ON requester.employee_id = tasks.requester_id " +
            "LEFT JOIN employees taker ON taker.employee_id = tasks.taker_id ";

    @Override
    protected String getQueryText() {
        return QUERY_TEXT;
    }

    @Override
    protected void setStatementValues(PreparedStatement statement) throws SQLException { }
}

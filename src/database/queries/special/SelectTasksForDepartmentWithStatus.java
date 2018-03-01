package database.queries.special;

import database.TableModel;
import database.TaskTableModel;
import database.queries.Query;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SelectTasksForDepartmentWithStatus extends Query {

    private static final String QUERY_TEXT =
                    "SELECT t.task_id, t.name, STRING.CONCAT(req.first_name, ' ', req.last_name) as Requester, t.request_date, t.deadline_date as Deadline," +
                            "STRING.CONCAT(taker.first_name, ' ', taker.last_name) as Taker, t.date_taken, t.time_estimate_hours, t.date_completed " +
                    "FROM tasks t " +
                    "LEFT JOIN departments ON departments.department_id = t.department_id " +
                    "LEFT JOIN employees req ON req.employee_id = t.requester_id " +
                    "LEFT JOIN employees taker ON taker.employee_id = t.taker_id " +
                    "WHERE departments.name = ? AND t.status = ?";

    private String departmentName;
    private int statusId;

    public SelectTasksForDepartmentWithStatus(String departmentName, int statusId) {
        this.departmentName = departmentName;
        this.statusId = statusId;
    }

    @Override
    protected String getQueryText() {
        return QUERY_TEXT;
    }

    @Override
    protected void setStatementValues(PreparedStatement statement) throws SQLException {
        statement.setString(1, departmentName);
        statement.setInt(2, statusId);
    }
}

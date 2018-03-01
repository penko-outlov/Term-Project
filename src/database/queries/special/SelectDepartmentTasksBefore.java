package database.queries.special;

import database.TableModel;
import database.TaskTableModel;
import database.queries.Query;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

//Returns all tasks from the specified department whose deadlines are before the specified date
public class SelectDepartmentTasksBefore extends Query {

    private static final String QUERY_TEXT =
                    "SELECT tasks.name, STRING.CONCAT(req.first_name, ' ', req.last_name) as Requester, tasks.request_date as Request_Date, tasks.deadline_date as Deadline, status.name as Status " +
                    "FROM tasks " +
                    "JOIN departments ON departments.department_id = tasks.department_id " +
                    "JOIN status ON status.status_id = tasks.status " +
                    "JOIN employees req ON req.employee_id = tasks.requester_id " +
                    "WHERE departments.name = ? AND (deadline_date < ? OR deadline_date IS NULL)";

    private String departmentName;
    private LocalDateTime beforeDate;

    public SelectDepartmentTasksBefore(String departmentName, LocalDateTime beforeDate) {
        this.departmentName = departmentName;
        this.beforeDate = beforeDate;
    }

    @Override
    protected String getQueryText() {
        return QUERY_TEXT;
    }

    @Override
    protected void setStatementValues(PreparedStatement statement) throws SQLException {
        statement.setString(1, departmentName);
        statement.setDate(2,  java.sql.Date.valueOf(beforeDate.toLocalDate()));
    }
}

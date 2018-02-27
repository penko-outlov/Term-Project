package database.queries;

import database.objects.Employee;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertEmployeeQuery extends InsertQuery {

    private Employee employee;

    public InsertEmployeeQuery(Employee employee) {
        super(Employee.TABLE_NAME, Employee.COLUMN_NAMES);
        this.employee = employee;
    }

    @Override
    protected void setStatementValues(PreparedStatement statement) throws SQLException {
        statement.setString(1, employee.getFirstName());
        statement.setString(2, employee.getLastName());
        statement.setInt(3, employee.getDepartmentId());
        statement.setString(4, employee.getEgn());
        statement.setString(5, employee.getEmail());
        statement.setString(6, employee.getTelephone());
    }
}

package database.queries.employee;

import database.objects.Employee;
import database.queries.Query;
import utility.StringUtility;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertEmployeeQuery extends Query {

    private static final String QUERY = "INSERT INTO EMPLOYEES (FIRST_NAME, LAST_NAME, EGN, EMAIL, DEPARTMENT_ID, TELEPHONE) " +
                                        "VALUES " + StringUtility.createQuestionMarkParenthesizedList(6);

    private Employee employee;

    public InsertEmployeeQuery(String firstName, String lastName, String egn, String email, int departmentId) {
        this.employee = new Employee(firstName, lastName, departmentId, egn, email, "");
    }

    public InsertEmployeeQuery(String firstName, String lastName, String egn, String email, int departmentId, String telephone) {
        this.employee = new Employee(firstName, lastName, departmentId, egn, email, telephone);
    }

    @Override
    protected String getQueryText() {
        return QUERY;
    }

    @Override
    protected void setStatementValues(PreparedStatement statement) throws SQLException {
        statement.setString(1, employee.getFirstName());
        statement.setString(2, employee.getLastName());
        statement.setString(3, employee.getEgn());
        statement.setString(4, employee.getEmail());
        statement.setInt(5, employee.getDepartmentId());
        statement.setString(6, employee.getTelephone());
    }
}

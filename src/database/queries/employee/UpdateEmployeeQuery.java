package database.queries.employee;

import database.objects.Employee;
import database.queries.Query;
import utility.StringUtility;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UpdateEmployeeQuery extends Query {

    private int employeeId;
    private String firstName;
    private String lastName;
    private String egn;
    private String email;
    private Integer departmentId;
    private String telephone;

    public UpdateEmployeeQuery(int employeeId, String firstName, String lastName, String egn, String email, Integer departmentId, String telephone) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.egn = egn;
        this.email = email;
        this.departmentId = departmentId;
        this.telephone = telephone;
    }

    @Override
    protected String getQueryText() {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("UPDATE EMPLOYEES SET ");
        List<String> changedColumns = getChangedColumns();
        queryBuilder.append(StringUtility.createSqlStatementColumnList(changedColumns.toArray()));
        queryBuilder.append(" WHERE EMPLOYEE_ID = ?");
        return queryBuilder.toString();
    }

    private List<String> getChangedColumns() {
        List<String> changedColumns = new ArrayList<>();
        if(firstName != null) { changedColumns.add("FIRST_NAME"); }
        if(lastName != null) { changedColumns.add("LAST_NAME"); }
        if(egn != null) { changedColumns.add("EGN"); }
        if(email != null) { changedColumns.add("EMAIL"); }
        if(departmentId != null) { changedColumns.add("DEPARTMENT_ID"); }
        if(telephone != null) { changedColumns.add("TELEPHONE"); }
        return changedColumns;
    }

    @Override
    protected void setStatementValues(PreparedStatement statement) throws SQLException {
        int index = 1;
        if(firstName != null) { statement.setString(index, firstName); index++; }
        if(lastName != null) { statement.setString(index, lastName); index++; }
        if(egn != null) { statement.setString(index, egn); index++; }
        if(email != null) { statement.setString(index, email); index++; }
        if(departmentId != null) { statement.setInt(index, departmentId.intValue());index++; }
        if(telephone != null) { statement.setString(index, telephone); index++; }

        statement.setInt(index, employeeId);
    }
}

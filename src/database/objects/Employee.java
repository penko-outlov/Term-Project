package database.objects;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Employee extends TableEntry {

    public static final String ID_COLUMN_NAME = "EMPLOYEE_ID";
    public static final String TABLE_NAME = "employees";
    public static final String[] COLUMN_NAMES = { "FIRST_NAME", "LAST_NAME", "DEPARTMENT_ID", "EGN", "EMAIL", "TELEPHONE"};

    private static final String INSERT_QUERY = TableEntry.generateInsertQuery(TABLE_NAME, COLUMN_NAMES);
    private static final String UPDATE_QUERY = TableEntry.generateUpdateQuery(TABLE_NAME, ID_COLUMN_NAME, COLUMN_NAMES);

    private String firstName;
    private String lastName;
    private int departmentId;
    private String egn;
    private String email;
    private String telephone;

    public Employee(String firstName, String lastName, int departmentId, String egn, String email, String telephone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentId = departmentId;
        this.egn = egn;
        this.email = email;
        this.telephone = telephone;
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
        statement.setString(1, firstName);
        statement.setString(2, lastName);
        statement.setInt(3, departmentId);
        statement.setString(4, egn);
        statement.setString(5, email);
        statement.setString(6, telephone);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public String getEgn() {
        return egn;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }
}


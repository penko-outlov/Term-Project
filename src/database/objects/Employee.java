package database.objects;

import org.h2.table.Table;
import utility.StringUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Employee extends TableEntry {

    public static final String TABLE_NAME = "employees";

    private String firstName;
    private String lastName;
    private int departmentId;
    private String egn;
    private String email;
    private String telephone;

    private static final String COLUMN_NAMES = "(FIRST_NAME, LAST_NAME, DEPARTMENT_ID, EGN, EMAIL, TELEPHONE)";

    public Employee(String firstName, String lastName, int departmentId, String egn, String email, String telephone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentId = departmentId;
        this.egn = egn;
        this.email = email;
        this.telephone = telephone;
    }

    @Override
    public PreparedStatement generateInsertStatement(Connection databaseConnection, String schemaName) {
        String query = "INSERT INTO " + schemaName + "." + TABLE_NAME + " " + COLUMN_NAMES + " VALUES " + StringUtility.CreateQueryParenthesizedList(6);

        PreparedStatement statement = null;
        try {
            statement = databaseConnection.prepareStatement(query);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setInt(3, departmentId);
            statement.setString(4, egn);
            statement.setString(5, email);
            statement.setString(6, telephone);
        } catch (SQLException e) {
            System.out.println("Failed to generate prepared statement!");
            e.printStackTrace();
        }
        return  statement;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getEgn() {
        return egn;
    }

    public void setEgn(String egn) {
        this.egn = egn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

}


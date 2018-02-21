package database.objects;

import utility.StringUtility;

public class Employee {
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

    @Override
    public String toString() {
        return COLUMN_NAMES + " VALUES " + StringUtility.CreateParenthesizedList(firstName, lastName, departmentId, egn, email, telephone);
    }
}


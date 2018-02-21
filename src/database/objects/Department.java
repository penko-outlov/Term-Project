package database.objects;


import utility.StringUtility;

public class Department {
    private int managerId;
    private String name;

    private static final String COLUMN_NAMES = "(MANAGER_ID, NAME)";

    public Department(int managerId, String name) {
        this.managerId = managerId;
        this.name = name;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return COLUMN_NAMES + " VALUES " + StringUtility.CreateParenthesizedList(managerId, name);
    }
}

package database.objects;


public class Department {
    private int departmentId;
    private int managerId;
    private String name;

    public Department(int departmentId, int managerId, String name) {
        this.departmentId = departmentId;
        this.managerId = managerId;
        this.name = name;
    }

    public int getDepartmentId() {
        return departmentId;
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
        return "(" + departmentId + ", " + managerId + ", " + "'" + name + "');";
    }
}

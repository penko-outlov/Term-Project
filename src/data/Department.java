package data;


public class Department {

    private int departmentId;
    private Employee manager;
    private String name;

    public Department(int departmentId, Employee manager, String name) {
        this.departmentId = departmentId;
        this.manager = manager;
        this.name = name;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package database.objects;


public class Department {

    private int departmentId;
    private database.objects.Employee manager;
    private String name;

    public Department(int departmentId, database.objects.Employee manager, String name) {
        this.departmentId = departmentId;
        this.manager = manager;
        this.name = name;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public database.objects.Employee getManager() {
        return manager;
    }

    public void setManager(database.objects.Employee manager) {
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

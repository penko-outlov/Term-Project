package data;

import java.util.Date;

public class Task {

    private int taskId;

    private String name;
    private String description;
    private String status;
    private Department department;   //Maybe switch to reference?
    private Employee requester;
    private Employee taker;
    private Date requestDate;
    private Date dateTaken;
    private int timeEstimateHours;
    private Date dateCompleted;

    public Task(int taskId, String name, String description, String status, Department department, Employee requester, Employee taker, Date requestDate, Date dateTaken, int timeEstimateHours, Date dateCompleted) {
        this.taskId = taskId;
        this.name = name;
        this.description = description;
        this.status = status;
        this.department = department;
        this.requester = requester;
        this.taker = taker;
        this.requestDate = requestDate;
        this.dateTaken = dateTaken;
        this.timeEstimateHours = timeEstimateHours;
        this.dateCompleted = dateCompleted;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee getRequester() {
        return requester;
    }

    public void setRequester(Employee requester) {
        this.requester = requester;
    }

    public Employee getTaker() {
        return taker;
    }

    public void setTaker(Employee taker) {
        this.taker = taker;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(Date dateTaken) {
        this.dateTaken = dateTaken;
    }

    public int getTimeEstimateHours() {
        return timeEstimateHours;
    }

    public void setTimeEstimateHours(int timeEstimateHours) {
        this.timeEstimateHours = timeEstimateHours;
    }

    public Date getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(Date dateCompleted) {
        this.dateCompleted = dateCompleted;
    }
}




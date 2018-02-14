package database.objects;

import java.util.Date;

public class Task {
    private int taskId;

    private String name;
    private String description;
    private String status;
    private database.objects.Department department;   //Maybe switch to reference?
    private database.objects.Employee requester;
    private database.objects.Employee taker;
    private Date requestDate;
    private Date dateTaken;
    private int timeEstimateHours;
    private Date dateCompleted;

    public Task(int taskId, String name, String description, String status, database.objects.Department department, database.objects.Employee requester, database.objects.Employee taker, Date requestDate, Date dateTaken, int timeEstimateHours, Date dateCompleted) {
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

    public database.objects.Department getDepartment() {
        return department;
    }

    public void setDepartment(database.objects.Department department) {
        this.department = department;
    }

    public database.objects.Employee getRequester() {
        return requester;
    }

    public void setRequester(database.objects.Employee requester) {
        this.requester = requester;
    }

    public database.objects.Employee getTaker() {
        return taker;
    }

    public void setTaker(database.objects.Employee taker) {
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




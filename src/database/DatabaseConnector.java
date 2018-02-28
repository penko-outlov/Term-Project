package database;

import database.objects.Department;
import database.objects.Employee;
import database.objects.TableEntry;
import database.objects.Task;
import database.queries.IQuery;
import database.queries.departments.DeleteDepartmentQuery;
import database.queries.employee.DeleteEmployeeQuery;
import database.queries.tasks.DeleteTaskQuery;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnector {
    private static Connection connection = null;

    public static Connection getConnection() {
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test2", "JohnSmith", "");
            Statement statement = connection.createStatement();
            statement.execute("SET SCHEMA TASK_MANAGEMENT");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static TableModel getTaskModel() {
        return getTableModel(Task.TABLE_NAME, new TaskTableModel());
    }

    public static TableModel getDepartmentModel() {
        return getTableModel(Department.TABLE_NAME, new TableModel());
    }

    public static TableModel getEmployeeModel() {
        return getTableModel(Employee.TABLE_NAME, new TableModel());
    }

    public static TableModel getStatusModel() { return getTableModel(Task.STATUS_TABLE_NAME, new TableModel());}

    private static TableModel getTableModel(String tableName, TableModel model) {
        connection = getConnection();
        String sql = "select * from task_management." + tableName + ";";
        ResultSet result = null;

        try {
            PreparedStatement state = connection.prepareStatement(sql);
            result = state.executeQuery();
            model.Initialize(result);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return model;
    }

    public static void deleteTask(int id) { executeQuery(new DeleteTaskQuery(id));}

    public static void deleteDepartment(int id) { executeQuery(new DeleteDepartmentQuery(id));}

    public static void deleteEmployee(int id) { executeQuery(new DeleteEmployeeQuery(id));}

    public static TableModel executeQuery(IQuery query) {
        connection = getConnection();
        ResultSet result = query.execute(connection);

        if(result != null) {
            TableModel model = new TableModel();
            model.Initialize(result);
            return model;
        }

        return null;
    }

}

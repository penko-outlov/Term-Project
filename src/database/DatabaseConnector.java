package database;

import database.objects.*;
import database.queries.IQuery;
import database.queries.SelectAllQuery;
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
        return executeQuery(new SelectAllQuery(Task.TABLE_NAME));
    }

    public static TableModel getDepartmentModel() {
        return executeQuery(new SelectAllQuery(Department.TABLE_NAME));
    }

    public static TableModel getEmployeeModel() {
        return executeQuery(new SelectAllQuery(Employee.TABLE_NAME));
    }

    public static TableModel getStatusModel() {
        return executeQuery(new SelectAllQuery(Status.TABLE_NAME));
    }

    public static void deleteTask(int id) { executeQuery(new DeleteTaskQuery(id));}

    public static void deleteDepartment(int id) { executeQuery(new DeleteDepartmentQuery(id));}

    public static void deleteEmployee(int id) { executeQuery(new DeleteEmployeeQuery(id));}

    public static TableModel executeQuery(IQuery query) {
        connection = getConnection();
        return query.execute(connection);
    }

}

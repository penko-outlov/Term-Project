package database;

import database.objects.Department;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnector {
    static Connection connection = null;

    private static final String SCHEMA_NAME = "task_management";
    private static final String TASK_TABLE_NAME = "tasks";
    private static final String DEPARTMENT_TABLE_NAME = "departments";
    private static final String EMPLOYEE_TABLE_NAME = "employees";

    public static Connection getConnection() {
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "Angelord", "");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static TableModel getTaskModel() {
        return getTableModel(TASK_TABLE_NAME);
    }

    public static TableModel getDepartmentModel() {
        return getTableModel(DEPARTMENT_TABLE_NAME);
    }

    public static TableModel getEmployeeModel() {
        return getTableModel(EMPLOYEE_TABLE_NAME);
    }

    private static TableModel getTableModel(String tableName) {
        connection = getConnection();
        String sql = "select * from task_management." + tableName + ";";
        ResultSet result = null;
        TableModel model = null;

        try {
            PreparedStatement state = connection.prepareStatement(sql);
            result = state.executeQuery();
            model = new TableModel(result);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return model;
    }

    public static void insertDepartment(Department department) {
        connection = getConnection();

        try {
            Statement statement = connection.createStatement();

            statement.executeUpdate("INSERT INTO " + SCHEMA_NAME + "." + DEPARTMENT_TABLE_NAME + " VALUES " + department);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnector {
    static Connection connection = null;

    public static Connection getConnection() {
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test2", "JohnSmith", "");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static TableModel getTaskModel() {
        return getTableModel("tasks");
    }

    public static TableModel getDepartmentModel() {
        return getTableModel("departments");
    }

    public static TableModel getEmployeeModel() {
        return getTableModel("employees");
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
}

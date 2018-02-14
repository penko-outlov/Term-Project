package visual;

import database.DatabaseConnector;
import database.TableModel;
import database.objects.Department;

import javax.swing.SwingUtilities;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        Connection connection = DatabaseConnector.getConnection();

        if(connection == null) {
            System.out.println("Failed to connect");
            return;
        }

        DatabaseConnector.insertDepartment(new Department(4, 1, "Moscow"));

        TableModel depTable = DatabaseConnector.getDepartmentModel();
        System.out.println(depTable.getValueAt(3, 2));

        SwingUtilities.invokeLater(() -> {
            new Window();
        });
    }
}
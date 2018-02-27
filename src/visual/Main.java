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

        SwingUtilities.invokeLater(() -> {
            new Window();
        });
    }
}
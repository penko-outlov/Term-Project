package visual;

import database.DatabaseConnector;

import javax.swing.SwingUtilities;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        Connection connection = DatabaseConnector.getConnection();

        if(connection != null) {
            System.out.println("Connection successful!");
        }

        SwingUtilities.invokeLater(() -> {
            new Window();
        });
    }
}
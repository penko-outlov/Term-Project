package visual;

import database.DatabaseConnector;
import database.TableModel;
import ui2.TaskManagementFrame;

import javax.swing.SwingUtilities;
import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TaskManagementFrame();
        });


        /*
        Connection connection = DatabaseConnector.getConnection();

        if(connection == null) {
            System.out.println("Failed to connect");
            return;
        }

        SwingUtilities.invokeLater(() -> {
            new Window();
        });
        */
    }
}
package visual;

import database.DatabaseConnector;
import database.TableModel;
import database.objects.Department;
import database.objects.Employee;
import org.h2.engine.Database;
import utility.StringUtility;

import javax.swing.SwingUtilities;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        //DatabaseConnector.insertRow(new Department(4, "Paris"));
        //DatabaseConnector.insertRow(new Employee("Georgi", "Georgiev", 3, "0000000000", "IvaneIvane@gmail.com", "0888888888"));

        //DatabaseConnector.deleteEmployee(11);



        Connection connection = DatabaseConnector.getConnection();

        if(connection == null) {
            System.out.println("Failed to connect");
            return;
        }

        TableModel depTable = DatabaseConnector.getDepartmentModel();

        SwingUtilities.invokeLater(() -> {
            new Window();
        });


    }
}
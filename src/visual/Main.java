package visual;

import database.DatabaseConnector;
import database.queries.InsertDepartmentQuery;

public class Main {
    public static void main(String[] args) {

        //DatabaseConnector.deleteDepartment(8);
        //DatabaseConnector.insertRow(new Department(4, "Prague"));
        //DatabaseConnector.insertRow(new Employee("Georgi", "Georgiev", 3, "0000000000", "IvaneIvane@gmail.com", "0888888888"));

        //DatabaseConnector.deleteEmployee(11);
        //TableModel taskModel = DatabaseConnector.getTaskModel();
        //System.out.println(taskModel.getValueAt(0, 3));

        DatabaseConnector.executeQuery(new InsertDepartmentQuery(1, "Beijing"));

        /*
        Connection connection = DatabaseConnector.getConnection();

        if(connection == null) {
            System.out.println("Failed to connect");
            return;
        }

        TableModel depTable = DatabaseConnector.getDepartmentModel();

        SwingUtilities.invokeLater(() -> {
            new Window();
        });
        */

    }
}
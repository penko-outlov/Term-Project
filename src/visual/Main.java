package visual;

import database.DatabaseConnector;
import database.queries.departments.DeleteDepartmentQuery;
import database.queries.departments.InsertDepartmentQuery;
import database.queries.departments.UpdateDepartmentQuery;
import database.queries.employee.DeleteEmployeeQuery;
import database.queries.employee.InsertEmployeeQuery;
import database.queries.tasks.DeleteTaskQuery;
import database.queries.tasks.InsertTaskQuery;
import database.queries.tasks.MarkTaskFinishedQuery;

public class Main {
    public static void main(String[] args) {


        //-------------TASKS-------------//
        // DatabaseConnector.executeQuery(new InsertTaskQuery("Create Snow Level", "Make a first layout for the snow level", 3, 3));
        // DatabaseConnector.executeQuery(new TakeTaskQuery(2, 2, 5));
        // DatabaseConnector.executeQuery(new MarkTaskFinishedQuery(2));
        // DatabaseConnector.executeQuery(new DeleteTaskQuery(4));

        //-------------DEPARTMENTS-------------//
        // DatabaseConnector.executeQuery(new InsertDepartmentQuery("Jerusalem", 2));
        // DatabaseConnector.executeQuery(new DeleteDepartmentQuery(2));
        //--Update--//
        // DatabaseConnector.executeQuery(new UpdateDepartmentQuery(2, null, 2));    //Change manager id only
        // DatabaseConnector.executeQuery(new UpdateDepartmentQuery(5, "Paris", null));   //Change name only
        // DatabaseConnector.executeQuery(new UpdateDepartmentQuery(3, "Moscow", 4));  // Change both

        //-------------EMPLOYEES-------------//
        // DatabaseConnector.executeQuery(new InsertEmployeeQuery("Georgi", "Georgiev", "9999999999", "Georgiev@gmail.com", 2));
        // DatabaseConnector.executeQuery(new DeleteEmployeeQuery(2));

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
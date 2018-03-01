package visual;

import database.DatabaseConnector;
import database.TableModel;
import database.queries.departments.DeleteDepartmentQuery;
import database.queries.departments.InsertDepartmentQuery;
import database.queries.departments.UpdateDepartmentQuery;
import database.queries.employee.DeleteEmployeeQuery;
import database.queries.employee.InsertEmployeeQuery;
import database.queries.employee.UpdateEmployeeQuery;
import database.queries.tasks.DeleteTaskQuery;
import database.queries.tasks.InsertTaskQuery;
import database.queries.tasks.MarkTaskFinishedQuery;
import org.h2.engine.Database;
import ui2.TaskManagementFrame;

import javax.swing.*;
import javax.xml.crypto.Data;

public class Main {

    //-------------TASKS-------------//
    // DatabaseConnector.executeQuery(new InsertTaskQuery("Create Snow Level", "Make a first layout for the snow level", 3, 3));
    // DatabaseConnector.executeQuery(new TakeTaskQuery(2, 2, 5));
    // DatabaseConnector.executeQuery(new MarkTaskFinishedQuery(2));
    // DatabaseConnector.executeQuery(new DeleteTaskQuery(4));
    //DatabaseConnector.executeQuery(new SelectTasksForDepartment("Moscow")

    //-------------DEPARTMENTS-------------//
    // DatabaseConnector.executeQuery(new InsertDepartmentQuery("Jerusalem", 2));
    // DatabaseConnector.executeQuery(new DeleteDepartmentQuery(2));
    // DatabaseConnector.executeQuery(new UpdateDepartmentQuery(2, null, 2));    //Change manager id only
    // DatabaseConnector.executeQuery(new UpdateDepartmentQuery(5, "Paris", null));   //Change name only
    // DatabaseConnector.executeQuery(new UpdateDepartmentQuery(3, "Moscow", 4));  // Change both

    //-------------EMPLOYEES-------------//
    // DatabaseConnector.executeQuery(new InsertEmployeeQuery("Georgi", "Georgiev", "9999999999", "Georgiev@gmail.com", 2));
    // DatabaseConnector.executeQuery(new DeleteEmployeeQuery(2));
     //DatabaseConnector.executeQuery(new UpdateEmployeeQuery(6, "Dimitar", "Georgiev", null, "DimGer@gmail.com", 5 ,null));    //Set values that you want to stat the same to null
    // DatabaseConnector.executeQuery(new SelectEmployeesFromDepartmentQuery("Hong Kong"));

    public static void main(String[] args) {

        //DatabaseConnector.executeQuery(new InsertEmployeeQuery("Ivan", "Grigorov", "9999999999", "Ivan@gmail.com", 3));
        // DatabaseConnector.executeQuery(new InsertTaskQuery("Create Character Model", "", 2, 1));
        DatabaseConnector.executeQuery(new InsertEmployeeQuery("Georgi", "Georgiev", "9999999999", "Georgiev@gmail.com", 3));



        SwingUtilities.invokeLater(() -> {
            new TaskManagementFrame();
        });

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
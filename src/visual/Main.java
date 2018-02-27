package visual;

import database.DatabaseConnector;
import database.objects.Department;
import database.queries.delete.DeleteDepartmentQuery;
import database.queries.insert.InsertDepartmentQuery;

import javax.xml.crypto.Data;

public class Main {
    public static void main(String[] args) {

        //------------ Example deletion ------------//
        //DatabaseConnector.executeQuery(new DeleteDepartmentQuery(4));


        //------------ Example insertion ------------//
        //DatabaseConnector.executeQuery(new InsertDepartmentQuery(4, "Warsaw"));


        //DatabaseConnector.executeQuery(new InsertDepartmentQuery(1, "Beijing"));

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
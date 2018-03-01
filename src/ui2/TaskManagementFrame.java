package ui2;

import database.DatabaseConnector;
import database.queries.employee.SelectEmployeesFromDepartmentQuery;

import javax.swing.*;
import java.awt.*;

public class TaskManagementFrame extends JFrame {

    JPanel mainframe;

    public TaskManagementFrame() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800, 700);

        mainframe = new JPanel();
        mainframe.setLayout(new BorderLayout());

        JTable table = new JTable(DatabaseConnector.executeQuery(new SelectEmployeesFromDepartmentQuery("Hong Kong")));
        mainframe.add(table, BorderLayout.CENTER);

        this.getContentPane().add(mainframe);

        this.setVisible(true);
    }

}

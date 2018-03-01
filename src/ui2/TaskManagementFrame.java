package ui2;

import database.DatabaseConnector;
import database.queries.departments.SelectDepartmentsWithManager;
import database.queries.employee.SelectEmployeesFromDepartmentQuery;
import database.queries.special.SelectEmployeesForTask;
import database.queries.tasks.SelectTasksForDepartment;

import javax.swing.*;
import java.awt.*;

public class TaskManagementFrame extends JFrame {

    JPanel mainframe;

    public TaskManagementFrame() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1000, 800);

        mainframe = new JPanel();
        mainframe.setLayout(new BorderLayout());

        //JTable table = new JTable(DatabaseConnector.executeQuery(new SelectTasksForDepartment("Moscow")));
        JTable table = new JTable(DatabaseConnector.executeQuery(new SelectEmployeesForTask("Create Pathfinding")));

        mainframe.add(table, BorderLayout.CENTER);

        this.getContentPane().add(mainframe);

        this.setVisible(true);
    }

}

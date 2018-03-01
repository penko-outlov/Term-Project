package ui2;

import database.DatabaseConnector;
import database.queries.departments.SelectDepartmentsWithManager;
import database.queries.employee.SelectEmployeesFromDepartmentQuery;
import database.queries.special.SelectDepartmentTasksBefore;
import database.queries.special.SelectEmployeesForTask;
import database.queries.special.SelectTasksForDepartmentWithStatus;
import database.queries.tasks.SelectTasksForDepartment;
import ui2.queries.SelectTasksForDepartmentWithStatusPanel;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TaskManagementFrame extends JFrame {

    JPanel mainframe;

    public TaskManagementFrame() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1200, 800);

        mainframe = new JPanel();
        mainframe.setLayout(new BorderLayout());

        //JTable table = new JTable(DatabaseConnector.executeQuery(new SelectTasksForDepartment("Moscow")));
        LocalDateTime deadline =  LocalDateTime.of(2018, 3, 15, 0,0);
        JTable table = new JTable(DatabaseConnector.executeQuery(new SelectDepartmentTasksBefore("Marketing", deadline )));
        mainframe.add(table, BorderLayout.CENTER);

        JPanel rightPanel = new JPanel();
        JPanel queryPanel = new SelectTasksForDepartmentWithStatusPanel(table);
        rightPanel.add(queryPanel);
        mainframe.add(rightPanel, BorderLayout.EAST);

        this.getContentPane().add(mainframe);

        this.setVisible(true);
    }

}

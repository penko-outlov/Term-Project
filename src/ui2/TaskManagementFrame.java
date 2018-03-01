package ui2;

import database.DatabaseConnector;
import database.queries.departments.SelectDepartmentsWithManager;
import database.queries.employee.SelectEmployeesFromDepartmentQuery;
import database.queries.special.SelectDepartmentTasksBefore;
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
        this.setSize(1400, 800);

        mainframe = new JPanel();
        mainframe.setLayout(new BorderLayout());

        JTable table = new JTable(DatabaseConnector.getTaskModel());
        mainframe.add(table, BorderLayout.CENTER);

        JPanel rightPanel = new JPanel();
        //JPanel queryPanel = new SelectTasksForDepartmentWithStatusPanel(table);
        //rightPanel.add(queryPanel);
        mainframe.add(rightPanel, BorderLayout.EAST);

        this.getContentPane().add(mainframe);

        this.setVisible(true);
    }

}

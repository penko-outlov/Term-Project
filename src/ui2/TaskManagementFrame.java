package ui2;

import database.DatabaseConnector;
import ui2.queries.employees.SelectEmployeesFromDepartmentPanel;

import javax.swing.*;
import java.awt.*;

public class TaskManagementFrame extends JFrame {

    private JPanel mainframe;

    public TaskManagementFrame() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1400, 800);
        this.setResizable(false);

        mainframe = new JPanel();

        addTables();

        this.getContentPane().add(mainframe);

        this.pack();
        center();
        this.setVisible(true);
    }

    private void center() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int xPos = (int)((screenSize.getWidth() - this.getWidth()) / 2);
        int yPos = (int)((screenSize.getHeight() - this.getHeight()) / 2);
        this.setLocation(xPos, yPos);
    }

    private void addTables() {
        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Tasks", new TaskPanel());
        tabbedPane.addTab("Employees", new EmployeePanel());
        tabbedPane.addTab("Departments", new DepartmentPanel());

        mainframe.add(tabbedPane);
    }

}

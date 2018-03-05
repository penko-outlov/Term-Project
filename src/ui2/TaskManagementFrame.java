package ui2;

import database.DatabaseConnector;
import ui2.queries.SelectDepartmentsWithManagerPanel;
import ui2.queries.SelectEmployeesFromDepartmentPanel;
import ui2.queries.SelectTasksForDepartmentPanel;

import javax.swing.*;
import java.awt.*;

public class TaskManagementFrame extends JFrame {

    private JPanel mainframe;

    public TaskManagementFrame() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1400, 800);

        mainframe = new JPanel();
        mainframe.setLayout(new BorderLayout());

        JTable table = new JTable(DatabaseConnector.getTaskModel());
        mainframe.add(table, BorderLayout.CENTER);

        JPanel rightPanel = new JPanel();
        JPanel queryPanel = new SelectDepartmentsWithManagerPanel(table);
        rightPanel.add(queryPanel);
        mainframe.add(rightPanel, BorderLayout.EAST);

        this.getContentPane().add(mainframe);

        this.setVisible(true);
    }

}

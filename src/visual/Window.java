package visual;

import database.DatabaseConnector;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;

public class Window extends JFrame {
    public static final int WINDOW_WIDTH = 1000;
    public static final int WINDOW_HEIGHT = WINDOW_WIDTH / 4 * 3;
    public static final String NAME = "Task Management";

    private JPanel dataPanel = new JPanel();
    private EmployeePanel employeePanel = new EmployeePanel(DatabaseConnector.getEmployeeModel());
    private DepartmentPanel departmentPanel  = new DepartmentPanel(DatabaseConnector.getDepartmentModel());
    private TaskPanel taskPanel = new TaskPanel(DatabaseConnector.getTaskModel());

    private JPanel navigationPanel = new JPanel();
    private JButton next = new JButton("Next");
    private JButton previous = new JButton("Previous");

    public Window() {
        setTitle(NAME);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setVisible(true);

        makeDataPanel();
        makeNavigationPanel();
    }

    private void makeDataPanel() {
        dataPanel.setLayout(new CardLayout());
        dataPanel.add(employeePanel);
        dataPanel.add(departmentPanel);
        dataPanel.add(taskPanel);
        add(dataPanel, BorderLayout.CENTER);
    }

    private void makeNavigationPanel() {
        previous.addActionListener((e) -> {
            CardLayout layout = (CardLayout) dataPanel.getLayout();
            layout.previous(dataPanel);
        });
        navigationPanel.add(previous);

        next.addActionListener((e) -> {
            CardLayout layout = (CardLayout) dataPanel.getLayout();
            layout.next(dataPanel);
        });
        navigationPanel.add(next);

        add(navigationPanel, BorderLayout.SOUTH);
    }
}

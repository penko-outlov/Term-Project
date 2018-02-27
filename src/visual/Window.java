package visual;

import database.DatabaseConnector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class Window extends JFrame {
    public static final int WINDOW_WIDTH = 1000;
    public static final int WINDOW_HEIGHT = WINDOW_WIDTH / 4 * 3;
    public static final String NAME = "Task Management";

    private JPanel navigationPanel = new JPanel();
    private JButton next = new JButton("Next");
    private JButton previous = new JButton("Previous");

    public Window() {
        setTitle(NAME);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1));
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

        makeNavigationPanel();
    }

    public void makeNavigationPanel() {
        navigationPanel.setLayout(new GridLayout(1, 2));

        previous.addActionListener((e) -> {
        });
        navigationPanel.add(previous);

        next.addActionListener((e) -> {
        });
        navigationPanel.add(next);

        add(navigationPanel);
    }
}

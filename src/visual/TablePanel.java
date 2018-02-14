package visual;

import database.TableModel;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class TablePanel extends JPanel {
    private JTable currentTable;
    private JPanel sidePanel;

    public TablePanel(TableModel tableModel) {
//        currentTable = new JTable(tableModel);

        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
//        add(currentTable, BorderLayout.CENTER);
        initializeSidePanel();
    }

    private void initializeSidePanel() {
        add(new JPanel());
        sidePanel = new JPanel();
        sidePanel.setSize(200, Window.WINDOW_HEIGHT);
        sidePanel.setLayout(new GridLayout(5, 1));
        for (int i = 0; i < 5; i++) {
            sidePanel.add(new JButton((i + 1) + " Button"));
        }
        add(sidePanel);
    }
}

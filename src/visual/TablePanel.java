package visual;

import database.TableModel;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class TablePanel extends JPanel {
    protected JScrollPane tablePane;
    protected JTable currentTable;
    protected JPanel sidePanel;

    public TablePanel(TableModel tableModel) {
        currentTable = new JTable(tableModel);
        currentTable.setFillsViewportHeight(true);
        tablePane = new JScrollPane(currentTable);
        add(tablePane);

        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        add(currentTable);
        initializeSidePanel();
    }

    private void initializeSidePanel() {
        sidePanel = new JPanel();
        sidePanel.setSize(200, Window.WINDOW_HEIGHT);
        sidePanel.setLayout(new GridLayout(5, 1));

        for (int i = 0; i < 3; i++) {
            sidePanel.add(new JButton((i + 1) + ""));
        }

        add(sidePanel);
    }
}

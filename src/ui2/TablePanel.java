package ui2;

import database.TableModel;

import javax.swing.*;
import java.awt.*;

public abstract class TablePanel extends JPanel {

    protected JTable table;
    protected TableSidePanel sidePanel;

    public TablePanel(TableModel model) {


        this.setLayout(new BorderLayout());

        JPanel tablePanel = new JPanel();
        table = new JTable(model);
        table.setFillsViewportHeight(true);

        JScrollPane scrollPanel = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tablePanel.add(scrollPanel);

        sidePanel = new TableSidePanel();
        addQueriesToSidePanel();
        sidePanel.initialize();

        this.add(tablePanel, BorderLayout.CENTER);
        this.add(sidePanel, BorderLayout.EAST);
    }

    protected abstract void addQueriesToSidePanel();
}

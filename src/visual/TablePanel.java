package visual;

import com.sun.corba.se.impl.encoding.CodeSetConversion;
import database.TableModel;
import org.h2.util.CacheTQ;

import javax.imageio.spi.IIOServiceProvider;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;

public abstract class TablePanel extends JPanel {
    protected JTable currentTable;
    protected JScrollPane tablePane;

    protected JPanel sidePanel = new JPanel();
    protected JLabel info = new JLabel("Select an action:", JLabel.CENTER);
    protected String[] queries = { "Insert", "Delete", "Update", "Select" };
    protected JComboBox<String> controls = new JComboBox<>(queries);
    protected JButton execute = new JButton("Execute");

    public TablePanel(TableModel tableModel) {
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        currentTable = new JTable(tableModel);
        currentTable.setFillsViewportHeight(true);
        currentTable.setDragEnabled(false);
        tablePane = new JScrollPane(currentTable);
        add(tablePane);
    }

    protected abstract void makeSidePanel();
}

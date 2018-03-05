package visual;

import com.sun.corba.se.impl.encoding.CodeSetConversion;
import com.sun.deploy.security.MSCryptoProvider;
import database.DatabaseConnector;
import database.TableModel;
import database.queries.employee.DeleteEmployeeQuery;
import org.h2.util.CacheTQ;

import javax.imageio.spi.IIOServiceProvider;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TablePanel extends JPanel implements ActionListener {
    protected JTable currentTable;
    protected JScrollPane tablePane;

    protected JPanel sidePanel = new JPanel();
    protected JPanel queryView = new JPanel(new CardLayout());
    protected JPanel controlPanel = new JPanel();

    protected JLabel info = new JLabel("Select an action:", JLabel.CENTER);
    protected String[] queries = {"Insert", "Delete", "Update", "Select"};
    protected JComboBox<String> controls = new JComboBox<>(queries);
    protected JButton execute = new JButton("Insert");

    public TablePanel(TableModel tableModel) {
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        currentTable = new JTable(tableModel);
        currentTable.setFillsViewportHeight(true);
        currentTable.setDragEnabled(false);
        tablePane = new JScrollPane(currentTable);
        add(tablePane);

        makeSidePanel();
    }

    protected void makeSidePanel() {
        JPanel insertPanel = new JPanel();
        insertPanel.add(new JTextField("First name", 20));
        insertPanel.add(new JTextField("Last name", 20));
        insertPanel.add(new JTextField("EGN", 15));
        insertPanel.add(new JTextField("Phone number", 15));
        execute.addActionListener(this);
        insertPanel.add(execute);
        queryView.add(insertPanel, "Insert");

        JPanel deletePanel = new JPanel();
        deletePanel.add(new JLabel("Select an entry with the mouse to delete it.", JLabel.CENTER));
        execute = new JButton("Delete");
        execute.addActionListener(this);
        deletePanel.add(execute);
        queryView.add(deletePanel, "Delete");

        JPanel updatePanel = new JPanel();
        updatePanel.add(new JLabel("Choose a cell to edit.", JLabel.CENTER));
        updatePanel.add(new JTextField("New value", 15));
        execute = new JButton("Update");
        execute.addActionListener(this);
        updatePanel.add(execute);
        queryView.add(updatePanel, "Update");

        sidePanel.add(queryView);

        controlPanel.add(info);
        controls.addItemListener((evt) -> {
            CardLayout layout = (CardLayout) queryView.getLayout();
            layout.show(queryView, (String) evt.getItem());
        });
        controlPanel.add(controls);
        sidePanel.add(controlPanel);

        add(sidePanel);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (currentTable.getSelectedRow() == -1 && currentTable.getSelectedColumn() == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row, column or cell from the table.");
            return;
        }
        String action = (String) controls.getSelectedItem();
        switch (action) {
            case "Insert":
                break;
            case "Delete":
                int row = currentTable.getSelectedRow();
                int employeeId = (int) currentTable.getValueAt(row, 0);
                DatabaseConnector.executeQuery(new DeleteEmployeeQuery(employeeId));
                break;
            case "Update":
                break;
            case "Select":
                break;
        }
    }
}

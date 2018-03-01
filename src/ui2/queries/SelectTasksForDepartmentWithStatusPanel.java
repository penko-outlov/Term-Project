package ui2.queries;

import database.DatabaseConnector;
import database.TableModel;
import database.queries.special.SelectTasksForDepartmentWithStatus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SelectTasksForDepartmentWithStatusPanel extends JPanel implements ActionListener {

    JTextField departmentNameField;
    JComboBox statusDropdown;
    JTable targetTable;

    public SelectTasksForDepartmentWithStatusPanel(JTable targetTable) {

        this.targetTable = targetTable;

        this.setLayout(new SpringLayout());

        createDepartmentNameField();;
        createStatusComboBox();
        createButton();

        layout.SpringUtilities.makeCompactGrid(this,
                3, 2, //rows, cols
                6, 6,        //initX, initY
                6, 6);       //xPad, yPad
    }

    private void createDepartmentNameField() {
        JLabel label = new JLabel("Department");
        this.add(label);

        departmentNameField = new JTextField(30);
        this.add(departmentNameField);
    }

    private void createStatusComboBox() {
        JLabel label = new JLabel("Status");
        this.add(label);

        TableModel statusTable = DatabaseConnector.getStatusModel();
        List<String> statusTypes = new ArrayList<>();
        for(int i = 0; i < statusTable.getRowCount(); i++) {
            statusTypes.add((String) statusTable.getValueAt(i, 1));
        }

        statusDropdown = new JComboBox(statusTypes.toArray());
        statusDropdown.setSelectedIndex(1);
        statusDropdown.addActionListener(this);

        this.add(statusDropdown);
    }

    private void createButton() {
        this.add(new JPanel());

        JButton searchButton = new JButton("Search");
        searchButton.setActionCommand("search");
        searchButton.addActionListener(this);
        this.add(searchButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand() == "search") {
            targetTable.setModel(DatabaseConnector.executeQuery(new SelectTasksForDepartmentWithStatus(departmentNameField.getText(), statusDropdown.getSelectedIndex() + 1)));
        }
    }
}

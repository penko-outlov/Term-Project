package ui2.queries;

import database.DatabaseConnector;
import database.queries.employee.SelectEmployeesFromDepartmentQuery;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class QueryPanel extends JPanel implements ActionListener {


    protected JTable targetTable;

    public QueryPanel(JTable targetTable) {
        this.targetTable = targetTable;
        this.setLayout(new SpringLayout());

    }

    protected void makeCompactGrid(int numRows) {
        layout.SpringUtilities.makeCompactGrid(this,
                numRows, 2, //rows, cols
                6, 6,        //initX, initY
                6, 6);       //xPad, yPad
    }

    protected JTextField addTextField(String labelText) {
        this.add(new JLabel(labelText));

        JTextField textField = new JTextField(30);
        this.add(textField);

        return textField;
    }

    protected JLabel addLabel(String labelText) {
        this.add(new JPanel());
        JLabel newLabel = new JLabel(labelText);
        this.add(newLabel);
        return newLabel;
    }

    protected void addExecuteButton() {
        addExecuteButton("Execute");
    }

    protected void addExecuteButton(String buttonText) {
        this.add(new JPanel());

        JButton searchButton = new JButton(buttonText);
        searchButton.setActionCommand("execute");
        searchButton.addActionListener(this);
        this.add(searchButton);
    }


    @Override
    public final void actionPerformed(ActionEvent e) {
        if(e.getActionCommand() == "execute") {
            execute();
        }
    }

    protected abstract void execute();
}

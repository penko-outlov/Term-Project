package visual;

import database.DatabaseConnector;
import database.TableModel;
import database.queries.employee.DeleteEmployeeQuery;

import javax.swing.*;
import java.awt.CardLayout;
import java.awt.GridLayout;

public class EmployeePanel extends TablePanel {
    public EmployeePanel(TableModel tableModel) {
        super(tableModel);
    }
}

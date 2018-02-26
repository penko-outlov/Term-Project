package database;

import java.sql.ResultSet;

public class TaskTableModel extends TableModel {

    private TableModel statusTable;
    private int statusColumn;

    @Override
    public void Initialize(ResultSet resultSet){
        super.Initialize(resultSet);
        statusTable = DatabaseConnector.getStatusModel();
        determineStatusColumn();
    }

    private void determineStatusColumn() {
        for(int i = 0; i < getColumnCount(); i++) {
            if(getColumnName(i).toLowerCase().equals("status")) {
                statusColumn = i;
                return;
            }
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex == statusColumn) {
            return intToStatus((int)super.getValueAt(rowIndex, columnIndex));
        }

        return super.getValueAt(rowIndex, columnIndex);
    }

    private String intToStatus(int value) {
        return (String) statusTable.getValueAt(value, 1);
    }

}

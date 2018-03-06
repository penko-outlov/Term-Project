package database;

import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TableModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    private String tableName;
    private int rowCount;
    private int columnCount;
    private Object[][] data;
    private String[] columnNames;

    public TableModel() {}

    public void Initialize(ResultSet resultSet) {
        try {
            initializeData(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initializeData(ResultSet resultSet) throws Exception {
        columnCount = resultSet.getMetaData().getColumnCount();

        ArrayList<Object> tempData = new ArrayList<Object>();
        while (resultSet.next()) {
            Object[] row = new Object[columnCount];
            for (int j = 0; j < columnCount; j++) {
                row[j] = resultSet.getObject(j + 1);
            }
            tempData.add(row);
        }

        rowCount = tempData.size();

        data = new Object[rowCount][];
        for(int i = 0; i < rowCount; i++) {
            data[i] = (Object[]) tempData.get(i);
        }

        columnNames = new String[columnCount];
        for (int i = 0; i < columnNames.length; i++) {
            columnNames[i] = resultSet.getMetaData().getColumnLabel(i + 1);
        }

        tableName = resultSet.getMetaData().getTableName(1);
    }


    public String getTableName() {
        return tableName;
    }

    @Override
    public int getRowCount() {
        return rowCount;
    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

}

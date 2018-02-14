package database;

import org.h2.table.Table;

import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

public class TableModel extends AbstractTableModel {
    private static final long serialVersionUID = 1L;
    private ResultSet resultSet;
    private int rowCount;
    private int columnCount;
    private ArrayList<Object> data = new ArrayList<Object>();

    public TableModel(ResultSet resultSet) {
        this.resultSet = resultSet;
        try {
            initializeData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initializeData() throws Exception {
        while (resultSet.next()) {
            Object[] row = new Object[columnCount];
            for (int j = 0; j < columnCount; j++) {
                row[j] = resultSet.getObject(j + 1);
            }
            data.add(row);
        }

        rowCount = data.size();
        columnCount = resultSet.getMetaData().getColumnCount();
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
        Object[] row = (Object[]) data.get(rowIndex);
        return row[columnIndex];
    }

    @Override
    public String getColumnName(int columnIndex) {
        try {
            ResultSetMetaData metaData = resultSet.getMetaData();
            return metaData.getColumnName(columnIndex + 1);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

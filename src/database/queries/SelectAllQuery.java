package database.queries;

import database.TableModel;
import database.TaskTableModel;
import database.objects.Task;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SelectAllQuery extends Query {

    private String queryText;
    private String tableName;

    public SelectAllQuery(String tableName) {
        this.tableName = tableName;
        queryText = "SELECT * FROM " + tableName;
    }

    @Override
    protected String getQueryText() { return queryText; }

    @Override
    protected void setStatementValues(PreparedStatement statement) throws SQLException {}

    @Override
    protected TableModel createTableModel() {
        if(tableName.toLowerCase().equals(Task.TABLE_NAME.toLowerCase())) {
            return new TaskTableModel();
        }
        return super.createTableModel();
    }
}

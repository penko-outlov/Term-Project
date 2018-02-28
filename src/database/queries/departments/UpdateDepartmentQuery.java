package database.queries.departments;

import database.queries.Query;
import utility.StringUtility;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UpdateDepartmentQuery extends Query {

    private static final String QUERY = "INSERT INTO DEPARTMENTS (NAME, MANAGER_ID) " +
                                        "VALUES " + StringUtility.createQuestionMarkParenthesizedList(2);

    private int departmentId;
    private String name = null;
    private Integer managerId = null;


    public UpdateDepartmentQuery(int departmentId, String name, Integer managerId) {
        this.departmentId = departmentId;
        this.name = name;
        this.managerId = managerId;
    }

    @Override
    protected String getQueryText() {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("UPDATE DEPARTMENTS SET ");
        List<String> changedColumns = getChangedColumns();
        queryBuilder.append(StringUtility.createSqlStatementColumnList(changedColumns.toArray()));
        queryBuilder.append(" WHERE DEPARTMENT_ID = ?");
        return queryBuilder.toString();
    }

    private List<String> getChangedColumns() {
        List<String> changed = new ArrayList<>();
        if(name != null) { changed.add("NAME"); }
        if(managerId != null) { changed.add("MANAGER_ID"); }
        return changed;
    }

    @Override
    protected void setStatementValues(PreparedStatement statement) throws SQLException {
        int index = 1;
        if(name != null) { statement.setString(index, name); index++; }
        if(managerId != null) { statement.setInt(index, managerId.intValue()); index++; }
        statement.setInt(index, departmentId);
    }
}

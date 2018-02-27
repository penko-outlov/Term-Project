package database.queries;

import database.objects.Department;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDepartmentQuery extends InsertQuery {
    private Department department;

    public InsertDepartmentQuery(Department department) {
        super(Department.TABLE_NAME, Department.COLUMN_NAMES);
        this.department = department;
    }

    @Override
    protected void setStatementValues(PreparedStatement statement) throws SQLException {
        statement.setInt(1, department.getManagerId());
        statement.setString(2, department.getName());
    }
}

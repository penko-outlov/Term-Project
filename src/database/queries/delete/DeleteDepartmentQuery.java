package database.queries.delete;

import database.objects.Department;

public class DeleteDepartmentQuery extends DeleteQuery {

    private static final String query = "DELETE FROM " + Department.TABLE_NAME + " WHERE " + Department.ID_COLUMN_NAME + " = ?";

    public DeleteDepartmentQuery(int id) {
        super(id, query);
    }
}

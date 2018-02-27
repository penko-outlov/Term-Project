package database.queries.delete;

import database.objects.Employee;

public class DeleteEmployeeQuery extends DeleteQuery {

    private static final String query = "DELETE FROM " + Employee.TABLE_NAME + " WHERE " + Employee.ID_COLUMN_NAME + " = ?";

    public DeleteEmployeeQuery(int id) {
        super(id, query);
    }
}

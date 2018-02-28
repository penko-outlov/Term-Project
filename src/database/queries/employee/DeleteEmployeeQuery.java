package database.queries.employee;

import database.objects.Employee;
import database.queries.DeleteQuery;

public class DeleteEmployeeQuery extends DeleteQuery {

    private static final String query = "DELETE FROM " + Employee.TABLE_NAME + " WHERE " + Employee.ID_COLUMN_NAME + " = ?";

    public DeleteEmployeeQuery(int id) {
        super(id, query);
    }
}

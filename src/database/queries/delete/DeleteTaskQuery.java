package database.queries.delete;

import database.objects.Task;

public class DeleteTaskQuery extends DeleteQuery {

    private static final String query = "DELETE FROM " + Task.TABLE_NAME + " WHERE " + Task.ID_COLUMN_NAME + " = ?";

    public DeleteTaskQuery(int id) {
        super(id, query);
    }

}

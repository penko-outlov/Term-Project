package database.objects;

import java.sql.Connection;
import java.sql.PreparedStatement;

public abstract class TableEntry {

    public abstract PreparedStatement generateInsertStatement(Connection databaseConnection, String schemaName);
}

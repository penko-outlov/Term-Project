package database.objects;

import java.sql.Connection;
import java.sql.PreparedStatement;

public abstract class TableEntry {

    public abstract PreparedStatement generateInsertStatement(Connection databaseConnection);

    //public abstract PreparedStatement generateUpdateStatement(Connection databaseConnection, String schemaName, int id);
}

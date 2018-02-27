package database.queries;

import java.sql.Connection;
import java.sql.PreparedStatement;

public interface IQuery {
    PreparedStatement getPreparedStatement(Connection databaseConnection);
}

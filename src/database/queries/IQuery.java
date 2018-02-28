package database.queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface IQuery {
    ResultSet execute(Connection databaseConnection);
}

package database.queries;

import database.TableModel;

import java.sql.Connection;

public interface IQuery {
    TableModel execute(Connection databaseConnection);
}

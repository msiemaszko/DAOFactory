package factoryDAO;

import java.sql.Connection;

import static function.MyConstants.*;

public abstract class DAOFactory {

    public static DAOFactory getDAOFactory(int database) {
        switch (database) {
            case SQLITE:
                return new SqliteDAOFactory();
            case MYSQL:
            return new MySqlDAOFactory();
            case PGSQL:
                return new PgSqlDAOFactory();
            default:
                return null;
        }
    }

    public abstract Connection createConection();
}

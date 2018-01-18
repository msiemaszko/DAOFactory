package factoryDAO;

import java.sql.Connection;

public class PgSqlDAOFactory extends DAOFactory {

    @Override
    public Connection createConection() {
        System.out.println("PgSqlDAOFactory -> createConection()");
        return null;
    }
}

package factoryDAO;

import java.sql.Connection;

public class MySqlDAOFactory extends DAOFactory {

    @Override
    public Connection createConection() {
        System.out.println("MySqlDAOFactory -> createConection()");
        return null;
    }
}

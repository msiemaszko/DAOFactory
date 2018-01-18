package factoryDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqliteDAOFactory extends DAOFactory {

    //private static final Logger logger = Logger            .getLogger(MySqlDAOFactory.class);

    public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DBURL = "jdbc:sqlite:dbase.db";

    @Override
    public Connection createConection(){
        System.out.println("SqliteDAOFactory -> createConection()");
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(DBURL);
        } catch (SQLException e) {
//            logger.error(e.getMessage());
        } catch (ClassNotFoundException e) {
//            logger.error(e.getMessage());
        }
        return conn;
    }

    /*@Override
	public IntfceTaskDAO getKlientDAO() {
		return new SqliteTaskDAO();
//        return null;
	}*/

}

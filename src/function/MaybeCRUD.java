package function;

import factoryDAO.DAOFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static function.MyConstants.INT;


public class MaybeCRUD {
    private int database;
    private Connection conn = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet result = null;

    public MaybeCRUD(int database){
        this.database = database;
    }

    public ResultSet getResult() {
        try {
            this.result = preparedStatement.getResultSet();
        } catch (SQLException e) {
            System.err.println("getResult: SQLException: " + e.getMessage());
        }
        return this.result;
    }

    public void query(String kodSql, Object[][] stmtObject) {
        try {
            DAOFactory dao = DAOFactory.getDAOFactory(this.database);
            // this.conn = SqliteDAOFactory.createConnection();
            this.conn = dao.createConection();
            this.preparedStatement = conn.prepareStatement(kodSql);

            for (int i = 0; i < stmtObject.length; i++) {
                if (stmtObject[i][0].equals(INT)) {
                    // System.out.println("setInt(" + (i + 1) + ", " + stmtObject[i][1] + ")");
                    this.preparedStatement.setInt((i+1), (int) stmtObject[i][1]);
                } else {
                    this.preparedStatement.setString((i+1), (String) stmtObject[i][1]);
                    // System.out.println("setStr(" + (i + 1) + ", " + stmtObject[i][1] + ")");
                }
            }
            this.preparedStatement.execute();

        } catch (SQLException e) {
            //logger.error(e.getMessage());
            System.err.println( "SQLException: " + e.getMessage());
        }
    }

    public void close() {
        try {
            // close result -> if exists
            if (this.result != null) this.result.close();
        } catch (Exception rse) {
            // logger.error(rse.getMessage());
            rse.printStackTrace();
        }

        try {
            // close statment
            preparedStatement.close();
        } catch (Exception sse) {
            //logger.error(sse.getMessage());
            System.err.println(sse.getMessage());
        }

        try {
            // close connection
            conn.close();
        } catch (Exception cse) {
            // logger.error(cse.getMessage());
            System.err.println(cse.getMessage());
        }
    }
}
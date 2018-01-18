import function.MaybeCRUD;

import java.sql.ResultSet;
import java.sql.SQLException;

import static function.MyConstants.*;

public class Run {

    public static void main(String[] args) {

        String kodSql;
        Object[][] stmtObject;
        MaybeCRUD crud;

        // 1 Select
        kodSql = "SELECT * FROM m_exec WHERE ip=?";
        stmtObject = new Object[][]{
                {STR, "Marek"}
        };

        crud = new MaybeCRUD(SQLITE);
        crud.query(kodSql, stmtObject);
        ResultSet crudResult = crud.getResult();

        if (crudResult != null){
            try {
                while (crudResult.next()) {
                    System.out.println(
                            crudResult.getString(1) + " " +
                                    crudResult.getString(2) + " " +
                                    crudResult.getString(3));
                }
            } catch (SQLException e) {
                System.err.println("SQLException while reading Result: " + e.getMessage());
            }
        }
        crud.close();


        // 2 Insert
        kodSql = "INSERT INTO m_exec (task_id, ip, status) VALUES(?,?,?)";
        stmtObject = new Object[][]{
                {INT, 4},
                {STR, "Janusz"},
                {STR, "Szeryf"}
        };
        crud = new MaybeCRUD(SQLITE);
        crud.query(kodSql, stmtObject);
        crud.close();
    }
}

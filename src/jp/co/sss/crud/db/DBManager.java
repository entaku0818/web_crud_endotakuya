

package jp.co.sss.crud.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;









/**
 *
 * @author endo
 *
 */
public class DBManager {





	/**
	 *DBと接続する
	 * @return conn
	 */
    public Connection getConn()  {

        // JDBCドライバクラスをJVMに登録
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // DBへ接続
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:XE",
                    "web_crud_user", "systemsss");
        } catch (SQLException e) {
        	//DataBaseへ接続できない場合
            e.printStackTrace();
            e.getMessage();
        }
        return conn;
    }

    /**
     * DB接続を切断する
     *
     * @param conn
     * DBコネクション
     * @throws SQLException
     */
    public void close(Connection conn) throws SQLException {

                conn.close();

    }













}


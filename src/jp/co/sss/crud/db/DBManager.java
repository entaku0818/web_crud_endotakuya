

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
     * DBと接続する
     *
     * @return DBコネクション
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Connection getConn()  {

        // JDBCドライバクラスをJVMに登録
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
        // DBへ接続
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:XE",
                    "web_crud_user", "systemsss");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * DB接続を切断する
     *
     * @param conn
     * DBコネクション
     */
    public void close(Connection conn) {

        try {

            // 切断処理
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }













}




package jp.co.sss.crud.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jp.co.sss.crud.util.SysDataImport;









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

    	SysDataImport sysDataImport = new SysDataImport();


        // JDBCドライバクラスをJVMに登録
    	try {
            Class.forName( sysDataImport.confImport().getDatabaseDriver() );
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // DBへ接続
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(
            		sysDataImport.confImport().getDatabaseConnect(),
            		sysDataImport.confImport().getDatabaseUser(), sysDataImport.confImport().getDatabasePassword());
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


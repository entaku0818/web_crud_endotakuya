package jp.co.sss.crud.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.entity.Employee;

public class DBAccess {





	 /**
		 * 検索SQLを発行して、結果をオブジェクトのListに入れて返す。
		 * ResultSetからListへの変換は、ResultSetBeanMappingが行う
		 */
	    public <T> List<T> select(String sql, ResultSetBeanMapping<T> mapping) {

		    List<T> list = new ArrayList<T>();
	    	Connection conn = null;
	    	PreparedStatement ps = null;
	    	ResultSet rs = null;
	    	DBManager manager = new DBManager();

		    try{

				conn = manager.getConn();
	            ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();

				while(rs.next()) {

				    T bean = mapping.createFromResultSet(rs);

				    list.add(bean);
				}



		    } catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}finally{

	            if (conn != null) {
	                try {conn.close();} catch (SQLException igonre) {}
	            }
		    }


			return list;

	    }

	    /**
	     *
	     * @param sql
	     * @param mapping
	     * @param whereValue
	     * @return
	     * @throws SQLException
	     */
		public <T> List<T> select(String sql,
				ResultSetBeanMapping<T> mapping, int whereValue) {

			List<T> list = new ArrayList<T>();
	    	Connection conn = null;
	    	PreparedStatement ps = null;
	    	ResultSet rs = null;
	    	DBManager manager = new DBManager();

		    try{

				conn = manager.getConn();
	            ps = conn.prepareStatement(sql);
	            ps.setInt(1, whereValue);

				rs = ps.executeQuery();

				while(rs.next()) {

				    T bean = mapping.createFromResultSet(rs);

				    list.add(bean);
				}



		    } catch (SQLException e) {
				e.printStackTrace();
			}finally{

	            if (conn != null) {
	                try {conn.close();} catch (SQLException igonre) {}
	            }
		    }
		    return list;
		}

		/**
		 *
		 * @param sql
		 * @param mapping
		 * @param whereValue
		 * @return
		 * @throws SQLException
		 */
		public <T> List<T> select(String sql, ResultSetBeanMapping<T> mapping, String whereValue) {

			List<T> list = new ArrayList<T>();
	    	Connection conn = null;
	    	PreparedStatement ps = null;
	    	ResultSet rs = null;
	    	DBManager manager = new DBManager();

		    try{

				conn = manager.getConn();
	            ps = conn.prepareStatement(sql);
	            ps.setString(1, whereValue);

				rs = ps.executeQuery();

				while(rs.next()) {

				    T bean = mapping.createFromResultSet(rs);

				    list.add(bean);
				}



		    } catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}finally{

	            if (conn != null) {
	                try {conn.close();} catch (SQLException igonre) {}
	            }
		    }
			return list;
		}



		/**
		 *
		 * @param sql
		 * @param empEntity
		 * @param sqlMap
		 * @param sqlMap
		 * @return
		 */

		public int update(String sql, Employee empEntity) {

	    	Connection conn = null;
	    	PreparedStatement ps = null;
		    int sqlCount = 0;
	    	DBManager manager = new DBManager();

			try{

				conn = manager.getConn();
	            ps = conn.prepareStatement(sql);


	        	ps.setString(1, empEntity.getEmpPass());
	            ps.setString(2, empEntity.getEmpName());
	            ps.setInt(3, empEntity.getGender());
	            ps.setString(4, empEntity.getAddress());
	            //Date@java→Date@SQLへ変換する
	            DateFormat dateFormat = new DateFormat();
	            ps.setDate(5, dateFormat.chgDateToSql( ( empEntity.getBirthday() ) ) );
	            ps.setInt(6, empEntity.getAuthority());
	            ps.setInt(7, empEntity.getDeptId());

	            sqlCount = ps.executeUpdate();









		    } catch (SQLException e) {
				e.printStackTrace();
			}finally{

	            if (conn != null) {
	                try {conn.close();} catch (SQLException igonre) {}
	            }
		    }


			return sqlCount;
		}

		/**
		 *
		 * @param sql
		 * @param empId
		 * @return
		 */
		public int delete(String sql, Employee empEntity) {
			// TODO 自動生成されたメソッド・スタブ
			Connection conn = null;
	    	PreparedStatement ps = null;
		    int sqlCount = 0;
	    	DBManager manager = new DBManager();

			try{

				conn = manager.getConn();
	            ps = conn.prepareStatement(sql);


	        	ps.setInt(1, empEntity.getEmpId());


	            sqlCount = ps.executeUpdate();


		    } catch (SQLException e) {
				e.printStackTrace();
			}finally{

	            if (conn != null) {
	                try {conn.close();} catch (SQLException igonre) {}
	            }
		    }


			return sqlCount;
		}


}

package jp.co.sss.crud.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.entity.Employee;
import jp.co.sss.crud.util.DateFormat;

public class DBAccess {





	 /**
	  * 全件検索用SQL実行メソッド
	  * @param sql
	  * @param mapping
	  * @return
	  */
	    public <T> List<T> select(String sql, ResultSetBeanMapping<T> mapping) {

		    List<T> list = new ArrayList<T>();
	    	Connection conn = null;
	    	PreparedStatement ps = null;
	    	ResultSet rs = null;
	    	DBManager manager = new DBManager();

		    try{

				conn = manager.getConn();

				 if (conn == null){

				 }
	            ps = conn.prepareStatement(sql);
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
	     * 条件検索(int)用SQL実行メソッド
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
				if( conn != null){
		            ps = conn.prepareStatement(sql);
		            ps.setInt(1, whereValue);

					rs = ps.executeQuery();

					while(rs.next()) {

					    T bean = mapping.createFromResultSet(rs);

					    list.add(bean);
					}
				}else if(conn == null){

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
		 *　条件検索(String)用SQL実行メソッド
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
				e.printStackTrace();
			}finally{

		        if (conn != null) {
		            try {conn.close();} catch (SQLException igonre) {}
		        }
		    }
			return list;
		}

		/**
		 *　全件検索用SQLページング処理実行メソッド
		 * @param sql
		 * @param mapping
		 * @param stertCount ページ番号
		 * @param endCount 1ページあたりの件数
		 * @return
		 */
		public <T> List<T> select(String sql, ResultSetBeanMapping<T> mapping, int stertCount,
				int endCount) {

				List<T> list = new ArrayList<T>();
		    	Connection conn = null;
		    	PreparedStatement ps = null;
		    	ResultSet rs = null;
		    	DBManager manager = new DBManager();

			    try{

					conn = manager.getConn();
		            ps = conn.prepareStatement(sql);
		            ps.setInt(1, stertCount);
		            ps.setInt(2, endCount);

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
		 * 条件検索(int)用SQLページング処理実行メソッド
		 * @param sql
		 * @param mapping
		 * @param whereValue
		 * @param stertCount
		 * @param endCount
		 * @return
		 */
		public <T> List<T> select(String sql,
				ResultSetBeanMapping<T> mapping, int whereValue, int stertCount,
				int endCount) {

			List<T> list = new ArrayList<T>();
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			DBManager manager = new DBManager();

		    try{

				conn = manager.getConn();

		            ps = conn.prepareStatement(sql);
		            ps.setInt(1, whereValue);
		            ps.setInt(2, stertCount);
		            ps.setInt(3, endCount);


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
		 * 条件検索(String)用SQLページング処理実行メソッド
		 * @param sql
		 * @param mapping
		 * @param whereValue
		 * @param stertCount
		 * @param endCount
		 * @return
		 */
		public <T> List<T> select(String sql, ResultSetBeanMapping<T> mapping, String whereValue, int stertCount,
				int endCount) {

			List<T> list = new ArrayList<T>();
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			DBManager manager = new DBManager();

		    try{

				conn = manager.getConn();
		        ps = conn.prepareStatement(sql);
		        ps.setString(1, whereValue);
	            ps.setInt(2, stertCount);
	            ps.setInt(3, endCount);


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
		 *　受け取ったEmployeeのデータを追加する
		 * @param sql
		 * @param empEntity
		 * @return　追加件数
		 */
		public int insert(String sql, Employee empEntity) {

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
	            ps.setString(5, dateFormat.chgDateToSql( empEntity.getBirthday() ) );
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
		 *　受け取ったEmployeeのデータを更新する
		 * @param sql
		 * @param empEntity
		 * @return　更新件数
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
	            ps.setString(5, dateFormat.chgDateToSql(empEntity.getBirthday()) );
	            ps.setInt(6, empEntity.getAuthority());
	            ps.setInt(7, empEntity.getDeptId());
	            ps.setInt(8, empEntity.getEmpId());

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
		 *　受け取ったempIdのデータを削除する
		 * @param sql
		 * @param empId
		 * @return　削除件数
		 */
		public int delete(String sql, int empId) {
			Connection conn = null;
	    	PreparedStatement ps = null;
		    int sqlCount = 0;
	    	DBManager manager = new DBManager();

			try{

				conn = manager.getConn();
	            ps = conn.prepareStatement(sql);


	        	ps.setInt(1, empId);


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

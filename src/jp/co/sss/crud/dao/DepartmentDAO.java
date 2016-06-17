package jp.co.sss.crud.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import jp.co.sss.crud.db.DBAccess;
import jp.co.sss.crud.db.ResultSetBeanMapping;
import jp.co.sss.crud.entity.Department;




public class DepartmentDAO {

	/**
	 * ResultSetの一行をEmployeeのインスタンスに変換するクラス
	 * ここでしか利用されないので、
	 * 無名クラスとして、この場所でインスタンス化します。
	 */
    private ResultSetBeanMapping<Department> allMapping = new ResultSetBeanMapping<Department>(){

        public Department createFromResultSet(ResultSet rs)
        	throws SQLException {

        	Department dept = new Department();
        	dept.setDeptId(rs.getInt("dept_id"));
        	dept.setDeptName(rs.getString("dept_name"));

    		return dept;
        }

    };




    /**
     * 全件検索を行います。
     * 戻り値はDepartmentオブジェクトのListです。
     */
	public List<Department> findAll() {

		String sql = "select * from department order by dept_id ASC";

		DBAccess access = new DBAccess();
		List<Department> deptData = null;

		deptData = access.select(sql, allMapping);
		return deptData;
	}

	/**
	 *
	 * @param empId
	 * @return empData DepartmentテーブルのEntity
	 */
	public Department findById(int deptId) {
		String sql = "select * from Department where dept_id = ? AND rownum = 1";

		DBAccess access = new DBAccess();
		Department deptData = null;

		deptData = access.select(sql, allMapping, deptId).get(0);
		return deptData;
	}



	//動作確認用main
	public static void main(String[] args) throws Exception{
		DepartmentDAO dao = new DepartmentDAO();
	    List<Department> list = dao.findAll();
	    for(int i=0; i<list.size(); i++){
	    	Department dept = list.get(i);
	        System.out.println(dept.getDeptId());
	        System.out.println(dept.getDeptName());
	    }
	}



}

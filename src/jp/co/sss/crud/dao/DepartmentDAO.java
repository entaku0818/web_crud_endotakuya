package jp.co.sss.crud.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import jp.co.sss.crud.db.DBAccess;
import jp.co.sss.crud.db.ResultSetBeanMapping;
import jp.co.sss.crud.entity.Department;
import jp.co.sss.crud.util.SysDataImport;




public class DepartmentDAO {

	/**
	 * ResultSetの一行をEmployeeのインスタンスに変換するクラス、
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
    *
    * @return Departmentテーブルのリストオブジェクト
    */
	public List<Department> findAll() {

		SysDataImport sysDataImport = new SysDataImport();


		String sql = sysDataImport.confImport().getDeptFindAll();

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

		SysDataImport sysDataImport = new SysDataImport();
		String sql =  sysDataImport.confImport().getDeptFindById();

		DBAccess access = new DBAccess();
		Department deptData = null;

		deptData = access.select(sql, allMapping, deptId).get(0);
		return deptData;
	}







}

package jp.co.sss.crud.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.db.DBAccess;
import jp.co.sss.crud.db.ResultSetBeanMapping;
import jp.co.sss.crud.entity.Employee;
import jp.co.sss.crud.util.SysDataImport;




public class EmployeeDAO {

	/**
	 * ResultSetの一行をEmployeeのインスタンスに変換するクラス
	 * ここでしか利用されないので、
	 * 無名クラスとして、この場所でインスタンス化します。
	 */
    private ResultSetBeanMapping<Employee> allMapping = new ResultSetBeanMapping<Employee>(){

        public Employee createFromResultSet(ResultSet rs)
        	throws SQLException {

        	Employee emp = new Employee();
        	emp.setEmpId(rs.getInt("emp_id"));
        	emp.setEmpPass(rs.getString("emp_pass"));
        	emp.setEmpName(rs.getString("emp_name"));
        	emp.setGender(rs.getInt("gender"));
        	emp.setAddress(rs.getString("address"));
        	emp.setBirthday(rs.getDate("birthday"));
        	emp.setAuthority(rs.getInt("authority"));
        	emp.setDeptId(rs.getInt("dept_id"));
    		return emp;
        }

    };


    /**
     * このクラスのインスタンスを取得します。
     */
    public static EmployeeDAO getInstance(){
        return new EmployeeDAO();
    }



    /**
	*
	*
	* @return employeeテーブルの全件取得
	*/
	public List<Employee> findAll() {
		SysDataImport sysDataImport = new SysDataImport();

		String sql = sysDataImport.confImport().getEmpFindAll();

		DBAccess access = new DBAccess();
		List<Employee> empData = new ArrayList<Employee>();


			empData = access.select(sql, allMapping);

		return empData;
	}



	/**
	 *
	 * @param empId
	 * @return empData EmployeeテーブルのempId検索結果
	 */
	public List<Employee> findAllById(int empId) {
		SysDataImport sysDataImport = new SysDataImport();

		String sql = sysDataImport.confImport().getEmpFindAllById();


		DBAccess access = new DBAccess();
		List<Employee> empData = new ArrayList<Employee>();


			empData = access.select(sql, allMapping, empId);

		return empData;
	}



	/**
	 *
	 * @param empName
	 * @return　empData EmployeeテーブルのempName検索結果
	 */
	public List<Employee> findAllByName(String empName) {


		SysDataImport sysDataImport = new SysDataImport();
		String sql = sysDataImport.confImport().getEmpFindAllByName();

		DBAccess access = new DBAccess();
		List<Employee> empData = new ArrayList<Employee>();

		// sql にワイルドカードを適用できないため、bindする値をワイルドカードで囲む
		String likeEmpName = "%" + empName + "%";

		//empNameの文字列長が1以上であれば、
		if(empName.length() > 0){
			empData = access.select(sql, allMapping, likeEmpName);
		}


		return empData;
	}



	/**
	 *
	 * @param deptId
	 * @return EmployeeテーブルのdeptId検索結果
	 */
	public List<Employee> findAllByDeptId(int deptId) {
		SysDataImport sysDataImport = new SysDataImport();
		String sql = sysDataImport.confImport().getEmpFindAllByDeptId();

		DBAccess access = new DBAccess();
		List<Employee> empData = new ArrayList<Employee>();


			empData = access.select(sql, allMapping, deptId);

		return empData;
	}



	/**
	 *
	 * @param stertCount　取得開始位置
	 * @param endCount 取得終了位置
	 * @return empData　employeeテーブルの全件ページング対処
	 */
	public List<Employee> findAll(int stertCount, int endCount ) {

		SysDataImport sysDataImport = new SysDataImport();
		String sql = sysDataImport.confImport().getEmpFindAll() + sysDataImport.confImport().getPagingSQL();

		DBAccess access = new DBAccess();
		List<Employee> empData = new ArrayList<Employee>();


			empData = access.select(sql, allMapping, stertCount, endCount);

		return empData;
	}



	/**
	 *
	 * @param empId
	 * @return empData employeeテーブルの全件ページング対処
	 */
	public List<Employee> findAllById(int empId, int stertCount, int endCount) {
		SysDataImport sysDataImport = new SysDataImport();
		String sql = sysDataImport.confImport().getEmpFindAllById() + sysDataImport.confImport().getPagingSQL();

		DBAccess access = new DBAccess();
		List<Employee> empData = new ArrayList<Employee>();


			empData = access.select(sql, allMapping, empId, stertCount ,endCount);

		return empData;
	}


	/**
	 *
	 * @param empName
	 * @return　empData EmployeeテーブルのempName検索結果に対するページング対処
	 */
	public List<Employee> findAllByName(String empName, int startCount,int endCount) {
		SysDataImport sysDataImport = new SysDataImport();
		String sql = sysDataImport.confImport().getEmpFindAllByName() + sysDataImport.confImport().getPagingSQL();

		DBAccess access = new DBAccess();
		List<Employee> empData = new ArrayList<Employee>();

		// sql にワイルドカードを適用できないため、bindする値をワイルドカードで囲む
		String likeEmpName = "%" + empName + "%";

		//empNameの文字列長が1以上であれば、
		if(empName.length() > 0){
			empData = access.select(sql, allMapping, likeEmpName, startCount, endCount );
		}


		return empData;
	}


	/**
	 *
	 * @param empName
	 * @return　empData EmployeeテーブルのdeptId検索結果に対するページング対処
	 */
	public List<Employee> findAllByDeptId(int deptId, int startCount,
			int endCount) {
		SysDataImport sysDataImport = new SysDataImport();
		String sql = sysDataImport.confImport().getEmpFindAllByDeptId() + sysDataImport.confImport().getPagingSQL();

		DBAccess access = new DBAccess();
		List<Employee> empData = new ArrayList<Employee>();



		empData = access.select(sql , allMapping, deptId, startCount, endCount );



		return empData;
	}



	/**
	 *
	 * @param empId
	 * @return empData EmployeeテーブルのEntityの一行
	 */
	public Employee findById(int empId) {
		SysDataImport sysDataImport = new SysDataImport();
		String sql = sysDataImport.confImport().getEmpFindById();

		DBAccess access = new DBAccess();
		List<Employee> empDataList = access.select(sql, allMapping, empId);
		Employee empData = new Employee();

		//
		if(empDataList.size()==1){
			empData = access.select(sql, allMapping, empId).get(0);
		}


		return empData;
	}



	/**
	 *
	 * @param empEntity
	 * @return 挿入完了件数
	 */
	public int insert(Employee empEntity) {
		SysDataImport sysDataImport = new SysDataImport();
		String sql = sysDataImport.confImport().getEmpInsert();

		DBAccess access = new DBAccess();
		int empCount = 0;



		empCount = access.insert(sql, empEntity);

		return empCount;
	}

	/**
	 *
	 * @param empEntity
	 * @return　更新完了件数
	 */
	public int update(Employee empEntity) {
		SysDataImport sysDataImport = new SysDataImport();
		String sql = sysDataImport.confImport().getEmpUpdate();

		DBAccess access = new DBAccess();
		int empCount = 0;



		empCount = access.update(sql, empEntity);

		return empCount;
	}




	/**
	 *
	 * @param empId
	 * @return　削除完了件数
	 */
	public int deleteById(int empId) {
		SysDataImport sysDataImport = new SysDataImport();
		String sql = sysDataImport.confImport().getEmpDelete();

		DBAccess access = new DBAccess();
		int empCount = 0;



		empCount = access.delete(sql, empId);

		return empCount;
	}











}

package jp.co.sss.crud.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.db.DBAccess;
import jp.co.sss.crud.db.ResultSetBeanMapping;
import jp.co.sss.crud.entity.Employee;




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
        					//getDateが何型？？
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
     * 全件検索を行います。
     * 戻り値はEmployeeオブジェクトのListです。
     */
	public List<Employee> findAll() {

		String sql = "select * from employee order by emp_id ASC";

		DBAccess access = new DBAccess();
		List<Employee> empData = new ArrayList<Employee>();


			empData = access.select(sql, allMapping);

		return empData;
	}


	/**
	 *
	 * @param empId
	 * @return empData EmployeeテーブルのEntityList
	 */
	public List<Employee> findAllById(int empId) {
		String sql = "select * from employee where emp_id = ? order by emp_id ASC";

		DBAccess access = new DBAccess();
		List<Employee> empData = new ArrayList<Employee>();


			empData = access.select(sql, allMapping, empId);

		return empData;
	}


	/**
	 *
	 * @param empName
	 * @return
	 */
	public List<Employee> findAllByName(String empName) {



		String sql = "select * from employee where emp_name like ?";

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
	 * @return
	 */
	public List<Employee> findAllByDeptId(int deptId) {
		String sql = "select * from employee where dept_id = ?";

		DBAccess access = new DBAccess();
		List<Employee> empData = new ArrayList<Employee>();


			empData = access.select(sql, allMapping, deptId);

		return empData;
	}


	/**
	 *
	 * @param empId
	 * @return empData EmployeeテーブルのEntityの一行
	 */
	public Employee findById(int empId) {
		String sql = "select * from employee where emp_id = ? order by emp_id ASC";

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
	 * @return
	 */
	public int insert(Employee empEntity) {
		String sql = "INSERT INTO employee (emp_id, emp_pass, emp_name, gender, address, birthday, authority, dept_id) " +
				"VALUES (SEQ_EMP.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";

		DBAccess access = new DBAccess();
		int empCount = 0;



		empCount = access.insert(sql, empEntity);

		return empCount;
	}

	/**
	 *
	 * @param empEntity
	 * @return
	 */
	public int update(Employee empEntity) {
		String sql = "UPDATE employee SET emp_pass = ?, emp_name = ?, gender = ?, address = ?, birthday = ?, authority = ?, dept_id = ? WHERE emp_id = ?";

		DBAccess access = new DBAccess();
		int empCount = 0;



		empCount = access.update(sql, empEntity);

		return empCount;
	}





	//動作確認用
	public static void main(String[] args) throws Exception{
		EmployeeDAO dao = new EmployeeDAO();
	    List<Employee> list = dao.findAll();
	    for(int i=0; i<list.size(); i++){
	    	Employee emp = list.get(i);
	        System.out.println(emp.getEmpId());
	    }
	}


	public int deleteById(int empId) {
		// TODO 自動生成されたメソッド・スタブ
		String sql = "DELETE FROM employee WHERE emp_id = ?";

		DBAccess access = new DBAccess();
		int empCount = 0;



		empCount = access.delete(sql, empId);

		return empCount;
	}








}

package jp.co.sss.crud.form;



import org.apache.struts.action.ActionForm;

/**
 *
 * @author Edu
 *
 */
public class ChangeForm extends ActionForm {

	private static final long serialVersionUID = 1L;


	private int empId;
	/**
     * empPass パスワード
     */
    private String empPass;
    /**
     *  empName 社員名
     */
    private String empName;
    /**
     * gender 1:男　2:女
     */
    private int gender;
    /**
     * address 住所
     */
    private String address;
    /**
     * birthday 生年月日
     */
    private String birthday;
    /**
     * authority 権限
     */
    private int authority;
    /**
     * deptId　部署ID
     */
    private int deptId;




	/**
	 * @return empId
	 */
	public int getEmpId() {
		return empId;
	}
	/**
	 * @param empId セットする empId
	 */
	public void setEmpId(int empId) {
		this.empId = empId;
	}
    /**
	 * @return empPass
	 */
	public String getEmpPass() {
		return empPass;
	}
	/**
	 * @param empPass セットする empPass
	 */
	public void setEmpPass(String empPass) {
		this.empPass = empPass;
	}
	/**
	 * @return empName
	 */
	public String getEmpName() {
		return empName;
	}
	/**
	 * @param empName セットする empName
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	/**
	 * @return gender
	 */
	public int getGender() {
		return gender;
	}
	/**
	 * @param gender セットする gender
	 */
	public void setGender(int gender) {
		this.gender = gender;
	}
	/**
	 * @return address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address セットする address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return birthday
	 */
	public String getBirthday() {
		return birthday;
	}
	/**
	 * @param birthday セットする birthday
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	/**
	 * @return authority
	 */
	public int getAuthority() {
		return authority;
	}
	/**
	 * @param authority セットする authority
	 */
	public void setAuthority(int authority) {
		this.authority = authority;
	}
	/**
	 * @return deptId
	 */
	public int getDeptId() {
		return deptId;
	}
	/**
	 * @param deptId セットする deptId
	 */
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	/**
	 * @return userEmpDto
	 */







}
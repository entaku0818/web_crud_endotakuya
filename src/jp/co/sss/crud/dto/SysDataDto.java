package jp.co.sss.crud.dto;



/**
 * SYSTEMデータ格納用のDTO
 * @author Edu
 *
 */
public class SysDataDto {

    private String errorMessage;

    /**
     * Database接続定数
     */
    private String databaseConnect;
	private String databaseUser;
    private String databasePassword;
    private String databaseDriver;

    /**
     * SQL定数
     */
    private String deptFindAll;
    private String deptFindById;
    private String empFindAll;
    private String empFindAllById;
    private String empFindAllByName;
    private String empFindAllByDeptId;
    private String pagingSQL;
    private String empFindById;
    private String empInsert;
    private String empUpdate;
    private String empDelete;

    /**
	 * @return empFindAll
	 */
	public String getEmpFindAll() {
		return empFindAll;
	}

	/**
	 * @param empFindAll セットする empFindAll
	 */
	public void setEmpFindAll(String empFindAll) {
		this.empFindAll = empFindAll;
	}

	/**
	 * @return empFindAllById
	 */
	public String getEmpFindAllById() {
		return empFindAllById;
	}

	/**
	 * @param empFindAllById セットする empFindAllById
	 */
	public void setEmpFindAllById(String empFindAllById) {
		this.empFindAllById = empFindAllById;
	}

	/**
	 * @return empFindAllByName
	 */
	public String getEmpFindAllByName() {
		return empFindAllByName;
	}

	/**
	 * @param empFindAllByName セットする empFindAllByName
	 */
	public void setEmpFindAllByName(String empFindAllByName) {
		this.empFindAllByName = empFindAllByName;
	}

	/**
	 * @return empFindAllByDeptId
	 */
	public String getEmpFindAllByDeptId() {
		return empFindAllByDeptId;
	}

	/**
	 * @param empFindAllByDeptId セットする empFindAllByDeptId
	 */
	public void setEmpFindAllByDeptId(String empFindAllByDeptId) {
		this.empFindAllByDeptId = empFindAllByDeptId;
	}

	/**
	 * @return pagingSQL
	 */
	public String getPagingSQL() {
		return pagingSQL;
	}

	/**
	 * @param pagingSQL セットする pagingSQL
	 */
	public void setPagingSQL(String pagingSQL) {
		this.pagingSQL = pagingSQL;
	}

	/**
	 * @return empFindById
	 */
	public String getEmpFindById() {
		return empFindById;
	}

	/**
	 * @param empFindById セットする empFindById
	 */
	public void setEmpFindById(String empFindById) {
		this.empFindById = empFindById;
	}

	/**
	 * @return empInsert
	 */
	public String getEmpInsert() {
		return empInsert;
	}

	/**
	 * @param empInsert セットする empInsert
	 */
	public void setEmpInsert(String empInsert) {
		this.empInsert = empInsert;
	}

	/**
	 * @return empUpdate
	 */
	public String getEmpUpdate() {
		return empUpdate;
	}

	/**
	 * @param empUpdate セットする empUpdate
	 */
	public void setEmpUpdate(String empUpdate) {
		this.empUpdate = empUpdate;
	}

	/**
	 * @return empDelete
	 */
	public String getEmpDelete() {
		return empDelete;
	}

	/**
	 * @param empDelete セットする empDelete
	 */
	public void setEmpDelete(String empDelete) {
		this.empDelete = empDelete;
	}

	/**
	 * @return databaseUser
	 */
	public String getDatabaseUser() {
		return databaseUser;
	}

	/**
	 * @param databaseUser セットする databaseUser
	 */
	public void setDatabaseUser(String databaseUser) {
		this.databaseUser = databaseUser;
	}

	/**
	 * @return databasePassword
	 */
	public String getDatabasePassword() {
		return databasePassword;
	}

	/**
	 * @param databasePassword セットする databasePassword
	 */
	public void setDatabasePassword(String databasePassword) {
		this.databasePassword = databasePassword;
	}

	/**
	 * @return databaseDriver
	 */
	public String getDatabaseDriver() {
		return databaseDriver;
	}

	/**
	 * @param databaseDriver セットする databaseDriver
	 */
	public void setDatabaseDriver(String databaseDriver) {
		this.databaseDriver = databaseDriver;
	}




	/**
	 * @return errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage セットする errorMessage
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * @return databaseConnect
	 */
	public String getDatabaseConnect() {
		return databaseConnect;
	}

	/**
	 * @param databaseConnect セットする databaseConnect
	 */
	public void setDatabaseConnect(String databaseConnect) {
		this.databaseConnect = databaseConnect;
	}

	/**
	 * @return deptFindAll
	 */
	public String getDeptFindAll() {
		return deptFindAll;
	}

	/**
	 * @param deptFindAll セットする deptFindAll
	 */
	public void setDeptFindAll(String deptFindAll) {
		this.deptFindAll = deptFindAll;
	}

	/**
	 * @return deptFindById
	 */
	public String getDeptFindById() {
		return deptFindById;
	}

	/**
	 * @param deptFindById セットする deptFindById
	 */
	public void setDeptFindById(String deptFindById) {
		this.deptFindById = deptFindById;
	}

}

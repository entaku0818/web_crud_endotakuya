package jp.co.sss.crud.entity;

/**
 * Departmentテーブル用のEntityクラス
 * @author Edu
 *
 */
public class Department {

	    /**
	     * deptId　部署ID
	     */
	    private int deptId;
	    /**
	     * deptName　部署名
	     */
	    private String deptName;


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
		 * @return deptName
		 */
		public String getDeptName() {
			return deptName;
		}
		/**
		 * @param deptName セットする deptName
		 */
		public void setDeptName(String deptName) {
			this.deptName = deptName;
		}





}

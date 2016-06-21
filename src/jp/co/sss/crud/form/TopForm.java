package jp.co.sss.crud.form;

import org.apache.struts.action.ActionForm;

/**
 *
 * @author Edu
 *
 */
public class TopForm extends ActionForm {

	private static final long serialVersionUID = 1L;





	private String findColumn = null;
    private int findId = 0;
    private String findName = null;
    private int findDeptId = 0;





	/**
	 * @return findId
	 */
	public int getFindId() {
		return findId;
	}
	/**
	 * @param findId セットする findId
	 */
	public void setFindId(int findId) {
		this.findId = findId;
	}
	/**
	 * @return findName
	 */
	public String getFindName() {
		return findName;
	}
	/**
	 * @param findName セットする findName
	 */
	public void setFindName(String findName) {
		this.findName = findName;
	}
	/**
	 * @return findColumn
	 */
	public String getFindColumn() {
		return findColumn;
	}
	/**
	 * @param findColumn セットする findColumn
	 */
	public void setFindColumn(String findColumn) {
		this.findColumn = findColumn;
	}
	/**
	 * @return findDeptId
	 */
	public int getFindDeptId() {
		return findDeptId;
	}
	/**
	 * @param findDeptId セットする findDeptId
	 */
	public void setFindDeptId(int findDeptId) {
		this.findDeptId = findDeptId;
	}






}
package jp.co.sss.crud.form;

import org.apache.struts.action.ActionForm;

/**
 * TOPページ用のフォーム
 * @author Edu
 *
 */
public class TopForm extends ActionForm {

	private static final long serialVersionUID = 1L;




	/**
	 * 検索条件
	 */
	private String findColumn = null;
	/**
	 * 検索用empId
	 */
    private int findId = 0;
	/**
	 * 検索用empName
	 */
    private String findName = null;
	/**
	 * 検索用deptId
	 */
    private int findDeptId = 0;
    /**
     * ページ番号
     */
    private int pageNo = 0;





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
	/**
	 * @return pageNo
	 */
	public int getPageNo() {
		return pageNo;
	}
	/**
	 * @param pageNo セットする pageNo
	 */
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}







}
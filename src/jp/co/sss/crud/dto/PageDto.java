package jp.co.sss.crud.dto;


/**
 * ページング処理情報格納用DTO
 * @author Edu
 *
 */
public class PageDto {


	 private boolean hasPrev;
	private boolean hasNext;
	private UserEmpDto[] userEmpDto;
	/**
	 * 現在のページナンバー
	 */
	private int pageNo;

	 /**
	 * @return hasPrev
	 */
	public boolean isHasPrev() {
		return hasPrev;
	}
	/**
	 * @param hasPrev セットする hasPrev
	 */
	public void setHasPrev(boolean hasPrev) {
		this.hasPrev = hasPrev;
	}
	/**
	 * @return hasNext
	 */
	public boolean isHasNext() {
		return hasNext;
	}
	/**
	 * @param hasNext セットする hasNext
	 */
	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
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
	/**
	 * @return userEmpDto
	 */
	public UserEmpDto[] getUserEmpDto() {
		return userEmpDto;
	}
	/**
	 * @param userEmpDto セットする userEmpDto
	 */
	public void setUserEmpDto(UserEmpDto[] userEmpDto) {
		this.userEmpDto = userEmpDto;
	}


}

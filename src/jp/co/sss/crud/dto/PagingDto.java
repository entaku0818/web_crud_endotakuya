package jp.co.sss.crud.dto;

public class PagingDto {
    /**
     * 1ページあたりの件数
     */
    private int countOfPage;
    /**
     * 現在ページ
     */
    private int thisPage;
    /**
     * 総ページ数
     */
    private int allPage;

    /**
     * 前のページの存在確認
     */
    private boolean prefPageFlag;
    /**
     * 次のページの存在確認
     */
    private boolean NextPageFlag;


	/**
	 * @return countOfPage
	 */
	public int getCountOfPage() {
		return countOfPage;
	}
	/**
	 * @param countOfPage セットする countOfPage
	 */
	public void setCountOfPage(int countOfPage) {
		this.countOfPage = countOfPage;
	}
	/**
	 * @return thisPage
	 */
	public int getThisPage() {
		return thisPage;
	}
	/**
	 * @param thisPage セットする thisPage
	 */
	public void setThisPage(int thisPage) {
		this.thisPage = thisPage;
	}
	/**
	 * @return allPage
	 */
	public int getAllPage() {
		return allPage;
	}
	/**
	 * @param allPage セットする allPage
	 */
	public void setAllPage(int allPage) {
		this.allPage = allPage;
	}
	/**
	 * @return prefPageFlag
	 */
	public boolean isPrefPageFlag() {
		return prefPageFlag;
	}
	/**
	 * @param prefPageFlag セットする prefPageFlag
	 */
	public void setPrefPageFlag(boolean prefPageFlag) {
		this.prefPageFlag = prefPageFlag;
	}
	/**
	 * @return nextPageFlag
	 */
	public boolean isNextPageFlag() {
		return NextPageFlag;
	}
	/**
	 * @param nextPageFlag セットする nextPageFlag
	 */
	public void setNextPageFlag(boolean nextPageFlag) {
		NextPageFlag = nextPageFlag;
	}
}

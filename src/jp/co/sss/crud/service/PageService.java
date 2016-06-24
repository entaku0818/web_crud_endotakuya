package jp.co.sss.crud.service;



import jp.co.sss.crud.dto.PagingDto;
import jp.co.sss.crud.dto.UserEmpDto;

public class PageService {

	/**
	 *
	 * @param userEmpDto　データ
	 * @param countOfPage　1件あたりのページ
	 * @param 指定されたページ
	 * @return
	 */
	public PagingDto getPagingInfo(UserEmpDto[] userEmpDto,int countOfPage,int selectOfPage) {

		int allPage = userEmpDto.length / countOfPage;


		PagingDto pagingDto = new PagingDto();
			pagingDto.setAllPage(allPage);

			   if(selectOfPage != 0){
				   pagingDto.setPrefPageFlag(true);
			   }
			   if((selectOfPage + 1) * allPage < userEmpDto.length){
				   pagingDto.setNextPageFlag(true);
			   }



		return pagingDto;
	}

}

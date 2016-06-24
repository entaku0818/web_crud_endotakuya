package jp.co.sss.crud.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.crud.dto.PageDto;
import jp.co.sss.crud.dto.UserEmpDto;
import jp.co.sss.crud.form.TopForm;

import jp.co.sss.crud.service.DepartmentService;
import jp.co.sss.crud.service.EmployeeService;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;



/**
 *
 * @author Edu
 *
 */



public final class TopAction extends Action {



	/**
	 * 1ページあたりの件数
	 */
	public final int PAGE_COUNT = 10;

	public ActionForward execute(
        ActionMapping mapping,
        ActionForm form,
        HttpServletRequest request,
        HttpServletResponse response) {


    	EmployeeService empService = new EmployeeService();
    	DepartmentService deptService = new DepartmentService();




    	//部署情報の動的なselectボタンのデータの生成
    	UserEmpDto[] selectDeptDto = deptService.getUserEmpDto();

    	//現在見ているページ
    	int selectPage = 0;


    	if (request.getParameter("pageNo") != null){
    		//現在選択されているページを取得
    		selectPage = Integer.parseInt(request.getParameter("pageNo"));
    	}

    	//現在選択されているページのユーザー情報を取得
    	UserEmpDto[] userEmpDto = empService.getAllEmpData(selectPage, PAGE_COUNT);


		PageDto pageDto = new PageDto();

		pageDto.setPageNo(selectPage);

 	   if(selectPage != 0){
 		  pageDto.setHasPrev(true);
		  }
		if((selectPage + 1) * PAGE_COUNT <  empService.getCountAll() ){
		  pageDto.setHasNext(true);
		}



		//Httpセッションへ社員情報を格納する
        request.setAttribute("pageDto", pageDto);

    	//Httpセッションへ社員情報を格納する
        request.setAttribute("userEmpDto", userEmpDto);

        //Httpセッションへ部署情報を格納する
        request.setAttribute("selectDeptDto", selectDeptDto);

    	return mapping.findForward("success");
    }
}
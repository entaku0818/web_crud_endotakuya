package jp.co.sss.crud.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.sss.crud.dto.PageDto;
import jp.co.sss.crud.dto.UserEmpDto;

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
	private static final int PAGE_COUNT = 10;



	public PageDto pageDto = null;
	public UserEmpDto[] userEmpDto = null;

	public ActionForward execute(
        ActionMapping mapping,
        ActionForm form,
        HttpServletRequest request,
        HttpServletResponse response) {


    	EmployeeService empService = new EmployeeService();
    	DepartmentService deptService = new DepartmentService();


        Date date = new Date();
        System.out.println(date.toString());

    	//部署情報の動的なselectボタンのデータの生成
    	UserEmpDto[] selectDeptDto = deptService.getUserEmpDto();

    	//現在見ているページ
    	int selectPage = 1;
    	String errorMessage = null;

    	if (request.getParameter("pageNo") != null){
    		//現在選択されているページを取得
    		selectPage = Integer.parseInt(request.getParameter("pageNo"));
    	}

    	//現在選択されているページのユーザー情報を取得
    	pageDto = empService.getAllEmpData(selectPage, PAGE_COUNT);



    	if (request.getParameter("errorMessage") != null){
    		//リクエストへ格納されているエラーメッセージを取得する
    		errorMessage = request.getParameter("errorMessage");
    	}

    	userEmpDto = pageDto.getUserEmpDto();

		//Httpセッションへページ情報を格納する
        request.setAttribute("pageDto", pageDto);

    	//Httpセッションへ社員情報を格納する
        request.setAttribute("userEmpDto", pageDto.getUserEmpDto());

        //Httpセッションへ部署情報を格納する
        request.setAttribute("selectDeptDto", selectDeptDto);


		//Httpセッションへ部署情報を格納する
        request.setAttribute("errorMessage", errorMessage);

        HttpSession session = request.getSession(true);
        int authority = (Integer) session.getAttribute("authority");


        //Httpセッションへログイン情報を格納する
        Date date2 = new Date();
        System.out.println(date2.toString());
    	if ( authority == 2){
    		return mapping.findForward("manege");
    	}
    	//最悪一般にすべるように・・・
    	return mapping.findForward("general");



    }
}
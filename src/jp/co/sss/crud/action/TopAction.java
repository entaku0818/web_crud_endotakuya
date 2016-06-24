package jp.co.sss.crud.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.crud.dto.PagingDto;
import jp.co.sss.crud.dto.UserEmpDto;
import jp.co.sss.crud.form.TopForm;

import jp.co.sss.crud.service.DepartmentService;
import jp.co.sss.crud.service.EmployeeService;
import jp.co.sss.crud.service.PageService;

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

	public ActionForward execute(
        ActionMapping mapping,
        ActionForm form,
        HttpServletRequest request,
        HttpServletResponse response) {

		TopForm topForm = (TopForm) form;

    	EmployeeService empService = new EmployeeService();
    	DepartmentService deptService = new DepartmentService();
    	PageService pageService = new PageService();

    	//ユーザー情報を全件取得
    	UserEmpDto[] userEmpDto = empService.getAllEmpData();

    	//部署情報の動的なselectボタンのデータの生成
    	UserEmpDto[] selectDeptDto = deptService.getUserEmpDto();


		PagingDto pagingDto = pageService.getPagingInfo(userEmpDto, 5, topForm.getPageNo());


    	//Httpセッションへページング情報を格納する
        request.setAttribute("pagingDto", pagingDto);

    	//Httpセッションへ社員情報を格納する
        request.setAttribute("userEmpDto", userEmpDto);

        //Httpセッションへ部署情報を格納する
        request.setAttribute("selectDeptDto", selectDeptDto);

    	return mapping.findForward("success");
    }
}
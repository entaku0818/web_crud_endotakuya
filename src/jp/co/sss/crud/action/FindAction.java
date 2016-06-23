package jp.co.sss.crud.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
public final class FindAction extends Action {




	public ActionForward execute(
        ActionMapping mapping,
        ActionForm form,
        HttpServletRequest request,
        HttpServletResponse response) {

		TopForm topForm = (TopForm) form;

		EmployeeService empService = new EmployeeService();
    	DepartmentService deptService = new DepartmentService();
    	//

		String findColumn = topForm.getFindColumn();





		//ユーザー情報を全件取得
		UserEmpDto[] userEmpDto = empService.getAllEmpData(findColumn, topForm);

    	// 部署情報の動的なselectボタンのデータの生成
    	UserEmpDto[] selectDeptDto = deptService.getUserEmpDto();


    	if (userEmpDto.length <= 0){
    		boolean getTopDataFlag = true;

    		//検索結果が0件の場合、HttpセッションへFlagを格納する
    		request.setAttribute("getTopDataFlag", getTopDataFlag);
    	}


    		//Httpセッションへ社員情報を格納する
            request.setAttribute("userEmpDto", userEmpDto);

            //Httpセッションへ部署情報を格納する
            request.setAttribute("selectDeptDto", selectDeptDto);
            return (mapping.findForward("success"));

    }
}
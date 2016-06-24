package jp.co.sss.crud.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.crud.dto.SysDataDto;
import jp.co.sss.crud.dto.UserEmpDto;
import jp.co.sss.crud.form.ChangeForm;
import jp.co.sss.crud.service.EmployeeService;



import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.LookupDispatchAction;



public class UpdateAction extends LookupDispatchAction {

    protected Map<String, String> getKeyMethodMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("button.check", "check");
        map.put("button.finish", "finish");

        return map;
    }

    public ActionForward check(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

    	ChangeForm changeForm = (ChangeForm) form;
    	EmployeeService empService = new EmployeeService();

    	// Dto へ ChangeFormの内容を格納する
    	UserEmpDto userEmpDto = empService.chkInputData(changeForm);

    	request.setAttribute("userEmpDto", userEmpDto);

        return mapping.findForward("check");
    }


    /**
     *
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward finish(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

    	ChangeForm changeForm = (ChangeForm) form;
    	EmployeeService empService = new EmployeeService();

    	int count = empService.updateData(changeForm);
    	//更新処理成功
    	if (count > 0){
    		return mapping.findForward("finish");
        }else{
			SysDataDto SysDataDto = new SysDataDto();
			SysDataDto.setErrorMessage( "更新処理が失敗しました");
	        request.setAttribute("SysDataDto", SysDataDto);
        }


    	return mapping.findForward("error");


    }
}
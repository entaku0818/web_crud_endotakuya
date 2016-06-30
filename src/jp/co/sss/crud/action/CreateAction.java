package jp.co.sss.crud.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.crud.dto.UserEmpDto;
import jp.co.sss.crud.form.ChangeForm;
import jp.co.sss.crud.service.EmployeeService;




import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.LookupDispatchAction;


/**
 * 新規登録に関するアクションをまとめたクラス
 * @author Edu
 *
 */
public class CreateAction extends LookupDispatchAction {

    protected Map<String, String> getKeyMethodMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("button.create.check", "check");
        map.put("button.finish", "finish");

        return map;
    }

    /**
     *
     * @return
     * @throws Exception
     */
    public ActionForward check(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

    	ChangeForm changeForm = (ChangeForm) form;
    	EmployeeService empService = new EmployeeService();

    	// Dto へ ChangeFormの内容を格納する
    	UserEmpDto userEmpDto = empService.chkInputData(changeForm);


    	//Dtoの内容を画面へ表示
    	request.setAttribute("userEmpDto", userEmpDto);

        return mapping.findForward("check");
    }



    public ActionForward finish(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {


    	ChangeForm changeForm = (ChangeForm) form;
    	EmployeeService empService = new EmployeeService();

    	int count = empService.createData(changeForm);
    	// 作成確認
    	if (count > 0){
            return mapping.findForward("finish");

    	}
    	return mapping.findForward("error");
    }
}
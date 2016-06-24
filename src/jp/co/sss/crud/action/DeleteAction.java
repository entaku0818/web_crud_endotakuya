package jp.co.sss.crud.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.sss.crud.dto.SysDataDto;
import jp.co.sss.crud.form.TopForm;
import jp.co.sss.crud.service.EmployeeService;



import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.LookupDispatchAction;



public class DeleteAction extends LookupDispatchAction {

    protected Map<String, String> getKeyMethodMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("button.finish", "finish");

        return map;
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

    	//処理件数
    	int count = 0;

    	TopForm topForm = (TopForm) form;
    	EmployeeService empService = new EmployeeService();

    	//セッションで
    	HttpSession session = request.getSession(true);
    	int userId = (Integer) session.getAttribute("id");



    	//Httpセッションへ社員情報を格納する
		if(topForm.getFindId() != userId){
			//entityをDaoへ渡す
	    	count = empService.deleteData(topForm.getFindId(), userId);
		}else{
			SysDataDto SysDataDto = new SysDataDto();
			SysDataDto.setErrorMessage( "自分自身を削除することはできません。");
	        request.setAttribute("SysDataDto", SysDataDto);
		}



		//削除件数が一件あれば正常終了する
    	if(count ==1){
    		 return mapping.findForward("finish");
    	}


        return mapping.findForward("top");

    }


}
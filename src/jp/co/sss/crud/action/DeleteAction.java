package jp.co.sss.crud.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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


    	TopForm topForm = (TopForm) form;
    	EmployeeService empService = new EmployeeService();

        //取得したemployeeデータをリクエストへsetする
    	int count = empService.deleteData(topForm.getFindId());

    	if(count ==1){
    		 return mapping.findForward("finish");
    	}
        return mapping.findForward("error");

    }


}
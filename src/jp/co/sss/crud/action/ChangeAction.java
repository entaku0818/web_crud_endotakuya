package jp.co.sss.crud.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.sss.crud.dto.UserEmpDto;
import jp.co.sss.crud.form.ChangeForm;
import jp.co.sss.crud.form.TopForm;
import jp.co.sss.crud.service.DepartmentService;
import jp.co.sss.crud.service.EmployeeService;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.LookupDispatchAction;

public class ChangeAction extends LookupDispatchAction {

    protected Map<String, String> getKeyMethodMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("button.top", "top");
        map.put("button.create", "create");
        map.put("button.update", "update");
        map.put("button.delete", "delete");
        return map;
    }

    public ActionForward create(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

    	DepartmentService deptService = new DepartmentService();
    	//部署情報の動的なselectボタンのデータの生成
    	UserEmpDto[] selectDeptDto = deptService.getUserEmpDto();

        //Httpセッションへ部署情報を格納する
        request.setAttribute("selectDeptDto", selectDeptDto);

        return mapping.findForward("create");
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
    public ActionForward update(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {


    	DepartmentService deptService = new DepartmentService();
    	//部署情報の動的なselectボタンのデータの生成
    	UserEmpDto[] selectDeptDto = deptService.getUserEmpDto();
    	EmployeeService empService = new EmployeeService();


        UserEmpDto findEmp = new UserEmpDto();
        TopForm topForm = (TopForm) form;

        //Httpセッションへ部署情報を格納する
        request.setAttribute("selectDeptDto", selectDeptDto);



        //Topページで指定したFindIdを取得
        findEmp.setEmpId(topForm.getFindId());

        //Topページで指定したFindIdのデータを取得
        UserEmpDto userEmpDto = empService.getEmpData("empId",  findEmp);

        request.setAttribute("userEmpDto", userEmpDto);

    	return mapping.findForward("update");
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
    public ActionForward delete(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {


        TopForm topForm = (TopForm) form;

    	UserEmpDto findEmp = new UserEmpDto();
    	findEmp.setEmpId(topForm.getFindId());



    	EmployeeService empService = new EmployeeService();

    	//Topページで指定したFindIdのemployeeデータを取得
        UserEmpDto userEmpDto = empService.getEmpData("empId",  findEmp);

        //取得したemployeeデータをリクエストへsetする
    	request.setAttribute("userEmpDto", userEmpDto);


        return mapping.findForward("delete");


    }

    /**
     * TopActionへ遷移させる
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward top(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {


    	//TopActionへ遷移させる


        return mapping.findForward("top");
    }


}
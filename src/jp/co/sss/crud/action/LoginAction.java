package jp.co.sss.crud.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import jp.co.sss.crud.form.LoginForm;
import jp.co.sss.crud.service.LoginService;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class LoginAction extends Action {



    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        LoginForm loginForm = (LoginForm) form;

        int id = loginForm.getId();
        String password = loginForm.getPassword();


        LoginService ls = new LoginService();

        if(ls.login(id,password)){

        	//Httpセッションへログイン情報を格納する
            HttpSession session = request.getSession(true);
            request.setAttribute("id", id);
            request.setAttribute("session", session.getId());


        	return mapping.findForward("success");
        }


        return mapping.findForward("error");
    }
}
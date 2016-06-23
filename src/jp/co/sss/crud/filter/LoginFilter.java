package jp.co.sss.crud.filter;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.sss.crud.db.DBManager;

public class LoginFilter implements Filter {

    public void init(FilterConfig filterConfig)
            throws ServletException {

        //何もしない
    }

    public void doFilter(ServletRequest request,
            ServletResponse response, FilterChain chain)
            throws IOException, ServletException {


        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = (HttpSession) req.getSession();


        //sessionからidが取得できなければ、ログインしていないとみなす
        if(session.getAttribute("id") == null){

        	String errorMessage = "セッションが切断されました。再度ログインしてください。";
        	request.setAttribute("errorMessage", errorMessage);

        	res.sendRedirect(req.getContextPath());
        	return;

        }





        //ログインしているのでそのまま遷移
        chain.doFilter(req, res);
        return;
    }

    public void destroy() {
        //何もしない
    }

}

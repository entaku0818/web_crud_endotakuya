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

public class AuthorityFilter implements Filter {

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

        int authority = 0;

        authority = (Integer) session.getAttribute("authority");

        if(authority != 2){

        	String errorMessage = "管理者以外のユーザーのため、操作を実行できません";

        	req.setAttribute("errorMessage", errorMessage);

            //セッションがないのでログイン画面へ遷移"
            res.sendRedirect( req.getContextPath() + "/employee/top.do" );
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

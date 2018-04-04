package com.atm.progettoLogin.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ats.progettoLogin.beans.Utente;
import com.ats.progettoLogin.dao.DaoUtente;
import com.sun.crypto.provider.RSACipher;

/**
 * Servlet Filter implementation class FilterLogin
 */
@WebFilter("/ServletLogin")
public class FilterLogin implements Filter {
	DaoUtente dao=new DaoUtente();
	
    /**
     * Default constructor. 
     */
    public FilterLogin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest r= (HttpServletRequest) request;
		RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		String user=request.getParameter("user");
		Utente u= dao.getUtenteByUser(user);
		if(u==null) {
			r.getSession().setAttribute("messaggio", "Utente non trovato,inserire uno Username corretto");
			rd.include(request, response);
		}else {
			String password= request.getParameter("pass");
			if(u.getPassword().equals(password)) {
		chain.doFilter(request, response);}
			else {
				r.getSession().setAttribute("messaggio", "Password errata!!!!!");
				rd.include(request, response);
			}
	}}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

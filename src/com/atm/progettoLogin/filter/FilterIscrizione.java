package com.atm.progettoLogin.filter;

import java.io.IOException;
import java.rmi.dgc.Lease;

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
import javax.websocket.Session;

import com.ats.progettoLogin.beans.Utente;
import com.ats.progettoLogin.dao.DaoUtente;

/**
 * Servlet Filter implementation class FilterIscrizione
 */
@WebFilter("/FilterIscrizione")
public class FilterIscrizione implements Filter {
	DaoUtente dao=new DaoUtente();

    /**
     * Default constructor. 
     */
    public FilterIscrizione() {
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
		HttpSession s= r.getSession();
		RequestDispatcher rd=request.getRequestDispatcher("iscrizione.jsp");
		String user=request.getParameter("user");
		Utente u= dao.getUtenteByUser(user);
		if(u!=null) {
			r.getSession().setAttribute("messaggio", "username già presente, inserirne uno diverso");
			rd.include(request, response);
		}else {
			
		chain.doFilter(request, response);

	}}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

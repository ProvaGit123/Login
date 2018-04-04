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

import com.atm.progettoLogin.model.Model;
import com.ats.progettoLogin.beans.Utente;

/**
 * Servlet Filter implementation class FilterSearch
 */
@WebFilter("/ServletCerca")
public class FilterSearch implements Filter {

	Model model= new Model();
	/**
	 * Default constructor. 
	 */
	public FilterSearch() {
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
		String user=request.getParameter("user");
		Utente u= model.trovaUtente(user);
		System.out.println(user);

		System.out.println(u);
		if(u.getUser()==null) {
			s.setAttribute("messaggio", "username inesistente!!!");
			RequestDispatcher rd=request.getRequestDispatcher("trovaUtente.jsp");
			rd.include(request, response);
		}else {
			s.setAttribute("utente", u);
			chain.doFilter(request, response);

		}}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

package jhta.band_login.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/MakingBand/bandList_layout")
public class LoginFilter implements Filter{
	String encoding;
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("doFilter check");
		
		boolean login = false;
		
		request.setCharacterEncoding(encoding);
		if(encoding == null) {
			request.setCharacterEncoding("utf-8");
		}else {
			request.setCharacterEncoding(encoding);
		}
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		
		long login_num = (long)session.getAttribute("login_num");
		if(login_num <= 0) {
			login = true;
		}
		
		if(login) {
			chain.doFilter(request, response);
		}else {
			HttpServletResponse resp = (HttpServletResponse)response;
			resp.sendRedirect(req.getContextPath()+"/login/login.jsp");
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		encoding = filterConfig.getInitParameter("encoding");
		System.out.println("init check");
	}
}

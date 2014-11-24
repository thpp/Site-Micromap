package br.com.micromap.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Baseado nas instruções do myfaces.apache.org --> Error handling for MyFaces Core
 * 2.0 and later versions
 * 
 * @author Leticia Alves
 *
 */
@SuppressWarnings("serial")
public class RedirectServlet extends HttpServlet {
	private static final String URL_PREFIX = "url=";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String query = req.getQueryString();
		if (query.contains(URL_PREFIX)) {
			String url = query.replace(URL_PREFIX, "");
			if (!url.startsWith(req.getContextPath())) {
				url = req.getContextPath() + url;
			}

			resp.sendRedirect(url);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.utils.VerifyRecaptcha;

@WebServlet(
	description = "Login Servlet",
	urlPatterns = { "/login" },
	initParams = {
		@WebInitParam(name = "user", value = "admin"),
		@WebInitParam(name = "password", value = "1234") })
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String SECRET = "RECAPTCHA_SECRET";
	private static final String KEY = "RECAPTCHA_KEY";
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
	throws ServletException, IOException {

		// get request parameters for userID and password
		String user = req.getParameter("user");
		String pwd = req.getParameter("pwd");

		// get reCAPTCHA request param
		String gRecaptchaResponse = req.getParameter("g-recaptcha-response");
		System.out.println("gRecaptchaResponse: " + gRecaptchaResponse);
		String secret = ResourceBundle.getBundle("config").getString("RECAPTCHA_SECRET");
		boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse, secret);

		// get servlet config init params
		String userID = getServletConfig().getInitParameter("user");
		String password = getServletConfig().getInitParameter("password");

		// logging example
		System.out.println("User: " + user + ", password: " + pwd + ", Captcha Verify: "+verify);

		if (userID.equals(user) && password.equals(pwd) && verify) {
			res.sendRedirect("loginSuccess.jsp");

		} else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
			PrintWriter out = res.getWriter();
			if (verify) {
				out.println("<div class=\"alert alert-danger\">Either user name or password is wrong.</div>");
			} else {
				out.println("<div class=\"alert alert-danger\">You missed the Captcha.</div>");
			}

			rd.include(req, res);
		}
	}

}

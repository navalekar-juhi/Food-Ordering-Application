package com.neu.food;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.exception.UserException;
import com.neu.dao.UserDAO;
import com.neu.pojo.Customer;
import com.neu.pojo.User;

@Controller
public class LoginController {

	@Autowired
	UserDAO userDao;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String viewLoginForm(@ModelAttribute("user") User user) {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	protected String loginUser(HttpServletRequest request, @ModelAttribute("user") User user, BindingResult result)
			throws UserException {
		HttpSession session = request.getSession();
		System.out.print(user.getUserName());
		System.out.print(user.getUserPassword());
		try {
			User u = userDao.getDetails(user.getUserName(), user.getUserPassword());
			if (u==null) {
				return "error";
			}
			else if (u.getRole().equals("admin")) {
				session.setAttribute("user", u);
				return "admin-home";
			} else if (u.getRole().equals("customer")) {
				session.setAttribute("user", u);
				return "customer-home";
			} else {
				return "customer-home";
			}
		} catch (UserException e) {
			System.out.println("Exception: " + e.getMessage());
			session.setAttribute("errorMessage", "");
			return "error";
		}
	}
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        return "logout";
	}
}

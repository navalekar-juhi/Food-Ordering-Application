package com.neu.food;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.dao.CustomerDAO;
import com.neu.pojo.Customer;





@Controller
public class AddCustomerController {
	
	@Autowired
	CustomerDAO customerDao;

	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String viewSignUpForm(@ModelAttribute("customer") Customer customer){
		//ModelAndView mv = new ModelAndView();
		//mv.setViewName("register-user");
		return "register-user";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	protected ModelAndView registerNewUser(@ModelAttribute("customer") Customer customer, BindingResult result) throws Exception {
		
		System.out.print(customer.getfName());
		Customer cust = customerDao.addCustomer(customer);
		try {
			SendEmail(cust);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ModelAndView("register-success");
	}
	
	private void SendEmail(Customer ct) throws EmailException {
		Email email = new SimpleEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("juhitwilight@gmail.com", "edwardbella"));
		email.setSSLOnConnect(true);
		email.setFrom("juhitwilight@gmail.com");
		email.setSubject("Sign Up Successful");
        email.setMsg("Welcome to the Foodie\n\n Your account has been successfully created.");
		email.addTo(ct.getEmailId());
		email.send();
	}
}

package com.neu.food;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.dao.CustomerDAO;
import com.neu.dao.OrdersDAO;
import com.neu.exception.CustomerException;
import com.neu.exception.OrderException;
import com.neu.pojo.Customer;
import com.neu.pojo.OrderDetails;
import com.neu.pojo.Orders;
import com.neu.pojo.User;



@Controller
public class OrderController {
	@Autowired
	OrdersDAO ordersDao;
	@Autowired
	CustomerDAO customerDao;
	
	@RequestMapping(value = "/placeOrder", method = RequestMethod.GET)
	public String addItem(HttpServletRequest request) throws OrderException, CustomerException {
			HttpSession session = request.getSession();
			session.getAttribute("cartitems");
			Orders ordernew=new Orders();
			Set<OrderDetails> sOrderDetails= new HashSet<OrderDetails>();
			ArrayList<OrderDetails> addItem;
			User u= (User) session.getAttribute("user");
			Customer c = customerDao.getById(u.getUserId());
			session.setAttribute("customerdetails", c);
			ordernew.setCustomer(c);
			addItem = (ArrayList<OrderDetails>) session.getAttribute("cartitems");
            for(int i=0;i< addItem.size();i++) {
            	OrderDetails o= addItem.get(i);
            	o.setCustomerId(u.getUserId());
            	System.out.println(o.getItemName());
            	sOrderDetails.add(o); 	
            }
            ordernew.setOrderDetails(sOrderDetails);
         Orders orderitem = ordersDao.addOrders(ordernew);
         session.setAttribute("orderdetails", orderitem);
			return "success-order";
	
	}
}

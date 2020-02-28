package com.neu.food;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.dao.ItemDAO;
import com.neu.dao.RestaurantDAO;
import com.neu.exception.ItemException;
import com.neu.exception.RestaurantException;
import com.neu.pojo.Item;
import com.neu.pojo.OrderDetails;
import com.neu.pojo.Restaurant;
import com.neu.pojo.User;

@Controller
public class ItemController {
	@Autowired
	RestaurantDAO restaurantDao;
	@Autowired
	ItemDAO itemDao;
	
	@RequestMapping(value = "/additem", method = RequestMethod.GET)
	public String addItem(@ModelAttribute("item") Item item,HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("restaurantId", request.getParameter("restaurantid"));
		return "add-item";
	}
	@RequestMapping(value = "/additem", method = RequestMethod.POST)
	public String addItem(@ModelAttribute("item") Item item,HttpServletRequest request, BindingResult result) throws RestaurantException {
			HttpSession session = request.getSession();
			String rid=session.getAttribute("restaurantId").toString();
			System.out.print(rid);
			long restId = Long.parseLong(rid);		
			Restaurant r =restaurantDao.getById(restId);
			System.out.print(r.getrId());
			r.getMenuList().add(item);
			Restaurant rest= restaurantDao.updateItem(r);
			return "success-item";
	
	}
	@RequestMapping(value = "/viewitem", method = RequestMethod.GET)
	public ModelAndView viewRestaurants(@ModelAttribute("orderdetails") OrderDetails orderdetails,HttpServletRequest request) throws ItemException {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();	 
		session.setAttribute("restaurantId", request.getParameter("restaurantid"));
		session.setAttribute("restaurantName",request.getParameter("rname") );
		long rid=Long.parseLong(request.getParameter("restaurantid"));
		mv.addObject("itemList", itemDao.viewItemList(rid));
		mv.setViewName("view-items");
		return mv;
	}
	@RequestMapping(value = "/addCart", method = RequestMethod.GET)
	public ModelAndView addgetCart(@ModelAttribute("orderdetails") OrderDetails orderdetails,HttpServletRequest request) throws ItemException {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();	 	
		System.out.println((String)session.getAttribute("restaurantId"));
		long rid=Long.parseLong((String)session.getAttribute("restaurantId"));
		mv.addObject("itemList", itemDao.viewItemList(rid));
		mv.setViewName("view-items");
		return mv;
	}
	@RequestMapping(value = "/addCart", method = RequestMethod.POST)
	public String addCart(@ModelAttribute("orderdetails") OrderDetails orderdetails,HttpServletRequest request) throws ItemException {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();	
		session.getAttribute("cartitems");
		
		System.out.println(orderdetails.getItemName());
		boolean check = checkItems(session.getAttribute("cartitems"));
		if (check==true) {
			List<OrderDetails> od= new ArrayList<OrderDetails>();
			od.add(orderdetails);
			session.setAttribute("cartitems", od);
		}
		else {
			ArrayList items = (ArrayList)session.getAttribute("cartitems");
			items.add(orderdetails);
			session.setAttribute("cartitems", items);
		}
		return "view-cart";
	}
	public boolean checkItems(Object o) {
        if (o != null) {
            return false;
        } else {
            return true;
        }
    }
	@RequestMapping(value = "/removeCart", method = RequestMethod.GET)
	public String removeCart(@ModelAttribute("orderdetails") OrderDetails orderdetails,HttpServletRequest request) throws ItemException {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();	
		session.getAttribute("cartitems");
		String rmItem = request.getParameter("index");

		if (rmItem != null) {
            ArrayList<OrderDetails> rmvItem;
            rmvItem = (ArrayList<OrderDetails>) session.getAttribute("cartitems");
            int r = Integer.parseInt(rmItem);
            rmvItem.remove(r);
            session.setAttribute("cartitems",rmvItem);
        }
		return "view-cart";
	}

}

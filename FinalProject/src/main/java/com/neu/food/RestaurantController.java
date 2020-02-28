package com.neu.food;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.dao.RestaurantDAO;
import com.neu.exception.RestaurantException;
import com.neu.pojo.Restaurant;

@Controller
public class RestaurantController {
	
@Autowired
RestaurantDAO restaurantDao;

@RequestMapping(value = "/adminhome", method = RequestMethod.GET)
public String viewHome(@ModelAttribute("restaurant") Restaurant restaurant) {
	return "admin-home";
}

@RequestMapping(value = "/addRestaurant", method = RequestMethod.GET)
public String viewLoginForm(@ModelAttribute("restaurant") Restaurant restaurant) {
	return "add-restaurant";
}

@RequestMapping(value = "/addRestaurant", method = RequestMethod.POST)
public String addRestaurant(HttpServletRequest request, @ModelAttribute("restaurant") Restaurant restaurant, BindingResult result)throws RestaurantException {
	try {
		Restaurant r = restaurantDao.addRestaurant(restaurant);
		return "success-restaurant";
		
	} catch (RestaurantException e) {
		System.out.println("Exception: " + e.getMessage());
		return "error";
	}

}
@RequestMapping(value = "/viewRestaurant", method = RequestMethod.GET)
public ModelAndView viewRestaurants(HttpServletRequest request) throws RestaurantException {
	ModelAndView mv = new ModelAndView();
	mv.addObject("restaurantsList", restaurantDao.viewList());
	mv.setViewName("manage-restaurants");
	return mv;
}
@RequestMapping(value = "/customerViewRestaurant", method = RequestMethod.GET)
public ModelAndView customerViewRestaurant(HttpServletRequest request) throws RestaurantException {
	ModelAndView mv = new ModelAndView();
	mv.addObject("restaurantsList", restaurantDao.viewList());
	mv.setViewName("view-restaurants");
	return mv;
}
}
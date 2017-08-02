package com.user.controller;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.goldfarm.model.UserDetails;
import com.goldfarm.userdao.UserDAO;
import com.goldfarm.util.Util;

@SessionAttributes({ "table" })
@Controller
public class UserController {
	
	@Autowired
	UserDetails userDetails;

    private UserDAO userDAO;
	
	@Autowired(required=true)
	@Qualifier(value="userDAO")
	public void userDAO(UserDAO ps){
		this.userDAO = ps;
	}
	
 


@RequestMapping(value="/allusers", method = RequestMethod.GET) 
 public ModelAndView success(Model model)
 {
	
	 model.addAttribute("userDetails", new UserDetails());
		model.addAttribute("userDetailsList", this.userDAO.list());
	 return new ModelAndView("/user");
	
 }
 
@RequestMapping(value = "/add/user", method = RequestMethod.POST)
public String adduser(@ModelAttribute("userDetails") UserDetails userDetails) {

	Util util = new Util();
	String twitterusername = util.replace(userDetails.getTwitterusername(), ",", "");
	userDetails.setTwitterusername(twitterusername); 
	userDAO.saveOrUpdate(userDetails);

	return "redirect:/users";

}
@RequestMapping(value = "/users", method = RequestMethod.GET)
public String listusers(Model model) {
	model.addAttribute("userDetails", new UserDetails());
	model.addAttribute("userDetailsList", this.userDAO.list());
	 
	
	return "/user";//user
}

@RequestMapping("userdetails/edit/{twitterusername}")
public String editUser(@PathVariable("twitterusername") String twitterusername, Model model) {
	try{
		
	
	model.addAttribute("userDetails", new UserDetails());
	model.addAttribute("userDetails", this.userDAO.get(twitterusername));
	model.addAttribute("message1", "Successfully Deleted");
	model.addAttribute("userDetailsList", this.userDAO.list());
	model.addAttribute("message1", "Successfully Deleted");
	}
	catch(Exception e) {
		model.addAttribute("message", e.getMessage());
		e.printStackTrace();
		
	}

	return "/user";
}



@RequestMapping(value = "/editusers", method = RequestMethod.GET)
public String listeditusers(Model model) {
	model.addAttribute("userDetails", new UserDetails());
	model.addAttribute("userDetailsList", this.userDAO.list());
	 
	 
	return "/user";//user
}

@RequestMapping("userdetails/remove/{twitterusername}")
public String deleteuser(@PathVariable("twitterusername") String twitterusername, ModelMap model) throws Exception {

	try {
		userDAO.delete(twitterusername);
		model.addAttribute("message", "Successfully Deleted");
	} catch (Exception e) {
		model.addAttribute("message", e.getMessage());
		e.printStackTrace();
	}
	 
	return "redirect:/allusers";
}
@RequestMapping("userdetails/edit/userdetails/edit/{twitterusername}")
public String editUseragain(@PathVariable("twitterusername") String twitterusername, Model model) {
	
	model.addAttribute("userDetails", new UserDetails());
	model.addAttribute("userDetails", this.userDAO.get(twitterusername));
	model.addAttribute("userDetailsList", this.userDAO.list());
	return "/user";
}

}
 



 
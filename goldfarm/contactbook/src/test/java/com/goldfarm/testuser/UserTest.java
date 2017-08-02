package com.goldfarm.testuser;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.goldfarm.model.UserDetails;
import com.goldfarm.userdao.UserDAO;

public class UserTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();	
		context.scan("com.goldfarm");
		context.refresh();
		System.out.println("nfkjren");
		
		
		UserDAO userdao =   (UserDAO) context.getBean("userDAO");
		UserDetails userDetails=(UserDetails) context.getBean("userDetails");
		System.out.println("jxyz");
		
		userDetails.setName("shgdfe");
		userDetails.setEmailid("pogakularjesh5@gmail.com");
		userDetails.setPhonenumber("7996588578");
		userDetails.setTwitterusername("rajesh");
		userdao.saveOrUpdate(userDetails);
		 
	}

}

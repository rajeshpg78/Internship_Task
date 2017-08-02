package com.goldfarm.userdao;

import java.util.List;

import com.goldfarm.model.UserDetails;

public interface UserDAO {
	
	public void saveOrUpdate(UserDetails userDetailsuser);

	public void delete(String twitterusername);
	public void edit(String twitterusername);
	public UserDetails get(String twitterusername);

	public List<UserDetails> list();

	 
	 
}

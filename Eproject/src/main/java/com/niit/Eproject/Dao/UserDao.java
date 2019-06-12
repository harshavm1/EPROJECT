package com.niit.Eproject.Dao;

import java.util.List;

import com.niit.Eproject.Model.User;

public interface UserDao {

	public boolean saveorupdateauthentication(User user);
	public boolean deleteauthentication(User user);
	public User getUser(String userId);
	public List<User> userList();
	public User isvalidate(String userName,String password);
	public User getemail(String email);
}

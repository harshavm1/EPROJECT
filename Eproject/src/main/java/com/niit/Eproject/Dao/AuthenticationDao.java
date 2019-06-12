package com.niit.Eproject.Dao;

import java.util.List;

import com.niit.Eproject.Model.Authentication;

public interface AuthenticationDao {
	

	public boolean saveorupdateauthentication(Authentication authentication);
	public boolean deleteauthentication(Authentication authentication);
	public Authentication getAuthentication(String roleId);
	public List<Authentication> authenticationList();
}

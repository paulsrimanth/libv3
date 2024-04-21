package com.libmanagement.repository.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.libmanagement.model.Admin;
import com.libmanagement.model.EndUser;
import com.libmanagement.repository.Adminrepository;
import com.libmanagement.repository.EndUserRepository;
@Service
public class AdminAuthService 
{
	private final PasswordEncoder passwordEncoder;
	private final EndUserRepository enduserrepo;
	private final Adminrepository adminrepo;
	private final EndUserImpl enduserimpl;

	
	public AdminAuthService(PasswordEncoder passwordEncoder, EndUserRepository enduserrepo, Adminrepository adminrepo,
			EndUserImpl enduserimpl) {
		super();
		this.passwordEncoder = passwordEncoder;
		this.enduserrepo = enduserrepo;
		this.adminrepo = adminrepo;
		this.enduserimpl = enduserimpl;
	}

	/*
	 * Admin creates the enduser
	 * input json consits user details and admin id
	 * we search admin id and post that in adminby
	 */
	public EndUser EndUserRegByAdmin(EndUser request) {
		int adminId = request.getAdminid();
		Admin adminby = adminrepo.findById(adminId).orElseThrow();
		EndUser enduser = new EndUser();
		enduser.setAdminid(request.getAdminid());
		enduser.setEmail(request.getEmail());
		enduser.setName(request.getName());
		enduser.setPassword(passwordEncoder.encode(request.getPassword()));
		enduser.setAdmin(adminby);
		enduserrepo.save(enduser);
		return enduserrepo.save(enduser);
		
	}
}

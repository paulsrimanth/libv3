package com.libmanagement.repository.service;

import org.springframework.stereotype.Component;

import com.libmanagement.model.EndUser;
import com.libmanagement.repository.EndUserRepository;

@Component
public class EndUserImpl implements EndUserInterface{
	EndUserRepository endrepo;
	

	public EndUserImpl(EndUserRepository endrepo) {
		super();
		this.endrepo = endrepo;
	}


	@Override
	public EndUser createenduser(EndUser enduser) {
		
		return endrepo.save(enduser);
	}

}

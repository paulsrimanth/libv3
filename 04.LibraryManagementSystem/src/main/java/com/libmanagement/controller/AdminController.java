package com.libmanagement.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.libmanagement.model.EndUser;
import com.libmanagement.repository.service.AdminAuthService;

@CrossOrigin
@RestController
public class AdminController
{
	 private final AdminAuthService adminauth;
	
	
	public AdminController(AdminAuthService adminauth) {
		super();
		this.adminauth = adminauth;
	}


	@PostMapping("/userregister")
    public ResponseEntity<EndUser> userregister(
            @RequestBody EndUser request
            ) {
    	
        return ResponseEntity.ok(adminauth.EndUserRegByAdmin(request));
    }
	 
}

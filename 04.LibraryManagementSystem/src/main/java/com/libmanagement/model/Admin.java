package com.libmanagement.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"userdata"})
@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer aid;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private Integer powerId;
	@ManyToOne
	@JoinColumn(name="poweruser_id")
	private PowerUser poweruser;
	
	@OneToMany(mappedBy="admin")
	private List<EndUser> userdata;
	

	

	
	
	
}

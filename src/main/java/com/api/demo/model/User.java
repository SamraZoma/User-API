package com.api.demo.model;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "user")
@NamedQuery(name = "User.findByTheUsersName", query = "from User u where u.id = ?1")
public class User {
	
	@Id
	String  id ;
	
	@Column(name = "first_name" , nullable = false)
	String firstName ;
	
	@Column(name = "last_name" , nullable = false)
	String lastName ;
	
	@Column(name = "email", unique=true ,nullable = false)
	String email ;
	
	@Column(name ="marketing_consent")
	boolean marketingConsent ;
	
	

	public User(String firstName, String lastName, String email, boolean marketingConsent, String accessToken) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.marketingConsent = marketingConsent;
		
	}

	public User() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isMarketingConsent() {
		return marketingConsent;
	}

	public void setMarketingConsent(boolean marketingConsent) {
		this.marketingConsent = marketingConsent;
	}



}

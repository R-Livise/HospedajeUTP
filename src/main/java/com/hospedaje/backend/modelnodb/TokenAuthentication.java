/**
 * 
 */
package com.hospedaje.backend.modelnodb;

import java.util.Set;


/**
 * @author rafael
 *
 */
public class TokenAuthentication {
	
	
	
	public TokenAuthentication(String jwt, String email, Set<?> roles) {
		super();
		this.jwt = jwt;
		this.email = email;
		this.roles = roles;
	}
	private final String jwt;
	private final String email; 
	private final Set<?> roles;
	
	public String getJwt() {
		return jwt;
	}
	public String getEmail() {
		return email;
	}
	public Set<?> getRoles() {
		return roles;
	}
		
	
}

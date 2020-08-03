/**
 * 
 */
package com.hospedaje.backend.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hospedaje.backend.model.UserAdministrator;
import com.hospedaje.backend.model.UserHotel;
import com.hospedaje.backend.modelnodb.TokenAuthentication;
import com.hospedaje.backend.service.MyUserDetailService;
import com.hospedaje.backend.util.JwtUtil;

import io.swagger.annotations.Api;

/**
 * @author rafael
 *
 */
@RestController
@Api(tags = "login")
public class LoginController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private MyUserDetailService userDetailsService;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> createToken(@RequestBody UserAdministrator user) throws Exception {

		System.out.println("login");
		try {
			
			authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));

		} catch (BadCredentialsException e) {
			throw new Exception("usuario o contraseña incorrectas", e);

		}
		System.out.println("asdas");
		UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity
				.ok(new TokenAuthentication(jwt, userDetails.getUsername(), (Set) userDetails.getAuthorities()));

	}
}

/**
 * 
 */
package com.hospedaje.backend.service;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hospedaje.backend.model.Rol;
import com.hospedaje.backend.model.UserHotel;
import com.hospedaje.backend.repository.IUserRepository;


/**
 * @author rafael
 *
 */
@Service
@Transactional
public class MyUserDetailService implements UserDetailsService{

	@Autowired
	private IUserRepository _userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String nickname) throws UsernameNotFoundException {
		
		System.out.println("userDetail");
		
		UserHotel userH = _userRepository.findByNickname(nickname);
		if (userH == null) {System.out.println("Esta vacio");}
		
		System.out.println(userH.getEmail());
		System.out.println(userH.getPassword());		
		
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Rol role : userH.getRol()){
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
            System.out.println(role.getName());
        }
		
		return new User(userH.getEmail(),userH.getPassword(), grantedAuthorities);
//		return new User("foo","foo", new ArrayList<>());
	}

	
}

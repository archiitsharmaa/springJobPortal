package com.springJobPortal.customer;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings("serial")
//user dertails reporitory
public class MyUserDetails implements UserDetails {

	private Customer customer;

	// fetches details
	public MyUserDetails(Customer customer) {
		this.customer = customer;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(customer.getRole());
		return Arrays.asList(authority);
	}

	// gets passeord
	@Override
	public String getPassword() {
		return customer.getPassword();
	}

	// gets username
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return customer.getUsername();
	}

	// configs to enable account
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}

package com.fpoly.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fpoly.entities.Account;
import com.fpoly.repositories.AccountRepository;

@Service
public class SecurityUserDetailsService implements UserDetailsService{
	@Autowired
	private AccountRepository accRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Account account = accRepo.findByEmailEquals(email);
		if(account==null) {
			throw new UsernameNotFoundException("Invalid username or password");
		}

        return new UserDetailImp(account);
	}

}

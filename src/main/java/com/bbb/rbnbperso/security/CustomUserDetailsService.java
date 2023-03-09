package com.bbb.rbnbperso.security;

import com.bbb.rbnbperso.entities.AppUser;
import com.bbb.rbnbperso.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException(email));
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        appUser.getListRoles().forEach(r->authorities.add(new SimpleGrantedAuthority(r.getRoleName())));
        return new User(appUser.getEmail(), appUser.getPassword(), authorities);
    }
}

package com.sadullaev.webProject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sadullaev.webProject.model.User;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = usersRepository.findByUsername(username);

        //Set<GrantedAuthority> roles = new HashSet();
        //roles.add(new SimpleGrantedAuthority(UserRoleEnum.USER.name()));

        //UserDetails userDetails =
        //        new org.springframework.security.core.userdetails.User(user.getUsername(), 
        //                                                               user.getPassword(), 
       //                                                                roles);
        
        
        return user;
    }

}

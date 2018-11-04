package com.example.polls.security;

import com.example.polls.exception.ResourceNotFoundException;
import com.example.polls.model.Operator;
import com.example.polls.repository.OperatorRepository;
import com.example.polls.service.OperatorService;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by rajeevkumarsingh on 02/08/17.
 */

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    OperatorService operatorService;
    
    private Logger logger=LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        // Let people login with either username or email
        Operator operator=operatorService.findByUsername(username);
        List<GrantedAuthority> authorities=new ArrayList();
        if(operator.getType()==0) {
        	 authorities.add(new SimpleGrantedAuthority("ROLE_OPERATOR"));
        }
        if(operator.getType()==1) {
       	 authorities.add(new SimpleGrantedAuthority("ROLE_SUPERVISOR"));
       }
        if(operator.getType()==2) {
       	 authorities.add(new SimpleGrantedAuthority("ROLE_ACOPERATOR"));
       }
       
        System.out.println("Inside security");
        logger.debug("inside security");
        User user=new User(username, operator.getPassword(), authorities);
        return user;
       
    }

   
}
package com.makerwei.service;

import com.makerwei.entity.Admin;
import com.makerwei.repository.AdminRepo;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weixianbin on 16/10/23.
 */
@Service
public class UserMangerService implements UserDetailsService {
    @Autowired
    private AdminRepo adminRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminRepo.findByUsername(username);
        if (admin == null){
            throw new UsernameNotFoundException(username + "not found");
        }

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("USER"));
        System.out.print("__________++++++"+admin.getUsername()+admin.getPassword());
        return new User(admin.getUsername(),admin.getPassword(),authorities);
    }
}

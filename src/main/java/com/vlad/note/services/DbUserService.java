package com.vlad.note.services;

import com.vlad.note.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
//Проверка пользователей для basic авторизации
@Component
public class DbUserService implements UserDetailsService {
    @Autowired
    private UserRepo repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.vlad.note.domain.User user=repository.findByLogin(username);
        if(user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("user"));

        return new User(user.getLogin(), user.getPassword(), authorities);

    }
}

package cn.project.service.impl;

import cn.project.entity.Role;
import cn.project.entity.User;
import cn.project.service.UserService;
import com.alibaba.druid.filter.config.ConfigTools;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.SQLOutput;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        User user = userService.getUser(username);
        if (user == null || user.getId() < 1) {
            throw new UsernameNotFoundException("Username not found: "
                    + username);
        }

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), true, true, true, true,
                getGrantedAuthorities(user));
    }

    private Collection<? extends GrantedAuthority> getGrantedAuthorities(
            User user) {
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        for (Role role : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        }
        return authorities;
    }
/*
    public static void main(String[] args) {
        try {
            String pwd = "046118";
            String[] str = ConfigTools.genKeyPair(512);
            System.out.println("privateKey:" + str[0]);
            System.out.println("publicKey:" + str[1]);
            pwd = ConfigTools.encrypt(str[0], pwd);
            System.out.println("加密后的password:" + pwd);
            System.out.println("解密后的password:" + ConfigTools.decrypt(str[1],pwd));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
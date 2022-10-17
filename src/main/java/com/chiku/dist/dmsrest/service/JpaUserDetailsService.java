package com.chiku.dist.dmsrest.service;

import com.chiku.dist.dmsrest.dto.SecurityUserDto;
import com.chiku.dist.dmsrest.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class JpaUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public JpaUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByUserName(username).map(SecurityUserDto::new).orElseThrow(() -> new UsernameNotFoundException("User Name notfound" + username));
    }
}

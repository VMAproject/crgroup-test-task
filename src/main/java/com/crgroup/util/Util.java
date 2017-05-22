package com.crgroup.util;

import com.crgroup.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Arrays;
import java.util.Optional;


@Slf4j
public class Util {

    public static Optional<User> currentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication == null || !(authentication.getPrincipal() instanceof User) ? Optional.empty() : Optional.of((User) authentication.getPrincipal());
    }

    public static boolean hasAnyAuthority(String... authorities) {
        boolean ret = Arrays.stream(authorities).anyMatch(authority -> SecurityContextHolder.getContext()
                .getAuthentication().getAuthorities().contains(new SimpleGrantedAuthority(authority)));
        log.debug("checking current user \"{}\" authority againest {}, result: {} ", currentUser().get().getUsername(),
                Arrays.toString(authorities), ret);
        System.out.println(String.format("checking current user \"%s\" authority againest %s, result: %s", currentUser().get().getUsername(),
                Arrays.toString(authorities), ret));
        return ret;
    }
}
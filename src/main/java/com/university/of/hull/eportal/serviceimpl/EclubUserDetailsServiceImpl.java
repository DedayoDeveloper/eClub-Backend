package com.university.of.hull.eportal.serviceimpl;



import com.university.of.hull.eportal.dataentity.Clubs;
import com.university.of.hull.eportal.dataentity.Users;
import com.university.of.hull.eportal.repository.ClubRepository;
import com.university.of.hull.eportal.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class EclubUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ClubRepository clubRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = usersRepository.findByEmailAddress(email);
        Clubs club = clubRepository.findByClubEmail((email));
        if(user != null ) {
            return new org.springframework.security.core.userdetails.User(user.getEmailAddress(), user.getPassword(),
                    new ArrayList<>());
        }else if (club != null){
            return new org.springframework.security.core.userdetails.User(club.getClubEmail(), club.getPassword(),
                    new ArrayList<>());
        }
        throw new UsernameNotFoundException("User not found");
    }
}

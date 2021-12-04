package br.com.eduardowanderley.personregistration.config;

import br.com.eduardowanderley.personregistration.model.UserSecurity;
import br.com.eduardowanderley.personregistration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserDetailServiceImp implements UserDetailsService {

    @Autowired(required = true)
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserSecurity userSecurity = repository.findByUsername(username);

        if (userSecurity == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new User(userSecurity.getUsername(),
                userSecurity.getPassword(),
                true, true, true, true,
                userSecurity.getAuthorities());
    }

}

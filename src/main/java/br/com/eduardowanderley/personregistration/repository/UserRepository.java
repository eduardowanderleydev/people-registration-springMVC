package br.com.eduardowanderley.personregistration.repository;

import br.com.eduardowanderley.personregistration.model.UserSecurity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserSecurity, Long> {
    public UserSecurity findByUsername(String login);
}

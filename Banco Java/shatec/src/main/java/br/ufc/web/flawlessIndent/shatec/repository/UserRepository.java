package br.ufc.web.flawlessIndent.shatec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufc.web.flawlessIndent.shatec.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findFirstByLogin(String login);
}

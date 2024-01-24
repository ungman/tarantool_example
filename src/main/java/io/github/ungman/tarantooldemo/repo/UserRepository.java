package io.github.ungman.tarantooldemo.repo;

import io.github.ungman.tarantooldemo.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.tarantool.repository.Query;
import org.springframework.data.tarantool.repository.TarantoolRepository;


public interface UserRepository extends TarantoolRepository<User, String>, CrudRepository<User,String> {

	@Query(function = "findUserByLogin")
	User findUserByLogin(String login);

}

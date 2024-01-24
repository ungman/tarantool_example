package io.github.ungman.tarantooldemo.service;


import io.github.ungman.tarantooldemo.entity.User;
import io.github.ungman.tarantooldemo.repo.UserRepository;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public User get(String login) {
		return  userRepository.findUserByLogin(login);
	}

	public Set<User> getAll() {
		return  StreamSupport.stream(userRepository.findAll(Sort.unsorted()).spliterator(), false)
				.collect(Collectors.toSet());
	}

	public User insert(User user) {
		return userRepository.save(user);
	}

	public void delete(User user){
		userRepository.delete(user);
	}

}

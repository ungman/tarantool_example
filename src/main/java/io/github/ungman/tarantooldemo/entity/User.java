package io.github.ungman.tarantooldemo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.tarantool.core.mapping.Tuple;

@Tuple("users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	public String login;

	public String fio;

	public Integer id;

}

package com.elciocestari.jwt;

import com.elciocestari.jwt.models.Authority;
import com.elciocestari.jwt.models.User;
import com.elciocestari.jwt.repositories.AuthorityRepository;
import com.elciocestari.jwt.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class JwtApplication implements ApplicationRunner {

	@Autowired private UserRepository userRepository;
	@Autowired private AuthorityRepository authorityRepository;

	private List<Authority> authorities = new ArrayList<>();

	public static void main(String[] args) {
		try {
			SpringApplication.run(JwtApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		seedDataBase();
	}

	@Transactional
	private void seedDataBase() {
		seedAuthorities();
		seedUser();
	}

	private void seedAuthorities() {
		Authority roleUser = Authority.builder()
				.authorityName("ROLE_USER")
				.build();

		Authority roleAdmin = Authority.builder()
				.authorityName("ROLE_ADMIN")
				.build();

		this.authorities.addAll(Arrays.asList(roleAdmin,roleUser));
		this.authorityRepository.saveAll(authorities);
	}

	private void seedUser() {
		User user = User.builder()
				.username("Elcio")
				.nickname("elcio")
				.password("123456")
				.authorities(authorities)
				.build();

		this.userRepository.saveAll(Arrays.asList(user));
	}
}

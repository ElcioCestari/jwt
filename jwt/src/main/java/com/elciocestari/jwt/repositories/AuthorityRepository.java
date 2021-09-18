package com.elciocestari.jwt.repositories;

import com.elciocestari.jwt.models.Authority;
import com.elciocestari.jwt.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority,Long> {
}

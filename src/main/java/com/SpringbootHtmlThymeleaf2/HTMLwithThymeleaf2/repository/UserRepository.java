package com.SpringbootHtmlThymeleaf2.HTMLwithThymeleaf2.repository;

import com.SpringbootHtmlThymeleaf2.HTMLwithThymeleaf2.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByName(String name);
}
